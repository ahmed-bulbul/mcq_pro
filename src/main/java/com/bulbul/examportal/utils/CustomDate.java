package com.bulbul.examportal.utils;

import java.time.LocalDate;
import java.time.Period;

public class CustomDate {

    public static int differenceTwoDate(LocalDate startDate, LocalDate endDate){

        Period period = Period.between(endDate, startDate);
//
//        System.out.print(period.getYears() + " years,");
//        System.out.print(period.getMonths() + " months,");
      //  System.out.print(period.getDays() + " days");
        return period.getDays();
    }
}