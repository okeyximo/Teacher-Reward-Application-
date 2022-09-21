package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.dto.InitializeTransactionRequest;
import com.example.rewardyourteachersq011bjavapode.models.Transaction;
import com.example.rewardyourteachersq011bjavapode.response.InitializeTransactionResponse;
import com.example.rewardyourteachersq011bjavapode.response.VerifyTransactionResponse;
import com.example.rewardyourteachersq011bjavapode.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@Transactional
public class TransactionServiceImpl implements PaymentService {

    @Override
    public InitializeTransactionResponse initTransaction(InitializeTransactionRequest request) throws Exception {
        InitializeTransactionResponse initializeTransactionResponse = null;
        try {
            Gson gson = new Gson();
            StringEntity postingString = new StringEntity(gson.toJson(request));
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost("https://api.paystack.co/transaction/initialize");
            post.setEntity(postingString);
            post.addHeader("Content-type", "application/json");
            post.addHeader("Authorization", "Bearer sk_test_4a2b6bb287c3d6aea37c4416ffc07648c7a93c52");
            StringBuilder result = new StringBuilder();
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

            } else {
                throw new AuthenticationException("Error Occurred while initializing transaction");
            }
            ObjectMapper mapper = new ObjectMapper();

            initializeTransactionResponse = mapper.readValue(result.toString(), InitializeTransactionResponse.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Failure initializaing paystack transaction");
        }

        return initializeTransactionResponse;
    }

    @Override
    public VerifyTransactionResponse verifyTransaction(String reference) {
        Transaction transaction = new Transaction();
        VerifyTransactionResponse payStackResponse = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://api.paystack.co/transaction/verify/" + reference);
            request.addHeader("Content-type", "application/json");
            request.addHeader("Authorization", "Bearer " + "sk_test_4a2b6bb287c3d6aea37c4416ffc07648c7a93c52");
            StringBuilder result = new StringBuilder();
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
            } else {
                throw new Exception("Error Occurred while connecting to PayStack URL");
            }
            ObjectMapper mapper = new ObjectMapper();
            payStackResponse = mapper.readValue(result.toString(), VerifyTransactionResponse.class);
            if (payStackResponse == null || payStackResponse.getStatus().equals("false")) {
                throw new Exception("An error occurred while  verifying payment");
            } else if (payStackResponse.getData().getStatus().equals("success")) {

            // todo : Okeys part .
//                transaction.setAmount(payStackResponse.getData().getAmount().divide(BigDecimal.valueOf(100)));
//                transaction.setTransactionType(TransactionType.CREDIT);
//                Optional<Wallet> wallet = walletRepository.findById(user.getWallet().getId());
//                if (wallet.isPresent()){
//                    wallet.get().setBalance(wallet.get().getBalance().add(transaction.getAmount()));
//                    walletRepository.save(wallet.get());
//                }else
//                    throw new ResourceNotFound("wallet", "id", wallet.get().getId());
//                transaction.setUser(user);
//                transactionRepository.save(transaction);
//                notificationService.depositNotification(transaction.getId());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return payStackResponse;
    }
}
