package com.hzyazilimci.microservices.currencyexchangeservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyExchange {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionResult;
    private String environment;
}
