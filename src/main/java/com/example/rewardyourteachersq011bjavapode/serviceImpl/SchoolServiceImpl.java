package com.example.rewardyourteachersq011bjavapode.serviceImpl;

import com.example.rewardyourteachersq011bjavapode.dto.SchoolDTO;
import com.example.rewardyourteachersq011bjavapode.exceptions.ResourceNotFoundException;
import com.example.rewardyourteachersq011bjavapode.models.School;
import com.example.rewardyourteachersq011bjavapode.repository.SchoolRepository;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.service.SchoolService;
import com.example.rewardyourteachersq011bjavapode.utils.ListOfSchoolUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.rewardyourteachersq011bjavapode.utils.ListOfSchoolUtil.readAllSchoolsFromCsvFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
   // @PostConstruct
    public void addSchool(String csvPath) {
        List<SchoolDTO>schoolsToBeAdded = readAllSchoolsFromCsvFile(csvPath);
        List<School> schoolsInDatabase = schoolRepository.findAll();
        if(schoolsToBeAdded.size() > schoolsInDatabase.size()){
            schoolRepository.deleteAll();
            schoolsToBeAdded.forEach(school-> {
                schoolRepository.saveAndFlush(new School(school.getName() , school.getAddress() , school.getStateAndCountry(), school.getSchoolType()));
            });
            log.info("Schools  Added");
        }else{
            log.info("Schools Already  Added");
        }
    }

    @Override
    public ApiResponse<List<School>> getAllSchools() {
        List<School> schoolList = schoolRepository.findAll();
        return new ApiResponse<>("success" , LocalDateTime.now() , schoolList);
    }

    public School findSchoolByName(String name){
        return  schoolRepository.findByName(name).orElseThrow(()-> new ResourceNotFoundException(name + " not found"));
    }

}
