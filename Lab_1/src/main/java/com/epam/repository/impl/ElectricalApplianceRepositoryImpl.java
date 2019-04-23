package com.epam.repository.impl;

import com.epam.factories.ElectricalApplianceFactory;
import com.epam.models.ElectricalAppliance;
import com.epam.configuration.ConnectionService;
import com.epam.repository.ElectricalApplianceRepository;
import com.epam.utils.ApplianceTypeUtil;
import com.epam.utils.ResultSetFields;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElectricalApplianceRepositoryImpl implements ElectricalApplianceRepository {

    @Override
    public void insert(List<ElectricalAppliance> electricalApplianceList) {
        Connection connection = ConnectionService.getInstance();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO electric_appliances " +
                    "(appliance_name, brand, power_watt, production_year,appliance_type,turned_on ) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for (ElectricalAppliance appliance : electricalApplianceList) {
                preparedStatement.setString(1, appliance.getApplianceName());
                preparedStatement.setString(2, appliance.getBrand());
                preparedStatement.setInt(3, appliance.getPowerConsumption());
                preparedStatement.setInt(4, appliance.getYearProduction());
                preparedStatement.setString(5, ApplianceTypeUtil.findType(appliance));
                preparedStatement.setBoolean(6, appliance.isTurnOn());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void turnOnAppliance(String applianceName) {
        Connection connection = ConnectionService.getInstance();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE electric_appliances SET turned_on = 1 WHERE appliance_name IN (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, applianceName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ElectricalAppliance> findApplianceSortByPower() {
        List<ElectricalAppliance> electricalApplianceList = new ArrayList<>();
        Connection connection = ConnectionService.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT ea.*, t.general_type FROM electric_appliances as ea JOIN types as t" +
                    " ON ea.appliance_type = t.specific_types WHERE ea.turned_on = 1 ORDER BY ea.power_watt";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                electricalApplianceList.add(ElectricalApplianceFactory.createTechnique(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return electricalApplianceList;
    }

    @Override
    public List<ElectricalAppliance> findApplianceByParameters(int productionYear, int powerConsumption) {
        List<ElectricalAppliance> electricalApplianceList = new ArrayList<>();
        Connection connection = ConnectionService.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT ea.*, t.general_type FROM electric_appliances as ea JOIN types as t " +
                    "ON t.specific_types = ea.appliance_type WHERE ea.production_year >"
                    + productionYear + " AND ea.power_watt >" + powerConsumption + " ORDER BY ea.power_watt";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                electricalApplianceList.add(ElectricalApplianceFactory.createTechnique(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return electricalApplianceList;
    }

    @Override
    public int findTotalPower() {
        int totalPower = 0;
        Connection connection = ConnectionService.getInstance();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT SUM(power_watt) as totalPower FROM electric_appliances WHERE turned_on = 1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            resultSet.next();
            totalPower = ResultSetFields.getIntByName("totalPower", resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
