package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.dto.SchoolDTO;
import com.example.rewardyourteachersq011bjavapode.dto.UserDto;
import com.example.rewardyourteachersq011bjavapode.models.School;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.response.UserRegistrationResponse;
import com.example.rewardyourteachersq011bjavapode.serviceImpl.SchoolServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@Slf4j
public class SchoolController {

    private final SchoolServiceImpl schoolService;

    @GetMapping(value = "/schools/{page}/{size}/{sortBy}")
    public ResponseEntity<ApiResponse<Page<School>>> getAllSchools(@PathVariable(value = "page") int page , @PathVariable(value = "size") int size, @PathVariable(value="sortBy") String sortBy){
        return new ResponseEntity<>(schoolService.getAllSchools(page, size , sortBy) , OK);
    }

    @PostMapping(value = "/schools/update/{id}")
    ResponseEntity<?> updateSchool(@PathVariable(value ="id")Long id , @RequestBody SchoolDTO schoolDTO) {
        log.info("Successfully Updated {} ", schoolDTO.getName());
        return new ResponseEntity<>(schoolService.updateSchool(id , schoolDTO), OK);
    }
}