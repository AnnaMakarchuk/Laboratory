package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.utils.ApplianceTypeUtil;
import com.epam.utils.ColumnNames;
import com.epam.utils.ResultSetFields;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ElectricalApplianceFactory {

    private static LargeHomeApplianceFactory largeHomeApplianceFactory = LargeHomeApplianceFactory.getInstance();
    private static HomeApplianceFactory homeApplianceFactory = HomeApplianceFactory.getInstance();
    private static PowerToolFactory powerToolFactory = PowerToolFactory.getInstance();
    private static MultiMediaFactory multiMediaFactory = MultiMediaFactory.getInstance();

    public static Factories createTechnique(String electricalAppliancesType) {
        switch (ApplianceTypeUtil.getElectricalAppliancesType(electricalAppliancesType)) {
            case LARGEHOMEAPPLIANCE:
                return largeHomeApplianceFactory;
            case HOMEAPPLIANCE:
                return homeApplianceFactory;
            case POWERTOOL:
                return powerToolFactory;
            case MULTIMEDIA:
                return multiMediaFactory;
        }
        throw new IllegalArgumentException();
    }

    public static ElectricalAppliance createTechnique(ResultSet resultSet) throws SQLException {
        String electricalAppliancesType = ResultSetFields.getStringByName(ColumnNames.GENERAL_TYPE, resultSet);
        switch (ApplianceTypeUtil.getElectricalAppliancesType(electricalAppliancesType)) {
            case LARGEHOMEAPPLIANCE:
                return largeHomeApplianceFactory.create(resultSet);
            case HOMEAPPLIANCE:
                return homeApplianceFactory.create(resultSet);
            case POWERTOOL:
                return powerToolFactory.create(resultSet);
            case MULTIMEDIA:
                return multiMediaFactory.create(resultSet);
        }
        throw new IllegalArgumentException();
    }
}
