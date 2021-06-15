package com.bulbul.examportal.controller.acl;


import com.bulbul.examportal.entity.acl.Country;
import com.bulbul.examportal.service.acl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping("/")
    public ResponseEntity<?> createCountry(){
        return ResponseEntity.ok(countryService.createCountry());
    }

    @GetMapping("/")
    public Country[] getAllCountries(){
        return countryService.getAll();
    }


}
