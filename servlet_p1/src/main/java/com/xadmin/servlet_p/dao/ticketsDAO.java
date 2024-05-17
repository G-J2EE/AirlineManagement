package com.xadmin.servlet_p.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.bean.tickets;

//import com.xadmin.servlet_p.bean.passengers;

public class ticketsDAO {
	 	private String jdbcURL = "jdbc:mysql://localhost:3306/airlinedb";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "";
	    
	    private static final String INSERT_TICKET_SQL = "INSERT INTO bookingtbl (TicketId, PName, FlCode, PGen, PPass, Amount, Nationality) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    private static final String SELECT_TICKET_BY_ID = "SELECT TicketId, PName, FlCode, PGen, PPass, Amount, Nationality FROM bookingtbl WHERE TicketId = ?";
	    private static final String SELECT_ALL_TICKETS = "SELECT * FROM bookingtbl";
	    private static final String DELETE_TICKET_SQL = "DELETE FROM bookingtbl WHERE TicketId = ?";
	    private static final String UPDATE_TICKET_SQL = "UPDATE bookingtbl SET PName = ?, FlCode = ?, PGen = ?, PPass = ?, Amount = ?, Nationality = ? WHERE TicketId = ?";
	    
	    public ticketsDAO() {
	    }
	    
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
	    
	    public void insertBooking(tickets ticket) throws SQLException {
	    	try (Connection connection = getConnection();
	                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TICKET_SQL)) {
	            	            preparedStatement.setString(1, ticket.getPName());
	            preparedStatement.setString(2, ticket.getFlCode().getFlightcode());
	            preparedStatement.setString(3, ticket.getPGen());
	            preparedStatement.setString(4, ticket.getPPass());
	            preparedStatement.setInt(5, ticket.getAmount());
	            preparedStatement.setString(6, ticket.getNationality());
	            
	            preparedStatement.executeUpdate();
	        }
	    }

	    public tickets selectBooking(int TicketId) {
	        tickets ticket = null;
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TICKET_BY_ID)) {
	            preparedStatement.setInt(1, TicketId);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                String pName = rs.getString("PName");
	                String flCode = rs.getString("flCode");
	                String pGen = rs.getString("PGen");
	                String pPass = rs.getString("PPass");
	                int amount = rs.getInt("Amount");
	                String nationality = rs.getString("Nationality");

	                // Create a new Flight object using flCode
	                Flight flight = new Flight(flCode);

	                // Create a new tickets object
	                ticket = new tickets(TicketId, pName, flight, pGen, pPass, amount, nationality);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return ticket;
	        
	        
	    }

	    
	    public List<tickets> selectAllTickets() {
	        List<tickets> ticketsList = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TICKETS)) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                int ticketId = rs.getInt("TicketId");
	                String pName = rs.getString("PName");
	                String flCode = rs.getString("FlCode");
	                String pGen = rs.getString("PGen");
	                String pPass = rs.getString("PPass");
	                int amount = rs.getInt("Amount");
	                String nationality = rs.getString("Nationality");

	                // Assuming the Flight class constructor accepts a flight code
	                Flight flight = new Flight(flCode);

	                // Create a new tickets object and add it to the list
	                tickets ticket = new tickets(ticketId, pName, flight, pGen, pPass, amount, nationality);
	                ticketsList.add(ticket);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return ticketsList;
	    }
	    

	    public boolean deleteTicket(int ticketId) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(DELETE_TICKET_SQL)) {
	            statement.setInt(1, ticketId);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	    
	    public boolean updateTicket(tickets ticket) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(UPDATE_TICKET_SQL)) {
	            statement.setString(1, ticket.getPName());
	            statement.setString(2, ticket.getFlCode().getFlightcode());
	            statement.setString(3, ticket.getPGen());
	            statement.setString(4, ticket.getPPass());
	            statement.setInt(5, ticket.getAmount());
	            statement.setString(6, ticket.getNationality());
	            statement.setInt(7, ticket.getTicketId());
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
