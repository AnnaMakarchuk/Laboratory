package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.PowerTool;
import com.epam.utils.ColumnNames;
import com.epam.utils.ResultSetFields;
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
        ElectricalAppliance electricalApplianceResult = PowerToolFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);
        assertThat(electricalApplianceResult, instanceOf(PowerTool.class));
        PowerTool powerToolResult = (PowerTool) electricalApplianceResult;
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
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, rsMock)).thenReturn("drill");
        when(ResultSetFields.getStringByName(ColumnNames.BRAND, rsMock)).thenReturn("H");
        when(ResultSetFields.getIntByName(ColumnNames.POWER_WATT, rsMock)).thenReturn(100);
        when(ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, rsMock)).thenReturn(2015);
        when(ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, rsMock)).thenReturn(false);
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, rsMock)).thenReturn("drill");
        ElectricalAppliance electricalApplianceResult = PowerToolFactory.getInstance().create(rsMock);
        assertThat(electricalApplianceResult, instanceOf(PowerTool.class));
        PowerTool powerToolResult = (PowerTool) electricalApplianceResult;
        assertThat(powerToolResult.getApplianceName(), equalTo("drill"));
        assertThat(powerToolResult.getBrand(), equalTo("H"));
        assertThat(powerToolResult.getPowerConsumption(), equalTo(100));
        assertThat(powerToolResult.getYearProduction(), equalTo(2015));
        assertThat(powerToolResult.isTurnOn(), equalTo(false));
        assertThat(powerToolResult.getPowerToolType().toString(), equalTo("drill".toUpperCase()));
    }
}