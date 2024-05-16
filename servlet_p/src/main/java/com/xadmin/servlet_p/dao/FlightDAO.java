package com.xadmin.servlet_p.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.servlet_p.bean.Flight;

public class FlightDAO {
    private static final String INSERT_FLIGHTS_SQL = "INSERT INTO flights (flightcode, source_l, destination_l, takeoffd, nbseats, amount) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_FLIGHTS_SQL = "UPDATE flights SET source_l = ?, destination_l = ?, takeoffd = ?, nbseats = ?, amount = ? WHERE flightcode = ?";
    private static final String DELETE_FLIGHTS_SQL = "DELETE FROM flights WHERE flightcode = ?";
    private static final String GET_ALL_FLIGHTS = "SELECT * FROM flights";
    private static final String SELECT_FLIGHT_BY_ID = "SELECT * FROM flights WHERE flightcode = ?";

    private String jdbcURL = "jdbc:mysql://localhost:3306/airlinedb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    public FlightDAO() {}

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertFlight(Flight flight) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FLIGHTS_SQL)) {
            preparedStatement.setString(1, flight.getFlightcode());
            preparedStatement.setString(2, flight.getSource_l());
            preparedStatement.setString(3, flight.getDestination_l());
            preparedStatement.setString(4, flight.getTakeoffd());
            preparedStatement.setInt(5, flight.getNbseats());
            preparedStatement.setDouble(6, flight.getAmount());
            preparedStatement.executeUpdate();
        }
    }

    public boolean updateFlight(Flight flight) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FLIGHTS_SQL)) {
            preparedStatement.setString(1, flight.getSource_l());
            preparedStatement.setString(2, flight.getDestination_l());
            preparedStatement.setString(3, flight.getTakeoffd());
            preparedStatement.setInt(4, flight.getNbseats());
            preparedStatement.setDouble(5, flight.getAmount());
            preparedStatement.setString(6, flight.getFlightcode());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteFlight(String flightcode) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FLIGHTS_SQL)) {
            preparedStatement.setString(1, flightcode);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_FLIGHTS)) {
               ResultSet rs = preparedStatement.executeQuery();
               while (rs.next()) {
                   String flightcode = rs.getString("flightcode");
                   String source = rs.getString("source_l");
                   String destination = rs.getString("destination_l");
                   String takeoffd = rs.getString("takeoffd");
                   int nbSeats = rs.getInt("nbseats");
                   double amount = rs.getDouble("amount");
                   flights.add(new Flight(flightcode, source, destination, takeoffd, nbSeats, amount));
               }
           } catch (SQLException e) {
               printSQLException(e);
           }
           return flights;
       }

       public Flight getFlight(String flightcode) {
           Flight flight = null;
           try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FLIGHT_BY_ID)) {
               preparedStatement.setString(1, flightcode);
               ResultSet rs = preparedStatement.executeQuery();
               if (rs.next()) {
                   String source = rs.getString("source_l");
                   String destination = rs.getString("destination_l");
                   String takeoffd = rs.getString("takeoffd");
                   int nbSeats = rs.getInt("nbseats");
                   double amount = rs.getDouble("amount");
                   flight = new Flight(flightcode, source, destination, takeoffd, nbSeats, amount);
               }
           } catch (SQLException e) {
               printSQLException(e);
           }
           return flight;
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

