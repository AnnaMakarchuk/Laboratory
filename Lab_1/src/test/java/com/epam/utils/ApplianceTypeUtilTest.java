package com.epam.utils;

import com.epam.factories.ElectricalApplianceFactory;
import com.epam.factories.ElectricalAppliancesType;
import com.epam.models.ElectricalAppliance;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ApplianceTypeUtilTest {
    @Test
    public void shouldReturnLargeHomeApplianceType() {
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique
                (ElectricalAppliancesType.LARGEHOMEAPPLIANCE)
                .createFactory("Fringe", "Zanussi", 200, 2010
                        , false, "storage");
        String type = ApplianceTypeUtil.findType(appliance);
        assertThat(type, equalTo("storage".toUpperCase()));
    }

    @Test
    public void shouldReturnHomeApplianceType () {
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique
                (ElectricalAppliancesType.MULTIMEDIA)
                .createFactory("Notebook", "Asus", 120, 2018
                        , false, "PC");
        String type = ApplianceTypeUtil.findType(appliance);
        assertThat(type, equalTo("PC".toUpperCase()));
    }

    @Test
    public void shouldReturnMultimediaType () {
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique
                (ElectricalAppliancesType.HOMEAPPLIANCE)
                .createFactory("ElectricGrill", "Tefal", 2000, 2014
                        , false, "kitchen");
        String type = ApplianceTypeUtil.findType(appliance);
        assertThat(type, equalTo("kitchen".toUpperCase()));
    }

    @Test
    public void shouldReturnPowerToolType() {
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique
                (ElectricalAppliancesType.POWERTOOL)
                .createFactory("Screwdriver", "Makita", 1000, 2013
                        , false, "screw");
        String type = ApplianceTypeUtil.findType(appliance);
        assertThat(type, equalTo("screw".toUpperCase()));
    }

}