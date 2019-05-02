package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.LargeHomeAppliance;
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

public class LargeHomeApplianceFactoryTest {

    @Test
    public void shouldCreateLargeHomeAppliance() {
        String applianceName = "fringe";
        String brand = "H";
        int powerConsumption = 100;
        int yearProduction = 2015;
        boolean turnOn = false;
        String type = "STORAGE";
        ElectricalAppliance electricalApplianceResult = LargeHomeApplianceFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);
        assertThat(electricalApplianceResult, instanceOf(LargeHomeAppliance.class));
        LargeHomeAppliance largeHomeApplianceResult = (LargeHomeAppliance) electricalApplianceResult;
        assertThat(largeHomeApplianceResult.getApplianceName(), equalTo(applianceName));
        assertThat(largeHomeApplianceResult.getBrand(), equalTo(brand));
        assertThat(largeHomeApplianceResult.getPowerConsumption(), equalTo(powerConsumption));
        assertThat(largeHomeApplianceResult.getYearProduction(), equalTo(yearProduction));
        assertThat(largeHomeApplianceResult.isTurnOn(), equalTo(turnOn));
        assertThat(largeHomeApplianceResult.getLargeHomeApplianceType().toString(), equalTo(type.toUpperCase()));
        assertThat(LargeHomeApplianceFactory.getInstance().createFactory(applianceName, brand,
                powerConsumption, yearProduction, turnOn, type), instanceOf(LargeHomeAppliance.class));
    }

    @Test
    public void shouldCreateLargeHomeApplianceFromResultSet() throws SQLException {
        ResultSet rsMock = mock(ResultSet.class);
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, rsMock)).thenReturn("fringe");
        when(ResultSetFields.getStringByName(ColumnNames.BRAND, rsMock)).thenReturn("H");
        when(ResultSetFields.getIntByName(ColumnNames.POWER_WATT, rsMock)).thenReturn(100);
        when(ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, rsMock)).thenReturn(2015);
        when(ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, rsMock)).thenReturn(false);
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, rsMock)).thenReturn("STORAGE");
        ElectricalAppliance electricalApplianceResult = LargeHomeApplianceFactory.getInstance().create(rsMock);
        assertThat(electricalApplianceResult, instanceOf(LargeHomeAppliance.class));
        LargeHomeAppliance largeHomeApplianceResult = (LargeHomeAppliance) electricalApplianceResult;
        assertThat(largeHomeApplianceResult.getApplianceName(), equalTo("fringe"));
        assertThat(largeHomeApplianceResult.getBrand(), equalTo("H"));
        assertThat(largeHomeApplianceResult.getPowerConsumption(), equalTo(100));
        assertThat(largeHomeApplianceResult.getYearProduction(), equalTo(2015));
        assertThat(largeHomeApplianceResult.isTurnOn(), equalTo(false));
        assertThat(largeHomeApplianceResult.getLargeHomeApplianceType().toString(), equalTo("storage".toUpperCase()));
    }

}