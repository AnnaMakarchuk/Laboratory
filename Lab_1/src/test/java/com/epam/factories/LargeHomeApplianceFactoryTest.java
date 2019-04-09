package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.LargeHomeAppliance;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LargeHomeApplianceFactoryTest {

    @Test
    public void shouldCreateLargeHomeAppliance() {
        String applianceName = "fringe";
        String brand = "H";
        int powerConsumption = 100;
        int yearProduction = 2015;
        boolean turnOn = false;
        String type = "STORAGE";
        ElectricalAppliance result = LargeHomeApplianceFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);
        assertThat(result, instanceOf(LargeHomeAppliance.class));
        LargeHomeAppliance largeHomeAppliance = (LargeHomeAppliance) result;
        assertThat(largeHomeAppliance.getApplianceName(), equalTo(applianceName));
        assertThat(largeHomeAppliance.getBrand(), equalTo(brand));
        assertThat(largeHomeAppliance.getPowerConsumption(), equalTo(powerConsumption));
        assertThat(largeHomeAppliance.getYearProduction(), equalTo(yearProduction));
        assertThat(largeHomeAppliance.isTurnOn(), equalTo(turnOn));
        assertThat(largeHomeAppliance.getLargeHomeApplianceType().toString(), equalTo(type.toUpperCase()));


        assertThat(LargeHomeApplianceFactory.getInstance().createFactory(applianceName, brand
                , powerConsumption, yearProduction, turnOn, type), instanceOf(LargeHomeAppliance.class));
    }

    @Test
    public void shouldCreateLargeHomeApplianceFromResultSet() throws SQLException {
        ResultSet rsMock = mock(ResultSet.class);
        when(rsMock.getString("appliance_name")).thenReturn("fringe");
        when(rsMock.getString("brand")).thenReturn("H");
        when(rsMock.getInt("power_watt")).thenReturn(100);
        when(rsMock.getInt("production_year")).thenReturn(2015);
        when(rsMock.getBoolean("turned_on")).thenReturn(false);
        when(rsMock.getString("appliance_type")).thenReturn("STORAGE");

        ElectricalAppliance result = LargeHomeApplianceFactory.getInstance().create(rsMock);
        assertThat(result, instanceOf(LargeHomeAppliance.class));
        LargeHomeAppliance largeHomeAppliance = (LargeHomeAppliance) result;
        assertThat(largeHomeAppliance.getApplianceName(), equalTo("fringe"));
        assertThat(largeHomeAppliance.getBrand(), equalTo("H"));
        assertThat(largeHomeAppliance.getPowerConsumption(), equalTo(100));
        assertThat(largeHomeAppliance.getYearProduction(), equalTo(2015));
        assertThat(largeHomeAppliance.isTurnOn(), equalTo(false));
        assertThat(largeHomeAppliance.getLargeHomeApplianceType().toString(), equalTo("storage".toUpperCase()));
    }

}