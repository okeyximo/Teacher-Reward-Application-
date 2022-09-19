package com.example.rewardyourteachersq011bjavapode.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.example.rewardyourteachersq011bjavapode.utils.ListOfSchoolUtil.readAllSchoolsFromCsvFile;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Map<String , String> schools = readAllSchoolsFromCsvFile("src/main/resources/List Of Schools In Lagos - updated.csv");

            schools.forEach((school, address )-> {
              //  System.out.println("Name of school : "+ school + "Address: {}" + address);
             log.info("Name of school : {}  Address: {}" , school , address);
            });
    }
}
