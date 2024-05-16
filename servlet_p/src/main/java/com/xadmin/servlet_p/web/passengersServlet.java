package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.passengers;
import com.xadmin.servlet_p.dao.passengersDAO;

@WebServlet("/passengers")
public class passengersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private passengersDAO passengersDAO;

    public passengersServlet() {
        super();
    }

    public void init() throws ServletException {
        passengersDAO = new passengersDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertPassenger(request, response);
                    break;
                case "/delete":
                    deletePassenger(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updatePassenger(request, response);
                    break;
                default:
                    listPassengers(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("passengers-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("PI")); 
        passengers existingPassenger = passengersDAO.selectPassenger(id);

        // Envoyer le passager récupéré à la page JSP pour affichage dans le formulaire d'édition
        RequestDispatcher dispatcher = request.getRequestDispatcher("passengers-form.jsp");
        request.setAttribute("passenger", existingPassenger);
        dispatcher.forward(request, response);
    }


    public void insertPassenger(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String PName = request.getParameter("PName");
        String PNat = request.getParameter("PNat");
        String PGen = request.getParameter("PGen");
        
        int PPass = 0;
        if (request.getParameter("PPass") != null && !request.getParameter("PPass").isEmpty()) {
            PPass = Integer.parseInt(request.getParameter("PPass"));
        }
        
        String PAdd = request.getParameter("PAdd");
        
        int Pphone = 0;
        if (request.getParameter("Pphone") != null && !request.getParameter("Pphone").isEmpty()) {
            Pphone = Integer.parseInt(request.getParameter("Pphone"));
        }

        passengers newPassenger = new passengers(PName, PNat, PGen, PPass, PAdd, Pphone);
        passengersDAO.insertPassenger(newPassenger);
        response.sendRedirect("list");
    }


    private void updatePassenger(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = 0;
        if (request.getParameter("PI") != null && !request.getParameter("PI").isEmpty()) {
            id = Integer.parseInt(request.getParameter("PI"));
        }
        
        String PName = request.getParameter("PName");
        String PNat = request.getParameter("PNat");
        String PGen = request.getParameter("PGen");
        
        int PPass = 0;
        if (request.getParameter("PPass") != null && !request.getParameter("PPass").isEmpty()) {
            PPass = Integer.parseInt(request.getParameter("PPass"));
        }
        
        String PAdd = request.getParameter("PAdd");
        
        int Pphone = 0;
        if (request.getParameter("Pphone") != null && !request.getParameter("Pphone").isEmpty()) {
            Pphone = Integer.parseInt(request.getParameter("Pphone"));
        }

        passengers passenger = new passengers(PName, PNat, PGen, PPass, PAdd, Pphone);
        passenger.setPI(id);
        passengersDAO.updatePassenger(passenger);
        response.sendRedirect("passengers");
}

    private void deletePassenger(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    passengersDAO.deletePassenger(id);
    response.sendRedirect("list");
}

    

    private void listPassengers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<passengers> listPassengers = passengersDAO.selectAllPassengers();
        request.setAttribute("listPassengers", listPassengers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("passengers-list.jsp");
        dispatcher.forward(request, response);
    }
}