package com.epam.utils;

import com.epam.factories.ElectricalApplianceFactory;
import com.epam.models.ElectricalAppliance;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ApplianceTypeUtilTest {
    @Test
    public void shouldReturnLargeHomeApplianceType() {
        String generalApplianceType = "LargeHomeAppliance";
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique(generalApplianceType)
                .createFactory("Fringe", "Zanussi", 200, 2010,
                        false, "storage");
        String specificType = ApplianceTypeUtil.findType(appliance);
        assertThat(specificType, equalTo("storage".toUpperCase()));
    }

    @Test
    public void shouldReturnHomeApplianceType() {
        String generalApplianceType = "homeaplliance";
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique(generalApplianceType).
                createFactory("ElectricGrill", "Tefal", 2000,
                        2014, false, "kitchen");
        String specificType = ApplianceTypeUtil.findType(appliance);
        assertThat(specificType, equalTo("kitchen".toUpperCase()));
    }

    @Test
    public void shouldReturnMultimediaType() {
        String generalApplianceType = "multimedia";
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique(generalApplianceType)
                .createFactory("Notebook", "Asus", 120, 2018,
                        false, "PC");
        String specificType = ApplianceTypeUtil.findType(appliance);
        assertThat(specificType, equalTo("PC".toUpperCase()));
    }

    @Test
    public void shouldReturnPowerToolType() {
        String generalApplianceType = "powertool";
        ElectricalAppliance appliance = ElectricalApplianceFactory.createTechnique(generalApplianceType)
                .createFactory("Screwdriver", "Makita", 1000, 2013,
                        false, "screw");
        String specificType = ApplianceTypeUtil.findType(appliance);
        assertThat(specificType, equalTo("screw".toUpperCase()));
    }
}
