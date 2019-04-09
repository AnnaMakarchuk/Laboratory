package com.epam.services;

import com.epam.factories.ElectricalApplianceFactory;
import com.epam.factories.ElectricalAppliancesType;
import com.epam.models.*;

import java.util.ArrayList;
import java.util.List;

public class CreateAppliance {
    private ElectricalApplianceFactory abstractFactory;

    public CreateAppliance() {
        abstractFactory = new ElectricalApplianceFactory();
    }

    public List<ElectricalAppliance> createApplianceList (){
        List<ElectricalAppliance> appliances = new ArrayList<>();

        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.LARGEHOMEAPPLIANCE)
                .createFactory("Fringe", "Zanussi", 200, 2010
                        , false, "storage"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.LARGEHOMEAPPLIANCE)
                .createFactory("Oven", "Ariston", 1500, 2012
                        , false, "cook"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.LARGEHOMEAPPLIANCE)
                .createFactory("Cooker", "Electrolux", 1000, 2017
                        , false, "cook"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.LARGEHOMEAPPLIANCE)
                .createFactory("Washer", "Electrolux", 550, 2017
                        , false, "laundry"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.LARGEHOMEAPPLIANCE)
                .createFactory("Conditioner", "LG", 3000, 2014
                        , false, "climate"));

        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.HOMEAPPLIANCE)
                .createFactory("Teapot", "Braun", 275, 2015
                        , false, "kitchen"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.HOMEAPPLIANCE)
                .createFactory("ElectricGrill", "Tefal", 2000, 2014
                        , false, "kitchen"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.HOMEAPPLIANCE)
                .createFactory("Iron", "Tefal", 1100, 2008
                        , false, "home"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.HOMEAPPLIANCE)
                .createFactory("Vacuum", "Samsung", 650, 2014
                        , false, "home"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.HOMEAPPLIANCE)
                .createFactory("Hairdryer", "Babyliss", 1500, 2015
                        , false, "beauty"));

        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.MULTIMEDIA)
                .createFactory("TV", "LG", 340, 2009
                        , false, "TV"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.MULTIMEDIA)
                .createFactory("Notebook", "Asus", 120, 2018
                        , false, "PC"));

        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.POWERTOOL)
                .createFactory("Screwdriver", "Makita", 1000, 2013
                        , false, "screw"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.POWERTOOL)
                .createFactory("Drill", "Makita", 700, 2018
                        , false, "drill"));
        appliances.add(abstractFactory.createTechnique(ElectricalAppliancesType.POWERTOOL)
                .createFactory("Router", "Asus", 10, 2012
                        , false, "router"));
        return appliances;
    }

}
