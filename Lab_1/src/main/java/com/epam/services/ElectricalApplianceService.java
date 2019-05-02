package com.epam.services;

import com.epam.models.ElectricalAppliance;

import java.util.List;

public interface ElectricalApplianceService {

    void createListTurnedOn();

    List<ElectricalAppliance> createApplianceSortByPower();

    List<ElectricalAppliance> createApplianceByParameters(int productionYear, int powerConsumption);

    int calculateTotalPowerConsumption();
}
