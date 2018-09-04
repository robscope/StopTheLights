package com.traffic.poc;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;

@SpringBootApplication
public class TrafficLightsExample implements CommandLineRunner {

    @Autowired
    TrafficConfigJdbcRepository repository;

    private static Logger logger = LogManager.getLogger(TrafficLightsExample.class);

    public static void main(String[] args) {
        SpringApplication.run(TrafficLightsExample.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Create an instance
        // TrafficLight trafficLight = new TrafficLight();

        // Injecting bean which already has defined instance of TrafficLight
        ApplicationContext context = new ClassPathXmlApplicationContext("trafficbean.xml");
        TrafficLight trafficLight = (TrafficLight) context.getBean("TrafficLight");

        // TrafficConfig config = new TrafficConfig("Monday",
        // Time.valueOf("10:00:00"), Time.valueOf("13:00:00"));

        LocalDate date = LocalDate.now();
        LocalDateTime datetime = LocalDateTime.now();

        List<TrafficConfig> configs = repository.findAll();
        logger.info("Reading Traffic Config from repository");
        for (TrafficConfig trafficConfig : configs) {
            logger.info("Traffic Config : {}", trafficConfig);
            LocalDateTime after = LocalDate.now().atTime(trafficConfig.getStartTime().getHours(),
                    trafficConfig.getStartTime().getMinutes());
            LocalDateTime before = LocalDate.now().atTime(trafficConfig.getEndTime().getHours(),
                    trafficConfig.getEndTime().getMinutes());
            if (date.getDayOfWeek().toString().equals(trafficConfig.getDay().toUpperCase()) && datetime.isAfter(after)
                    && datetime.isBefore(before)) {
                logger.info("Current time of day is busy, setting duration for traffic lights to 5 seconds");
                trafficLight.setDuration(5);
            }

        }

        try {
            while (true) {
                trafficLight.setColour(trafficLight.nextColour());
                logger.info("Current traffic light:" + trafficLight);
                TimeUnit.SECONDS.sleep(trafficLight.getDuration());
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

}
