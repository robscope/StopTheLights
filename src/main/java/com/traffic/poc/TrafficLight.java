package com.traffic.poc;

public class TrafficLight {
    private Colour colour;
    private int duration = 2;
    
    /*
     * Default Constructor sets to Red
     */
    public TrafficLight(){
        this.colour = Colour.RED;
    }
    
    public TrafficLight(Colour colour){
        this.colour = colour;
    }
    
    public Colour getColour(){
        return this.colour;
    }
    
    public void setColour(Colour colour){
        this.colour = colour;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Colour nextColour(){
        switch (colour){
            case RED:
                return Colour.GREEN;
            case AMBER:
                return Colour.RED;
            case GREEN:
                return Colour.AMBER;
            }
        return colour;
    }

    @Override
    public String toString() {
        return "[colour=" + colour + "]";
    }

}
