package com.provectus.datadogintegration;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Test {

    @Autowired
    private MeterRegistry meterRegistry;

    @PostConstruct
    public  void init() {

        //metrics every 10 seconds
        meterRegistry.gauge("test nik metric", 12);

        // metrics once
        Counter counter = meterRegistry.counter("grgdfgdgdfgdfgdfggdf", "size", "1");
        counter.increment();

        // no metrics
        Counter test = meterRegistry.counter("testisshee");
        test.count();
    }

}
