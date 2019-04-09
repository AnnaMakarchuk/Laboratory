package com.epam;

import com.epam.repository.impl.ElectricalApplianceRepositoryImpl;
import com.epam.services.ElectricalApplianceService;
import com.epam.services.impl.ElectricalApplianceServiceImpl;

public class Main {
    public static void main(String[] args) {
        ElectricalApplianceService service = new ElectricalApplianceServiceImpl(
                new ElectricalApplianceRepositoryImpl());
        service.createListTurnedOn();
        System.out.println("\nYou can see below total list of turned on appliances sort by power increase:");
        System.out.println(service.createApplianceSortByPower());
        System.out.println("\n Total power consumption of these appliances in Wh/hour is "
                + service.calculateTotalPowerConsumption());
        int powerConsumption = 500;
        int productionYear = 2015;
        System.out.println("\nPlease see below appliances in home with power > " + powerConsumption +
                " and year of the production not older than " + productionYear);
        System.out.println(service.createApplianceByParameters(productionYear, powerConsumption));
    }
}
