package com.traffic.poc;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TrafficLightTest {

    private TrafficLight trafficLight;

    @Test
    public void checkDefaultConstructor() {
        trafficLight = new TrafficLight();
        assertThat(trafficLight.getColour()).isEqualTo(Colour.RED);
    }
    
    @Test
    public void checkConstructor() {
        trafficLight = new TrafficLight(Colour.AMBER);
        assertThat(trafficLight.getColour()).isEqualTo(Colour.AMBER);
    }
    
    @Test
    public void checkSetColour() {
        trafficLight = new TrafficLight();
        trafficLight.setColour(Colour.GREEN);
        assertThat(trafficLight.getColour()).isEqualTo(Colour.GREEN);
    }

    @Test
    public void checkNextColour() {
        trafficLight = new TrafficLight();
        assertThat(trafficLight.nextColour()).isNotEqualTo(Colour.RED);
    }
}