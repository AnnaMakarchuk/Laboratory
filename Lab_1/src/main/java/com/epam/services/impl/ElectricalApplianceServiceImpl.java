package com.epam.services.impl;

import com.epam.models.ElectricalAppliance;
import com.epam.repository.ElectricalApplianceRepository;
import com.epam.services.ElectricalApplianceService;

import java.util.ArrayList;
import java.util.List;

public class ElectricalApplianceServiceImpl implements ElectricalApplianceService {

    private ElectricalApplianceRepository electricalApplianceRepository;

    public ElectricalApplianceServiceImpl(ElectricalApplianceRepository electricalApplianceRepository) {
        this.electricalApplianceRepository = electricalApplianceRepository;
    }

    @Override
    public void createListTurnedOn() {
        List<String> listTurnedOn = new ArrayList<>();
        listTurnedOn.add("Fringe");
        listTurnedOn.add("Cooker");
        listTurnedOn.add("Washer");
        listTurnedOn.add("Vacuum");
        listTurnedOn.add("TV");
        listTurnedOn.add("Notebook");
        listTurnedOn.add("Router");
        System.out.println("Please turn on this devices: " + listTurnedOn.toString());
        for (String electicalAppliance : listTurnedOn) {
            electricalApplianceRepository.turnOnAppliance(electicalAppliance);
        }
    }

    @Override
    public List<ElectricalAppliance> createApplianceSortByPower() {
        return electricalApplianceRepository.findApplianceSortByPower();
    }

    @Override
    public List<ElectricalAppliance> createApplianceByParameters(int productionYear, int powerConsumption) {
        return electricalApplianceRepository.findApplianceByParameters(productionYear, powerConsumption);
    }

    @Override
    public int calculateTotalPowerConsumption() {
        return electricalApplianceRepository.findTotalPower();
    }
}
