package com.provectus.datadogintegration;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @RequestMapping(value = "/test")
    @Timed(longTask=true, value="testic")
    public void getTest(){

    }
}
