package com.epam.repository.impl;

import com.epam.configuration.ConnectionService;
import com.epam.repository.TypesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TypesRepositoryImpl implements TypesRepository {

    @Override
    public void insert(String specific_types, String general_type) {
        Connection con = ConnectionService.getInstance();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO types (specific_types, general_type) VALUES (?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, specific_types);
            stmt.setString(2, general_type);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
