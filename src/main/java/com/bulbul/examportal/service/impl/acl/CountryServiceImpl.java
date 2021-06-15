package com.bulbul.examportal.service.impl.acl;

import com.bulbul.examportal.repository.acl.CountryRepository;
import com.bulbul.examportal.entity.acl.Country;
import com.bulbul.examportal.entity.acl.Currency;
import com.bulbul.examportal.repository.acl.CurrencyRepository;
import com.bulbul.examportal.service.acl.CountryService;
import com.bulbul.examportal.utils.api.BaseUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private RestTemplate restTemplate;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    public CountryServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate=restTemplateBuilder.build();
    }

    @Override
    public Country[] createCountry() {
        List<Country> countryList = new ArrayList<>();
        List<Currency> currencyList= new ArrayList<>();
        Country[] countries = restTemplate.getForObject(BaseUrl.JSON_COUNTRY_URL,Country[].class);

        Long countryId=1L;
        for(Country country1:countries){
            for(Currency currency:country1.getCurrencies()){
                currency.setCId(countryId);
                currencyList.add(currency);
            }
            country1.setId(countryId++);
            countryList.add(country1);
        }
        currencyRepository.saveAll(currencyList);
        countryRepository.saveAll(countryList);
        return countries;
    }

    @Override
    public Country[] getAll() {
        Country[] country = restTemplate.getForObject(BaseUrl.JSON_COUNTRY_URL,Country[].class);
        for (Country country1: country){
            for(Currency currency:country1.getCurrencies()){
                System.out.println(currency.getName());
            }
        }
        return country;
    }
}

