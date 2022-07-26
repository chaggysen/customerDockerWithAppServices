package com.microsoftpoc.customdockerwithappservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microsoftpoc.customdockerwithappservice.enums.ConversionStatus;
import com.microsoftpoc.customdockerwithappservice.model.ConversionDao;
import com.microsoftpoc.customdockerwithappservice.services.VideoConverterService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/converter")
public class VideoConverterRestController {

    @Autowired
    VideoConverterService videoConverterService;
    

    @GetMapping("/convertmp4toavi")
    public ResponseEntity<String> convertMp4ToAvi (@RequestBody ConversionDao conversionDao){
        try{
            // data validation 
            if (conversionDao.getInputPath() == null || conversionDao.getOutputPath() == null){
                return ResponseEntity.badRequest().body("Please provide a valid input and output path");
            }

            ConversionStatus status = videoConverterService.convertMp4ToAvi(conversionDao.getInputPath(), conversionDao.getOutputPath());

            if (status.equals(ConversionStatus.SUCCESS)){
                return ResponseEntity.ok().body("Conversion is successful");
            } else {
                return ResponseEntity.badRequest().body("Conversion is not successful");
            }

        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Internal Server Error");
        }
    }
}
