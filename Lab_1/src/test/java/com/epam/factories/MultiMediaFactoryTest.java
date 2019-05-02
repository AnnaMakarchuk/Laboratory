package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.Multimedia;
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

public class MultiMediaFactoryTest {

    @Test
    public void shouldCreateMultimedia() {
        String applianceName = "TV";
        String brand = "H";
        int powerConsumption = 100;
        int yearProduction = 2015;
        boolean turnOn = false;
        String type = "TV";
        ElectricalAppliance electricalApplianceResult = MultiMediaFactory.getInstance()
                .createFactory(applianceName, brand, powerConsumption, yearProduction, turnOn, type);
        assertThat(electricalApplianceResult, instanceOf(Multimedia.class));
        Multimedia multimediaResult = (Multimedia) electricalApplianceResult;
        assertThat(multimediaResult.getApplianceName(), equalTo(applianceName));
        assertThat(multimediaResult.getBrand(), equalTo(brand));
        assertThat(multimediaResult.getPowerConsumption(), equalTo(powerConsumption));
        assertThat(multimediaResult.getYearProduction(), equalTo(yearProduction));
        assertThat(multimediaResult.isTurnOn(), equalTo(turnOn));
        assertThat(multimediaResult.getMultiMediaType().toString(), equalTo(type.toUpperCase()));
    }

    @Test
    public void shouldCreateMultimediaFromResultSet() throws SQLException {
        ResultSet rsMock = mock(ResultSet.class);
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, rsMock)).thenReturn("TV");
        when(ResultSetFields.getStringByName(ColumnNames.BRAND, rsMock)).thenReturn("H");
        when(ResultSetFields.getIntByName(ColumnNames.POWER_WATT, rsMock)).thenReturn(100);
        when(ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, rsMock)).thenReturn(2015);
        when(ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, rsMock)).thenReturn(false);
        when(ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, rsMock)).thenReturn("tv");
        ElectricalAppliance electricalApplianceResult = MultiMediaFactory.getInstance().create(rsMock);
        assertThat(electricalApplianceResult, instanceOf(Multimedia.class));
        Multimedia multimediaResult = (Multimedia) electricalApplianceResult;
        assertThat(multimediaResult.getApplianceName(), equalTo("TV"));
        assertThat(multimediaResult.getBrand(), equalTo("H"));
        assertThat(multimediaResult.getPowerConsumption(), equalTo(100));
        assertThat(multimediaResult.getYearProduction(), equalTo(2015));
        assertThat(multimediaResult.isTurnOn(), equalTo(false));
        assertThat(multimediaResult.getMultiMediaType().toString(), equalTo("tv".toUpperCase()));
    }

}