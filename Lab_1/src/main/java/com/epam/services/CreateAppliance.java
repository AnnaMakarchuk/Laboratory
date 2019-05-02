package com.epam.services;

import com.epam.factories.ElectricalApplianceFactory;
import com.epam.models.*;

import java.util.ArrayList;
import java.util.List;

public class CreateAppliance {
    private ElectricalApplianceFactory electricalApplianceFactory;

    public CreateAppliance() {
        electricalApplianceFactory = new ElectricalApplianceFactory();
    }

    public List<ElectricalAppliance> createApplianceList() {
        List<ElectricalAppliance> electricalApplianceList = new ArrayList<>();
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("largehomeappliance")
                .createFactory("Fringe", "Zanussi", 200, 2010,
                        false, "storage"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("largehomeappliance")
                .createFactory("Oven", "Ariston", 1500, 2012,
                        false, "cook"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("largehomeappliance")
                .createFactory("Cooker", "Electrolux", 1000, 2017,
                        false, "cook"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("largehomeappliance")
                .createFactory("Washer", "Electrolux", 550, 2017,
                        false, "laundry"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("LARGEHOMEAPPLIANCE")
                .createFactory("Conditioner", "LG", 3000, 2014,
                        false, "climate"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("homeAppliance")
                .createFactory("Teapot", "Braun", 275, 2015,
                        false, "kitchen"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("homeAppliance")
                .createFactory("ElectricGrill", "Tefal", 2000, 2014,
                        false, "kitchen"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("homeAppliance")
                .createFactory("Iron", "Tefal", 1100, 2008,
                        false, "home"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("homeAppliance")
                .createFactory("Vacuum", "Samsung", 650, 2014,
                        false, "home"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("homeAppliance")
                .createFactory("Hairdryer", "Babyliss", 1500, 2015,
                        false, "beauty"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("multimedia")
                .createFactory("TV", "LG", 340, 2009,
                        false, "TV"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("multimedia")
                .createFactory("Notebook", "Asus", 120, 2018,
                        false, "PC"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("powertool")
                .createFactory("Screwdriver", "Makita", 1000, 2013,
                        false, "screw"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("powertool")
                .createFactory("Drill", "Makita", 700, 2018,
                        false, "drill"));
        electricalApplianceList.add(electricalApplianceFactory.createTechnique("powertool")
                .createFactory("Router", "Asus", 10, 2012,
                        false, "router"));
        return electricalApplianceList;
    }
}
