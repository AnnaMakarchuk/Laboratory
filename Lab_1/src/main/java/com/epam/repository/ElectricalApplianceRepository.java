package com.epam.repository;

import com.epam.models.ElectricalAppliance;

import java.util.List;

public interface ElectricalApplianceRepository {

    void insert(List<ElectricalAppliance> applianceList);

    void turnOnAppliance(String applianceName);

    List<ElectricalAppliance> findApplianceSortByPower();

    List<ElectricalAppliance> findApplianceByParameters(int productionYear, int powerConsumption);

    int findTotalPower();
}
