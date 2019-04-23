package com.epam.repository.impl;

import com.epam.configuration.ConnectionService;
import com.epam.repository.TypesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TypesRepositoryImpl implements TypesRepository {

    @Override
    public void insert(String specific_types, String general_type) {
        Connection connection = ConnectionService.getInstance();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO types (specific_types, general_type) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, specific_types);
            preparedStatement.setString(2, general_type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
