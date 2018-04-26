package com.provectus.datadogintegration;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.statsd.StatsdConfig;
import io.micrometer.statsd.StatsdFlavor;
import io.micrometer.statsd.StatsdMeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatadogIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatadogIntegrationApplication.class, args);
    }

    @Bean
    public StatsdConfig statsConfig() {
        StatsdConfig config = new StatsdConfig() {
            @Override
            public String get(String k) {
                if (k.equals("statsd.port")) {
                    return "5044";
                } else {
                    return null;
                }
            }

            @Override
            public StatsdFlavor flavor() {
                return StatsdFlavor.DATADOG;
            }
        };
        return config;
    }


    @Bean
    public MeterRegistry meterRegistry(StatsdConfig config) {
        MeterRegistry registry = new StatsdMeterRegistry(config, Clock.SYSTEM);
        return registry;
    }

}
