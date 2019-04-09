package com.epam.repository.impl;

import com.epam.factories.ElectricalApplianceFactory;
import com.epam.factories.ElectricalAppliancesType;
import com.epam.models.ElectricalAppliance;
import com.epam.configuration.ConnectionService;
import com.epam.repository.ElectricalApplianceRepository;
import com.epam.services.CreateAppliance;
import com.epam.utils.ApplianceTypeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElectricalApplianceRepositoryImpl implements ElectricalApplianceRepository {

    @Override
    public void insert(List<ElectricalAppliance> applianceList) {
        Connection con = ConnectionService.getInstance();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO electric_appliances " +
                    "(appliance_name, brand, power_watt, production_year,appliance_type,turned_on ) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            for (ElectricalAppliance appliance : applianceList) {
                stmt.setString(1, appliance.getApplianceName());
                stmt.setString(2, appliance.getBrand());
                stmt.setInt(3, appliance.getPowerConsumption());
                stmt.setInt(4, appliance.getYearProduction());
                stmt.setString(5, ApplianceTypeUtil.findType(appliance));
                stmt.setBoolean(6, appliance.isTurnOn());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void turnOnAppliance(String applianceName) {
        Connection con = ConnectionService.getInstance();
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE electric_appliances SET turned_on = 1 WHERE appliance_name IN (?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, applianceName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ElectricalAppliance> findApplianceSortByPower() {
        List<ElectricalAppliance> appliances = new ArrayList<>();
        Connection con = ConnectionService.getInstance();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT ea.*, t.general_type FROM electric_appliances as ea JOIN types as t" +
                    " ON ea.appliance_type = t.specific_types WHERE ea.turned_on = 1 ORDER BY ea.power_watt";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String appliancesType = rs.getString("t.general_type");
                appliances.add(ElectricalApplianceFactory
                        .createTechnique(ElectricalAppliancesType.valueOf(appliancesType))
                        .create(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return appliances;
    }

    @Override
    public List<ElectricalAppliance> findApplianceByParameters(int productionYear, int powerConsumption) {
        List<ElectricalAppliance> appliances = new ArrayList<>();
        Connection con = ConnectionService.getInstance();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT ea.*, t.general_type FROM electric_appliances as ea JOIN types as t " +
                    "ON t.specific_types = ea.appliance_type WHERE ea.production_year >"
                    +  productionYear + " AND ea.power_watt >" + powerConsumption+ " ORDER BY ea.power_watt";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String appliancesType = rs.getString("general_type");
                appliances.add(ElectricalApplianceFactory
                        .createTechnique(ElectricalAppliancesType.valueOf(appliancesType))
                        .create(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return appliances;
    }

    @Override
    public int findTotalPower() {
        int totalPower = 0;
        Connection con = ConnectionService.getInstance();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT SUM(power_watt) as totalPower FROM electric_appliances WHERE turned_on = 1";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            rs.next();
            totalPower = rs.getInt("totalPower");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
