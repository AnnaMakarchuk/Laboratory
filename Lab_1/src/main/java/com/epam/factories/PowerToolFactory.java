package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.PowerToolType;
import com.epam.models.PowerTool;
import com.epam.utils.ColumnNames;
import com.epam.utils.ResultSetFields;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerToolFactory implements Factories {
    private PowerToolFactory() {
    }

    private static class PowerToolSingletonHolder {
        private final static PowerToolFactory INSTANCE = new PowerToolFactory();
    }

    public static PowerToolFactory getInstance() {
        return PowerToolSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption,
                                             int yearProduction, boolean turnOn, String inputType) {
        return new PowerTool(applianceName, brand, powerConsumption, yearProduction, turnOn,
                getPowerToolType(inputType));
    }

    @Override
    public ElectricalAppliance create(ResultSet resultSet) throws SQLException {
        String type = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, resultSet);
        String brand = ResultSetFields.getStringByName(ColumnNames.BRAND, resultSet);
        int powerConsumption = ResultSetFields.getIntByName(ColumnNames.POWER_WATT, resultSet);
        int yearProduction = ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, resultSet);
        boolean turnOn = ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, resultSet);
        String inputType = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, resultSet);
        return new PowerTool(type, brand, powerConsumption, yearProduction, turnOn, getPowerToolType(inputType));
    }

    private PowerToolType getPowerToolType(String inputType) {
        return PowerToolType.valueOf(inputType.toUpperCase());
    }
}
