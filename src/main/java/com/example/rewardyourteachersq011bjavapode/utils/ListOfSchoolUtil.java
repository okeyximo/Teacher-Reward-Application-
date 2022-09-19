package com.example.rewardyourteachersq011bjavapode.utils;


import lombok.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class ListOfSchoolUtil {

    private static BufferedReader reader;
    private static String line;

    public ListOfSchoolUtil() {

    }


    public static Map<String , String> readAllSchoolsFromCsvFile(String path){
        Map<String, String> schools = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(path));
            String[] data = new String[0];
            while((line = reader.readLine()) != null){
                while((line = reader.readLine()) != null){
                    data = line.split(",");
                    schools.put(data[0] , data[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return schools;
    }
}
