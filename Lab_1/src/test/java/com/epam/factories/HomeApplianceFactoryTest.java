package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.HomeAppliance;
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

        ElectricalAppliance result = HomeApplianceFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);

        assertThat(result, instanceOf(HomeAppliance.class));
        HomeAppliance homeResult = (HomeAppliance)result;
        assertThat(homeResult.getApplianceName(), equalTo(applianceName));
        assertThat(homeResult.getBrand(), equalTo(brand));
        assertThat(homeResult.getPowerConsumption(), equalTo(powerConsumption));
        assertThat(homeResult.getYearProduction(), equalTo(yearProduction));
        assertThat(homeResult.isTurnOn(), equalTo(turnOn));
        assertThat(homeResult.getHomeApplianceType().toString(), equalTo(type.toUpperCase()));
    }

    @Test
    public void shouldCreateHomeApplianceFromResultSet() throws SQLException {
        ResultSet rsMock = mock(ResultSet.class);
        when(rsMock.getString("appliance_name")).thenReturn("iron");
        when(rsMock.getString("brand")).thenReturn("H");
        when(rsMock.getInt("power_watt")).thenReturn(100);
        when(rsMock.getInt("production_year")).thenReturn(2015);
        when(rsMock.getBoolean("turned_on")).thenReturn(false);
        when(rsMock.getString("appliance_type")).thenReturn("home");

        ElectricalAppliance result = HomeApplianceFactory.getInstance().create(rsMock);
        assertThat(result, instanceOf(HomeAppliance.class));
        HomeAppliance homeResult = (HomeAppliance)result;
        assertThat(homeResult.getApplianceName(), equalTo("iron"));
        assertThat(homeResult.getBrand(), equalTo("H"));
        assertThat(homeResult.getPowerConsumption(), equalTo(100));
        assertThat(homeResult.getYearProduction(), equalTo(2015));
        assertThat(homeResult.isTurnOn(), equalTo(false));
        assertThat(homeResult.getHomeApplianceType().toString(), equalTo("home".toUpperCase()));
    }
}