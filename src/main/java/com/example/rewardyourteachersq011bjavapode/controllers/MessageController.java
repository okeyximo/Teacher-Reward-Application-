package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.PrincipalDto;
import com.example.rewardyourteachersq011bjavapode.models.Message;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.serviceImpl.MessageServiceImplementation;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class MessageController {
    private final ResponseService<ApiResponse<Message>> responseService;

    private final MessageServiceImplementation messageServiceImplementation;

    @PostMapping(value = "/appreciate-student/{sender_id}/{receiver_id}")
    public ResponseEntity<ApiResponse<Message>> sendAppreciation(@PathVariable(value = "sender_id") Long sender_id ,@PathVariable(value = "receiver_id") Long receiver_id , @RequestParam String message){
        return responseService.response(messageServiceImplementation.sendAppreciationToStudent(sender_id , receiver_id, message) , HttpStatus.OK);
    }


}
