package com.bulbul.examportal.repository.acl;

import com.bulbul.examportal.entity.acl.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
}
