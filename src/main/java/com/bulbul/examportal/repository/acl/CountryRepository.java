package com.bulbul.examportal.repository.acl;

import com.bulbul.examportal.entity.acl.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
