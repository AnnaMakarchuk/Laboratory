package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.Multimedia;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultiMediaFactoryTest {

    @Test
    public void shouldCreateMultimedia() {
        String applianceName = "TV";
        String brand = "H";
        int powerConsumption = 100;
        int yearProduction = 2015;
        boolean turnOn = false;
        String type = "TV";
        ElectricalAppliance result = MultiMediaFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);

        assertThat(result, instanceOf(Multimedia.class));
        Multimedia multimedia = (Multimedia) result;
        assertThat(multimedia.getApplianceName(), equalTo(applianceName));
        assertThat(multimedia.getBrand(), equalTo(brand));
        assertThat(multimedia.getPowerConsumption(), equalTo(powerConsumption));
        assertThat(multimedia.getYearProduction(), equalTo(yearProduction));
        assertThat(multimedia.isTurnOn(), equalTo(turnOn));
        assertThat(multimedia.getMultiMediaType().toString(), equalTo(type.toUpperCase()));
    }

    @Test
    public void shouldCreateMultimediaFromResultSet() throws SQLException {
        ResultSet rsMock = mock(ResultSet.class);
        when(rsMock.getString("appliance_name")).thenReturn("TV");
        when(rsMock.getString("brand")).thenReturn("H");
        when(rsMock.getInt("power_watt")).thenReturn(100);
        when(rsMock.getInt("production_year")).thenReturn(2015);
        when(rsMock.getBoolean("turned_on")).thenReturn(false);
        when(rsMock.getString("appliance_type")).thenReturn("tv");

        ElectricalAppliance result = MultiMediaFactory.getInstance().create(rsMock);
        assertThat(result, instanceOf(Multimedia.class));
        Multimedia multimedia = (Multimedia) result;
        assertThat(multimedia.getApplianceName(), equalTo("TV"));
        assertThat(multimedia.getBrand(), equalTo("H"));
        assertThat(multimedia.getPowerConsumption(), equalTo(100));
        assertThat(multimedia.getYearProduction(), equalTo(2015));
        assertThat(multimedia.isTurnOn(), equalTo(false));
        assertThat(multimedia.getMultiMediaType().toString(), equalTo("tv".toUpperCase()));
    }

}