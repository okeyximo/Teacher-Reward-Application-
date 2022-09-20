package com.example.rewardyourteachersq011bjavapode;
import com.example.rewardyourteachersq011bjavapode.serviceImpl.SchoolServiceImpl;
import com.example.rewardyourteachersq011bjavapode.utils.ListOfSchoolUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@SpringBootApplication
@RequiredArgsConstructor
public class RewardYourTeacherSq011BJavaPodEApplication implements CommandLineRunner {


    private final   SchoolServiceImpl schoolService;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(RewardYourTeacherSq011BJavaPodEApplication.class, args);


       // schoolService.addSchool("src/main/resources/List Of Schools In Lagos - updated.csv");
    }


    @Override
    public void run(String... args) throws Exception {
        schoolService.addSchool("src/main/resources/List Of Schools In Lagos - updated.csv");
    }
}
