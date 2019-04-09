package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.PowerTool;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PowerToolFactoryTest {

    @Test
    public void shouldCreateHomeAppliance() {
        String applianceName = "drill";
        String brand = "H";
        int powerConsumption = 100;
        int yearProduction = 2015;
        boolean turnOn = false;
        String type = "drill";

        ElectricalAppliance result = PowerToolFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);

        assertThat(result, instanceOf(PowerTool.class));
        PowerTool powerToolResult = (PowerTool) result;
        assertThat(powerToolResult.getApplianceName(), equalTo(applianceName));
        assertThat(powerToolResult.getBrand(), equalTo(brand));
        assertThat(powerToolResult.getPowerConsumption(), equalTo(powerConsumption));
        assertThat(powerToolResult.getYearProduction(), equalTo(yearProduction));
        assertThat(powerToolResult.isTurnOn(), equalTo(turnOn));
        assertThat(powerToolResult.getPowerToolType().toString(), equalTo(type.toUpperCase()));
    }

    @Test
    public void shouldCreateHomeApplianceFromResulSet() throws SQLException {
        ResultSet rsMock = mock(ResultSet.class);
        when(rsMock.getString("appliance_name")).thenReturn("drill");
        when(rsMock.getString("brand")).thenReturn("H");
        when(rsMock.getInt("power_watt")).thenReturn(100);
        when(rsMock.getInt("production_year")).thenReturn(2015);
        when(rsMock.getBoolean("turned_on")).thenReturn(false);
        when(rsMock.getString("appliance_type")).thenReturn("drill");

        ElectricalAppliance result = PowerToolFactory.getInstance().create(rsMock);
        assertThat(result, instanceOf(PowerTool.class));
        PowerTool powerToolResult = (PowerTool) result;
        assertThat(powerToolResult.getApplianceName(), equalTo("drill"));
        assertThat(powerToolResult.getBrand(), equalTo("H"));
        assertThat(powerToolResult.getPowerConsumption(), equalTo(100));
        assertThat(powerToolResult.getYearProduction(), equalTo(2015));
        assertThat(powerToolResult.isTurnOn(), equalTo(false));
        assertThat(powerToolResult.getPowerToolType().toString(), equalTo("drill".toUpperCase()));
    }
}