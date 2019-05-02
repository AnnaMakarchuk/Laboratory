package com.epam.factories;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ElectricalApplianceFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceprionWhenIncorrectType() {
        String type = "door";
        ElectricalApplianceFactory.createTechnique(type);
    }

    @Test
    public void shouldReturnLargeHomeApplianceFactory() {
        String type = "largehomeAppliance";
        Factories factories =
                ElectricalApplianceFactory.createTechnique(type);
        assertThat(factories, instanceOf(LargeHomeApplianceFactory.class));
    }

    @Test
    public void shouldReturnHomeApplianceFactory() {
        String type = "homeAppliance";
        Factories factories = ElectricalApplianceFactory.createTechnique(type);
        assertThat(factories, is(HomeApplianceFactory.getInstance()));
    }

    @Test
    public void shouldReturnMultimediaFactory() {
        String type = "multimedia";
        Factories factories = ElectricalApplianceFactory.createTechnique(type);
        assertThat(factories, is(MultiMediaFactory.getInstance()));
    }

    @Test
    public void shouldReturnPowerToolsFactory() {
        String type = "powertool";
        Factories factories = ElectricalApplianceFactory.createTechnique(type);
        assertThat(factories, is(PowerToolFactory.getInstance()));
    }
}