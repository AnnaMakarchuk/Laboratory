package com.epam.utils;

import com.epam.factories.ElectricalAppliancesType;
import com.epam.models.*;

public class ApplianceTypeUtil {

    public static ElectricalAppliancesType getElectricalAppliancesType(String electricalAppliancesType) {
        return ElectricalAppliancesType.valueOf(electricalAppliancesType.toUpperCase());
    }

    public static String findType(ElectricalAppliance electricalAppliance) {
        String type = "";
        if (electricalAppliance instanceof LargeHomeAppliance) {
            type = ((LargeHomeAppliance) electricalAppliance).getLargeHomeApplianceType().toString();
        } else if (electricalAppliance instanceof HomeAppliance) {
            type = ((HomeAppliance) electricalAppliance).getHomeApplianceType().toString();
        } else if (electricalAppliance instanceof Multimedia) {
            type = ((Multimedia) electricalAppliance).getMultiMediaType().toString();
        } else if (electricalAppliance instanceof PowerTool) {
            type = ((PowerTool) electricalAppliance).getPowerToolType().toString();
        } else throw new IllegalArgumentException();
        return type;
    }
}
