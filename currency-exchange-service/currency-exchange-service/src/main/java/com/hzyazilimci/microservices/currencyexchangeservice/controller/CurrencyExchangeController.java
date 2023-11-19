package com.hzyazilimci.microservices.currencyexchangeservice.controller;

import com.hzyazilimci.microservices.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private Environment environment;

    @Autowired
    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable String from,
                                                                  @PathVariable String to){

        String portNumber = environment.getProperty("server.port");

        CurrencyExchange currencyExchange = CurrencyExchange.builder()
                .id(100L)
                .from("USD")
                .to("TRY")
                .conversionResult(BigDecimal.valueOf(28.59))
                .environment(portNumber)
                .build();

        return ResponseEntity.ok(currencyExchange);
    }
}
