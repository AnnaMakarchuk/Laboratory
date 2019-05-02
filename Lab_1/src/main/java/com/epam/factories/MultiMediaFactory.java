package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.Multimedia;
import com.epam.models.MultimediaType;
import com.epam.utils.ColumnNames;
import com.epam.utils.ResultSetFields;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiMediaFactory implements Factories {
    private MultiMediaFactory() {
    }

    private static class MultiMediaSingletonHolder {
        private final static MultiMediaFactory INSTANCE = new MultiMediaFactory();
    }

    public static MultiMediaFactory getInstance() {
        return MultiMediaSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption,
                                             int yearProduction, boolean turnOn, String inputType) {
        return new Multimedia(applianceName, brand, powerConsumption, yearProduction, turnOn,
                getMultiMediaType(inputType));
    }

    @Override
    public ElectricalAppliance create(ResultSet resultSet) throws SQLException {
        String type = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, resultSet);
        String brand = ResultSetFields.getStringByName(ColumnNames.BRAND, resultSet);
        int powerConsumption = ResultSetFields.getIntByName(ColumnNames.POWER_WATT, resultSet);
        int yearProduction = ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, resultSet);
        boolean turnOn = ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, resultSet);
        String inputType = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, resultSet);
        return new Multimedia(type, brand, powerConsumption, yearProduction, turnOn, getMultiMediaType(inputType));
    }

    private MultimediaType getMultiMediaType(String inputType) {
        return MultimediaType.valueOf(inputType.toUpperCase());
    }

}
