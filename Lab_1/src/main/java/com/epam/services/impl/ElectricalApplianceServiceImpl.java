package com.epam.services.impl;

import com.epam.models.ElectricalAppliance;
import com.epam.repository.ElectricalApplianceRepository;
import com.epam.repository.impl.ElectricalApplianceRepositoryImpl;
import com.epam.services.ElectricalApplianceService;
import com.sun.org.apache.bcel.internal.generic.LREM;

import java.util.ArrayList;
import java.util.List;

public class ElectricalApplianceServiceImpl implements ElectricalApplianceService {

    private ElectricalApplianceRepository repository;

    public ElectricalApplianceServiceImpl(ElectricalApplianceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createListTurnedOn() {
        List<String > list = new ArrayList<>();
        list.add("Fringe");
        list.add("Cooker");
        list.add("Washer");
        list.add("Vacuum");
        list.add("TV");
        list.add("Notebook");
        list.add("Router");
        System.out.println("Please turn on this devices: " + list.toString());
        for (String string: list) {
            repository.turnOnAppliance(string);
        }
    }

    @Override
    public List<ElectricalAppliance> createApplianceSortByPower() {
        return repository.findApplianceSortByPower();
    }


    @Override
    public List<ElectricalAppliance> createApplianceByParameters(int productionYear, int powerConsumption) {
        return repository.findApplianceByParameters(productionYear, powerConsumption);
    }

    @Override
    public int calculateTotalPowerConsumption() {
        return repository.findTotalPower();
    }
}
