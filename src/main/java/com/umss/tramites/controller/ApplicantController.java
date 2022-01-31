package com.umss.tramites.controller;

import com.umss.tramites.dto.ApplicantDto;
import com.umss.tramites.dto.Message;
import com.umss.tramites.entity.Applicant;
import com.umss.tramites.service.ApplicantService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paperwork")
@CrossOrigin("http://localhost:4200")
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets the list of applicants",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Applicant.class))})})
    @GetMapping("/list")
    public ResponseEntity<List<Applicant>> list() {
        List<Applicant> list = applicantService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets an applicant by ID",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Applicant.class))})})
    @GetMapping("/detail/{id}")
    public ResponseEntity<Applicant> getById(@PathVariable("id") int id) {
        if (!applicantService.existsById(id))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        Applicant paperwork = applicantService.getOne(id).get();
        return new ResponseEntity(paperwork, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets an applicant by name",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Applicant.class))})})
    @GetMapping("/detailname/{name}")
    public ResponseEntity<Applicant> getByName(@PathVariable("name") String name) {
        if (!applicantService.existsByName(name))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        Applicant paperwork = applicantService.getByName(name).get();
        return new ResponseEntity(paperwork, HttpStatus.OK);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Creates applicant",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Applicant.class))})})
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ApplicantDto applicantDto) {
        if (StringUtils.isBlank(applicantDto.getName()))
            return new ResponseEntity(new Message("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (applicantDto.getCi() <= 0)
            return new ResponseEntity(new Message("el ci es invalido"), HttpStatus.BAD_REQUEST);
        Applicant paperwork = new Applicant(applicantDto.getCi(), applicantDto.getName(),
                applicantDto.getFatherLastName(), applicantDto.getMotherLastName(), applicantDto.getEmail(),
                applicantDto.getCellphone(), applicantDto.getPhone());
        applicantService.save(paperwork);
        return new ResponseEntity(new Message("solicitante creado"), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletes an applicant by ID",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Applicant.class))})})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!applicantService.existsById(id))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        applicantService.delete(id);
        return new ResponseEntity(new Message("solicitante eliminado"), HttpStatus.OK);
    }
}
