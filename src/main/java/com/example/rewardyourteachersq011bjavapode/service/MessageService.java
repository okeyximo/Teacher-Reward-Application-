package com.example.rewardyourteachersq011bjavapode.service;

import com.example.rewardyourteachersq011bjavapode.models.Message;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;

public interface MessageService {
    ApiResponse<Message> sendAppreciationToStudent(Long sender_id , Long user_id, String message);
}
