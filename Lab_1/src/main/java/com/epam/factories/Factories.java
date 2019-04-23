package com.epam.factories;

import com.epam.models.ElectricalAppliance;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Factories {

    ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption, int yearProduction,
                                      boolean turnOn, String inputType);

    ElectricalAppliance create(ResultSet resultSet) throws SQLException;

}
