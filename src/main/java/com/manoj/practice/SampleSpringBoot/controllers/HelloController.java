package com.manoj.practice.SampleSpringBoot.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/helloController")
public class HelloController {

    private static final Log LOG = LogFactory.getLog(HelloController.class);

    @GetMapping(path = "/introductionMessage")
    public ResponseEntity<String> homepage() {
        LOG.info("GET API call for introduction message...");
        return new ResponseEntity<>("Hello there !!", HttpStatus.OK);
    }

}
