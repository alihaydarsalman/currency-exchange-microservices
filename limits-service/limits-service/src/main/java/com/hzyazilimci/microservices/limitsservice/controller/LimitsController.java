package com.hzyazilimci.microservices.limitsservice.controller;

import com.hzyazilimci.microservices.limitsservice.bean.Limits;
import com.hzyazilimci.microservices.limitsservice.configuration.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LimitsController {

    private Config config;

    @Autowired
    public LimitsController(Config config) {
        this.config = config;
    }

    @GetMapping("/limits")
    public ResponseEntity<List<Limits>> retrieveLimits(){
        return ResponseEntity.ok(Arrays.asList(new Limits(1,100), new Limits(config.getMinimum(), config.getMaximum())));
    }
}
