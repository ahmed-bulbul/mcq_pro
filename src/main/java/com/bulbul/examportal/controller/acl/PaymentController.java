package com.bulbul.examportal.controller.acl;


import com.bulbul.examportal.service.payment.SSLCommerz;
import com.bulbul.examportal.entity.payment.PaymentDetailsDTO;
import com.bulbul.examportal.utils.payments.ParameterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private ParameterBuilder parameterBuilder;
    @Autowired
    private SSLCommerz sslCommerz;

    public PaymentController() {
    }

    public PaymentController(ParameterBuilder parameterBuilder) {
        this.parameterBuilder = parameterBuilder;
    }

    @PostMapping("/")
    public String getPaymentGatewayLink(@RequestBody PaymentDetailsDTO paymentDetailsDTO) throws Exception {
        String paymentGatewayUrl = sslCommerz.initiateTransaction(parameterBuilder.constructRequestParameters(paymentDetailsDTO),false);
        System.out.println(paymentGatewayUrl);
        return paymentGatewayUrl;
    }

    @PostMapping("ssl-success-page")
    public ResponseEntity<?> success(){
        return ResponseEntity.ok("payment successfully completed");
    }
}

