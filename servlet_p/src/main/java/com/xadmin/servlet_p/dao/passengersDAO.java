package com.xadmin.servlet_p.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.servlet_p.bean.passengers;

public class passengersDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/airlinedb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "0000";

    private static final String INSERT_PASSENGER_SQL = "INSERT INTO passengerstbl (PName, PNat, PGen, PPass, PAdd, Pphone) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PASSENGER_BY_ID = "SELECT PI, PName, PNat, PGen, PPass, PAdd, Pphone FROM passengerstbl WHERE PI = ?";
    private static final String SELECT_ALL_PASSENGERS = "SELECT * FROM passengerstbl";
    private static final String DELETE_PASSENGER_SQL = "DELETE FROM passengerstbl WHERE PI = ?";
    private static final String UPDATE_PASSENGER_SQL = "UPDATE passengerstbl SET PName = ?, PNat = ?, PGen = ?, PPass = ?, PAdd = ?, Pphone = ? WHERE PI = ?";

    public passengersDAO() {
    }

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertPassenger(passengers passenger) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PASSENGER_SQL)) {
            preparedStatement.setString(1, passenger.getPName());
            preparedStatement.setString(2, passenger.getPNat());
            preparedStatement.setString(3, passenger.getPGen());
            preparedStatement.setInt(4, passenger.getPPass());
            preparedStatement.setString(5, passenger.getPAdd());
            preparedStatement.setInt(6, passenger.getPphone());
            preparedStatement.executeUpdate();
        }
    }

    public passengers selectPassenger(int PI) {
        passengers passenger = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PASSENGER_BY_ID)) {
            preparedStatement.setInt(1, PI);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("PName");
                String nationality = rs.getString("PNat");
                String gender = rs.getString("PGen");
                int numpass = rs.getInt("PPass");
                String addresse = rs.getString("PAdd");
                int phone = rs.getInt("Pphone");
                passenger = new passengers(PI, name, nationality, gender, numpass, addresse, phone);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return passenger;
    }

    public List<passengers> selectAllPassengers() {
        List<passengers> passengers = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PASSENGERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PI");
                String name = rs.getString("PName");
                String nationality = rs.getString("PNat");
                String gender = rs.getString("PGen");
                int numpass = rs.getInt("PPass");
                String addresse = rs.getString("PAdd");
                int phone = rs.getInt("Pphone");
                passengers.add(new passengers(id, name, nationality, gender, numpass, addresse, phone));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return passengers;
    }

    public boolean deletePassenger(int PI) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_PASSENGER_SQL)) {
            statement.setInt(1, PI);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updatePassenger(passengers passenger) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_PASSENGER_SQL)) {
        	 statement.setInt(1, passenger.getPI());
            statement.setString(2, passenger.getPName());
            statement.setString(3, passenger.getPNat());
            statement.setString(4, passenger.getPGen());
            statement.setInt(5, passenger.getPPass());
            statement.setString(6, passenger.getPAdd());
            statement.setInt(7, passenger.getPphone());
           
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
