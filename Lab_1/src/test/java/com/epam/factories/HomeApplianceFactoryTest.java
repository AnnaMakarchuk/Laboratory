package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.HomeAppliance;
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

public class HomeApplianceFactoryTest {

    @Test
    public void shouldCreateHomeAppliance() {
        String applianceName = "iron";
        String brand = "H";
        int powerConsumption = 100;
        int yearProduction = 2015;
        boolean turnOn = false;
        String type = "home";
        ElectricalAppliance electricalApplianceResult = HomeApplianceFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);
        assertThat(electricalApplianceResult, instanceOf(HomeAppliance.class));
        HomeAppliance homeApplianceResult = (HomeAppliance) electricalApplianceResult;
        assertThat(homeApplianceResult.getApplianceName(), equalTo(applianceName));
        assertThat(homeApplianceResult.getBrand(), equalTo(brand));
        assertThat(homeApplianceResult.getPowerConsumption(), equalTo(powerConsumption));
        assertThat(homeApplianceResult.getYearProduction(), equalTo(yearProduction));
        assertThat(homeApplianceResult.isTurnOn(), equalTo(turnOn));
        assertThat(homeApplianceResult.getHomeApplianceType().toString(), equalTo(type.toUpperCase()));
    }

    @Test
    public void shouldCreateHomeApplianceFromResultSet() throws SQLException {
        ResultSet rsMock = mock(ResultSet.class);
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, rsMock)).thenReturn("iron");
        when(ResultSetFields.getStringByName(ColumnNames.BRAND, rsMock)).thenReturn("H");
        when(ResultSetFields.getIntByName(ColumnNames.POWER_WATT, rsMock)).thenReturn(100);
        when(ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, rsMock)).thenReturn(2015);
        when(ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, rsMock)).thenReturn(false);
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, rsMock)).thenReturn("home");
        ElectricalAppliance electricalApplianceResult = HomeApplianceFactory.getInstance().create(rsMock);
        assertThat(electricalApplianceResult, instanceOf(HomeAppliance.class));
        HomeAppliance homeApplianceResult = (HomeAppliance) electricalApplianceResult;
        assertThat(homeApplianceResult.getApplianceName(), equalTo("iron"));
        assertThat(homeApplianceResult.getBrand(), equalTo("H"));
        assertThat(homeApplianceResult.getPowerConsumption(), equalTo(100));
        assertThat(homeApplianceResult.getYearProduction(), equalTo(2015));
        assertThat(homeApplianceResult.isTurnOn(), equalTo(false));
        assertThat(homeApplianceResult.getHomeApplianceType().toString(), equalTo("home".toUpperCase()));
    }
}