package com.example.rewardyourteachersq011bjavapode.serviceImpl;
import com.example.rewardyourteachersq011bjavapode.config.Security.JwtUtil;
import com.example.rewardyourteachersq011bjavapode.dto.LoginDTO;
import com.example.rewardyourteachersq011bjavapode.dto.PrincipalDto;
import com.example.rewardyourteachersq011bjavapode.exceptions.ResourceNotFoundException;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.service.AuthService;
import com.example.rewardyourteachersq011bjavapode.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserUtil userUtil;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    @Override
    public ApiResponse<PrincipalDto> loginUser(LoginDTO loginDTO) {
        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
            );
        } catch (AuthenticationException ex) {
            log.error(ex.getMessage());
            throw new ResourceNotFoundException("Invalid username or password");
        }
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        User loggedInUser = userUtil.getUserByEmail(loginDTO.getEmail());

        return new ApiResponse<>("success", LocalDateTime.now(), new PrincipalDto(loggedInUser.getId(), loggedInUser.getName(), loggedInUser.getEmail(), jwtUtil.generateToken(loginDTO.getEmail())));

    }

}
