package com.bulbul.examportal.service.acl;
import com.bulbul.examportal.entity.acl.Country;

public interface CountryService {

    public Country[] createCountry();

    public Country[] getAll();
}
