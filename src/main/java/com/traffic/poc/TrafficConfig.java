package com.traffic.poc;

import java.sql.Time;

public class TrafficConfig {

    private Long id;
    private String day;
    private Time startTime;
    private Time endTime;

    public TrafficConfig(){
        super();
    }
    
    public TrafficConfig(Long id, String day, Time startTime, Time endTime){
        super();
        this.id = id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public TrafficConfig(String day, Time startTime, Time endTime){
        super();
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override

    public String toString() {

        return String.format("Config [id=%s, day=%s, startTime=%s, endTime=%s]", id, day, startTime, endTime);

    }
}
