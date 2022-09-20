package com.example.rewardyourteachersq011bjavapode.utils;

import com.example.rewardyourteachersq011bjavapode.dto.SchoolDTO;
import com.example.rewardyourteachersq011bjavapode.models.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.example.rewardyourteachersq011bjavapode.utils.ListOfSchoolUtil.readAllSchoolsFromCsvFile;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<SchoolDTO> schools = readAllSchoolsFromCsvFile("src/main/resources/List Of Schools In Lagos - updated.csv");

            schools.forEach((school)-> {
              //  System.out.println("Name of school : "+ school + "Address: {}" + address);
             log.info("Name of school : {}  Address: {} Country: {} Type: {} " , school.getName() , school.getAddress() , school.getStateAndCountry() , school.getSchoolType());
            });
    }
}
