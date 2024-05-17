// Source code is decompiled from a .class file using FernFlower decompiler.
package com.xadmin.servlet_p.dao;

import com.xadmin.servlet_p.bean.Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlightDAO {
   private static final String INSERT_FLIGHTS_SQL = "INSERT INTO flights (flightcode, source_l, destination_l, takeoffd, nbseats, amount) VALUES (?, ?, ?, ?, ?, ?)";
   private static final String UPDATE_FLIGHTS_SQL = "UPDATE flights SET source_l = ?, destination_l = ?, takeoffd = ?, nbseats = ?, amount = ? WHERE flightcode = ?";
   private static final String DELETE_FLIGHTS_SQL = "DELETE FROM flights WHERE flightcode = ?";
   private static final String GET_ALL_FLIGHTS = "SELECT * FROM flights";
   private static final String SELECT_FLIGHT_BY_ID = "SELECT * FROM flights WHERE flightcode = ?";
   private String jdbcURL = "jdbc:mysql://localhost:3306/airlinedb";
   private String jdbcUsername = "root";
   private String jdbcPassword = "";

   public FlightDAO() {
   }

   protected Connection getConnection() throws SQLException {
      Connection connection = null;

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         connection = DriverManager.getConnection(this.jdbcURL, this.jdbcUsername, this.jdbcPassword);
      } catch (ClassNotFoundException var3) {
         var3.printStackTrace();
      }

      return connection;
   }

   public void insertFlight(Flight flight) throws SQLException {
      Throwable var2 = null;
      Object var3 = null;

      try {
         Connection connection = this.getConnection();

         try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO flights (flightcode, source_l, destination_l, takeoffd, nbseats, amount) VALUES (?, ?, ?, ?, ?, ?)");

            try {
               preparedStatement.setString(1, flight.getFlightcode());
               preparedStatement.setString(2, flight.getSource_l());
               preparedStatement.setString(3, flight.getDestination_l());
               preparedStatement.setString(4, flight.getTakeoffd());
               preparedStatement.setInt(5, flight.getNbseats());
               preparedStatement.setDouble(6, flight.getAmount());
               preparedStatement.executeUpdate();
            } finally {
               if (preparedStatement != null) {
                  preparedStatement.close();
               }

            }
         } catch (Throwable var16) {
            if (var2 == null) {
               var2 = var16;
            } else if (var2 != var16) {
               var2.addSuppressed(var16);
            }

            if (connection != null) {
               connection.close();
            }

            throw var2;
         }

         if (connection != null) {
            connection.close();
         }

      } catch (Throwable var17) {
         if (var2 == null) {
            var2 = var17;
         } else if (var2 != var17) {
            var2.addSuppressed(var17);
         }

         throw var2;
      }
   }

   public boolean updateFlight(Flight flight) throws SQLException {
      Throwable var3 = null;
      Object var4 = null;

      try {
         Connection connection = this.getConnection();

         boolean rowUpdated;
         try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE flights SET source_l = ?, destination_l = ?, takeoffd = ?, nbseats = ?, amount = ? WHERE flightcode = ?");

            try {
               preparedStatement.setString(1, flight.getSource_l());
               preparedStatement.setString(2, flight.getDestination_l());
               preparedStatement.setString(3, flight.getTakeoffd());
               preparedStatement.setInt(4, flight.getNbseats());
               preparedStatement.setDouble(5, flight.getAmount());
               preparedStatement.setString(6, flight.getFlightcode());
               rowUpdated = preparedStatement.executeUpdate() > 0;
            } finally {
               if (preparedStatement != null) {
                  preparedStatement.close();
               }

            }
         } catch (Throwable var17) {
            if (var3 == null) {
               var3 = var17;
            } else if (var3 != var17) {
               var3.addSuppressed(var17);
            }

            if (connection != null) {
               connection.close();
            }

            throw var3;
         }

         if (connection != null) {
            connection.close();
         }

         return rowUpdated;
      } catch (Throwable var18) {
         if (var3 == null) {
            var3 = var18;
         } else if (var3 != var18) {
            var3.addSuppressed(var18);
         }

         throw var3;
      }
   }

   public boolean deleteFlight(String flightcode) throws SQLException {
      Throwable var3 = null;
      Object var4 = null;

      try {
         Connection connection = this.getConnection();

         boolean rowDeleted;
         try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM flights WHERE flightcode = ?");

            try {
               preparedStatement.setString(1, flightcode);
               rowDeleted = preparedStatement.executeUpdate() > 0;
            } finally {
               if (preparedStatement != null) {
                  preparedStatement.close();
               }

            }
         } catch (Throwable var17) {
            if (var3 == null) {
               var3 = var17;
            } else if (var3 != var17) {
               var3.addSuppressed(var17);
            }

            if (connection != null) {
               connection.close();
            }

            throw var3;
         }

         if (connection != null) {
            connection.close();
         }

         return rowDeleted;
      } catch (Throwable var18) {
         if (var3 == null) {
            var3 = var18;
         } else if (var3 != var18) {
            var3.addSuppressed(var18);
         }

         throw var3;
      }
   }

   public List<Flight> getAllFlights() {
      List<Flight> flights = new ArrayList();

      try {
         Throwable var2 = null;
         Object var3 = null;

         try {
            Connection connection = this.getConnection();

            try {
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flights");

               try {
                  ResultSet rs = preparedStatement.executeQuery();

                  while(rs.next()) {
                     String flightcode = rs.getString("flightcode");
                     String source = rs.getString("source_l");
                     String destination = rs.getString("destination_l");
                     String takeoffd = rs.getString("takeoffd");
                     int nbSeats = rs.getInt("nbseats");
                     double amount = rs.getDouble("amount");
                     flights.add(new Flight(flightcode, source, destination, takeoffd, nbSeats, amount));
                  }
               } finally {
                  if (preparedStatement != null) {
                     preparedStatement.close();
                  }

               }
            } catch (Throwable var27) {
               if (var2 == null) {
                  var2 = var27;
               } else if (var2 != var27) {
                  var2.addSuppressed(var27);
               }

               if (connection != null) {
                  connection.close();
               }

               throw var2;
            }

            if (connection != null) {
               connection.close();
            }
         } catch (Throwable var28) {
            if (var2 == null) {
               var2 = var28;
            } else if (var2 != var28) {
               var2.addSuppressed(var28);
            }

            throw var2;
         }
      } catch (SQLException var29) {
         this.printSQLException(var29);
      }

      return flights;
   }

   public Flight getFlight(String flightcode) {
      Flight flight = null;

      try {
         Throwable var3 = null;
         Object var4 = null;

         try {
            Connection connection = this.getConnection();

            try {
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flights WHERE flightcode = ?");

               try {
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
               } finally {
                  if (preparedStatement != null) {
                     preparedStatement.close();
                  }

               }
            } catch (Throwable var27) {
               if (var3 == null) {
                  var3 = var27;
               } else if (var3 != var27) {
                  var3.addSuppressed(var27);
               }

               if (connection != null) {
                  connection.close();
               }

               throw var3;
            }

            if (connection != null) {
               connection.close();
            }
         } catch (Throwable var28) {
            if (var3 == null) {
               var3 = var28;
            } else if (var3 != var28) {
               var3.addSuppressed(var28);
            }

            throw var3;
         }
      } catch (SQLException var29) {
         this.printSQLException(var29);
      }

      return flight;
   }

   private void printSQLException(SQLException ex) {
      Iterator var3 = ex.iterator();

      while(true) {
         Throwable e;
         do {
            if (!var3.hasNext()) {
               return;
            }

            e = (Throwable)var3.next();
         } while(!(e instanceof SQLException));

         e.printStackTrace(System.err);
         System.err.println("SQLState: " + ((SQLException)e).getSQLState());
         System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
         System.err.println("Message: " + e.getMessage());

         for(Throwable t = ex.getCause(); t != null; t = t.getCause()) {
            System.out.println("Cause: " + String.valueOf(t));
         }
      }
   }
}
