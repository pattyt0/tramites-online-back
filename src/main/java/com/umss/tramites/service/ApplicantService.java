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
    ApplicantRepository productoRepository;

    public List<Applicant> list(){
        return productoRepository.findAll();
    }

    public Optional<Applicant> getOne(int id){
        return productoRepository.findById(id);
    }

    public Optional<Applicant> getByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public void  save(Applicant producto){
        productoRepository.save(producto);
    }

    public void delete(int id){
        productoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return productoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return productoRepository.existsByNombre(nombre);
    }
}
