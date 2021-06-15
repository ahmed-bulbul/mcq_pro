package com.bulbul.examportal.entity.payment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetailsDTO {

    private String total_amount;
    private String cus_name;
    private String cus_email;
    private String cus_add1;
    private String cus_add2;
    private String cus_city;
    private String cus_state;
    private String cus_postcode;
    private String cus_country;
    private String cus_phone;
    private String cus_fax;
    private String ship_name;



    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    public String getCus_add1() {
        return cus_add1;
    }

    public void setCus_add1(String cus_add1) {
        this.cus_add1 = cus_add1;
    }

    public String getCus_add2() {
        return cus_add2;
    }

    public void setCus_add2(String cus_add2) {
        this.cus_add2 = cus_add2;
    }

    public String getCus_city() {
        return cus_city;
    }

    public void setCus_city(String cus_city) {
        this.cus_city = cus_city;
    }

    public String getCus_state() {
        return cus_state;
    }

    public void setCus_state(String cus_state) {
        this.cus_state = cus_state;
    }

    public String getCus_postcode() {
        return cus_postcode;
    }

    public void setCus_postcode(String cus_postcode) {
        this.cus_postcode = cus_postcode;
    }

    public String getCus_country() {
        return cus_country;
    }

    public void setCus_country(String cus_country) {
        this.cus_country = cus_country;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public String getCus_fax() {
        return cus_fax;
    }

    public void setCus_fax(String cus_fax) {
        this.cus_fax = cus_fax;
    }

    public String getShip_name() {
        return ship_name;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }


}
