package com.epam.factories;

import com.epam.models.*;
import com.epam.utils.ColumnNames;
import com.epam.utils.ResultSetFields;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LargeHomeApplianceFactory implements Factories {
    private LargeHomeApplianceFactory() {
    }

    private static class LargeHomeApplianceSingletonHolder {
        private final static LargeHomeApplianceFactory INSTANCE = new LargeHomeApplianceFactory();
    }

    public static LargeHomeApplianceFactory getInstance() {
        return LargeHomeApplianceSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption,
                                             int yearProduction, boolean turnOn, String inputType) {
        return new LargeHomeAppliance(applianceName, brand, powerConsumption, yearProduction, turnOn,
                getLargeHomeApplianceType(inputType));
    }

    @Override
    public ElectricalAppliance create(ResultSet resultSet) throws SQLException {
        String type = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, resultSet);
        String brand = ResultSetFields.getStringByName(ColumnNames.BRAND, resultSet);
        int powerConsumption = ResultSetFields.getIntByName(ColumnNames.POWER_WATT, resultSet);
        int yearProduction = ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, resultSet);
        boolean turnOn = ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, resultSet);
        String inputType = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, resultSet);
        return new LargeHomeAppliance(type, brand, powerConsumption, yearProduction, turnOn,
                getLargeHomeApplianceType(inputType));
    }

    private LargeHomeApplianceType getLargeHomeApplianceType(String inputType) {
        return LargeHomeApplianceType.valueOf(inputType.toUpperCase());
    }
}
