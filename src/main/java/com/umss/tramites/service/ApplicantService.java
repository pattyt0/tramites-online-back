package com.umss.tramites.service;

import com.umss.tramites.entity.Applicant;
import com.umss.tramites.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;

    public List<Applicant> list(){
        return applicantRepository.findAll();
    }

    public Optional<Applicant> getOne(int id){
        return applicantRepository.findById(id);
    }

    public Optional<Applicant> getByName(String name){
        return applicantRepository.findByName(name);
    }

    public void  save(Applicant paperwork){
        applicantRepository.save(paperwork);
    }

    public void delete(int id){
        applicantRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return applicantRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return applicantRepository.existsByName(name);
    }
}
