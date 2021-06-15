package com.bulbul.examportal.service.payment;

import com.bulbul.examportal.entity.payment.PaymentDetailsDTO;
import com.bulbul.examportal.utils.payments.ParameterBuilder;

import java.util.Map;

public class TransactionInitiator {

    private PaymentDetailsDTO paymentDetailsDTO;

    public String initTrnxnRequest() {
        String response = "";
        try {
            /**
             * All parameters in payment order should be constructed in this follwing postData Map
             * keep an eye on success fail url correctly.
             * insert your success and fail URL correctly in this Map
             */
            Map<String, String> postData = ParameterBuilder.constructRequestParameters(paymentDetailsDTO);
            /**
             * Provide your SSL Commerz store Id and Password by this following constructor.
             * If Test Mode then insert true and false otherwise.
             */
            SSLCommerz sslcz = new SSLCommerz("bdsof60729f7f07943", "bdsof60729f7f07943@ssl", true);

            /**
             * If user want to get Gate way list then pass isGetGatewayList parameter as true
             * If user want to get URL as returned response, pass false.
             */
            response = sslcz.initiateTransaction(postData, false);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
