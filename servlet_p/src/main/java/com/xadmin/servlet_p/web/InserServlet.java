package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.passengers;
import com.xadmin.servlet_p.dao.passengersDAO;

/**
 * Servlet implementation class InserServlet
 */
@WebServlet("/InserServlet")
public class InserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire
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

        // Créer un nouvel objet passager
        passengers newPassenger = new passengers(PName, PNat, PGen, PPass, PAdd, Pphone);
        
        // Insérer le passager dans la base de données
        passengersDAO passengersDAO = new passengersDAO();
        try {
            passengersDAO.insertPassenger(newPassenger);
        } catch (SQLException e) {
            // Gérer les erreurs de la base de données lors de l'insertion du passager
            e.printStackTrace();
            // Vous pouvez rediriger vers une page d'erreur appropriée ici
        }
        
        // Redirection vers la page des passagers après l'insertion
        response.sendRedirect("passengers");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appeler doGet pour traiter les requêtes POST
        doGet(request, response);
    }
}