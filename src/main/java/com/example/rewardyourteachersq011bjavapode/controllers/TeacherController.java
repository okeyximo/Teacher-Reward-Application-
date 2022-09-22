package com.example.rewardyourteachersq011bjavapode.controllers;


import com.example.rewardyourteachersq011bjavapode.dto.TeacherDetails;
import com.example.rewardyourteachersq011bjavapode.models.User;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.service.ITeacherService;
import com.example.rewardyourteachersq011bjavapode.service.UserService;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TeacherController {
    private final ITeacherService teacherService;


    @GetMapping("getAllWithPagination")
    public Page<TeacherDetails> getAllTeachersWithPagination(@RequestParam int pageNo,
                                                             @RequestParam int pageSize) {

        return teacherService.getAllTeachersWithPagination(pageNo, pageSize);
    }





    private final UserService userService;
    private final ResponseService<ApiResponse<List<User>>> responseService;

    @GetMapping("/search/{name}")
    public ResponseEntity<ApiResponse<List<User>>> searchTeacher(@PathVariable(value = "name")String name ){
        return responseService.response(userService.searchTeacher(name) , HttpStatus.OK);
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewTeacherProfile(@PathVariable(value ="id")Long id){
        return new ResponseEntity<>(userService.viewProfile(id), HttpStatus.OK);
    }

}
