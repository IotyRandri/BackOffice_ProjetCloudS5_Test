/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Statistique;

import Model.Categorie;
import Model.Commission;
import Model.Utilisateur;
import Service.ServiceStatistique;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author randr
 */
public class getStatistiqueEnchere extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            ArrayList<Utilisateur> listemaxventeutilisateur = null;
            ArrayList<Categorie> listemaxventecategorie = null;
            ArrayList<Commission> commissionparmois = null;
            int nbutilisateur = 0;
            double soldecollecteactuel = 0;
            double pourcentagecommissionactuel = 0;
            double pourcentageencherevendu = 0;
            double pourcentageencherenonvendu = 0;
            
            try {
                ServiceStatistique ss = new ServiceStatistique();
                listemaxventeutilisateur = ss.getMaxVenteUtilisateur();
                listemaxventecategorie = ss.getMaxVenteCategorie();
                commissionparmois = ss.getCommissionparMois();
                
                nbutilisateur = ss.getNombreUtilisateur();
                soldecollecteactuel = ss.getSoldeCollecteActuel();
                pourcentageencherevendu = ss.getPourcentageEnchereVendu();
                pourcentageencherenonvendu = ss.getPourcentageEnchereNonVendu();
                pourcentagecommissionactuel = ss.getPourcentageCommissionActuel();
                
            } catch (SQLException ex) {
                Logger.getLogger(getStatistiqueEnchere.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
            request.setAttribute("maxventeutilisateur", listemaxventeutilisateur);
            request.setAttribute("maxventecategorie", listemaxventecategorie);
            request.setAttribute("commissionparmois", commissionparmois);
            
            request.setAttribute("nbutilisateurs", nbutilisateur);
            request.setAttribute("soldecollecteactuel", soldecollecteactuel);
            request.setAttribute("pourcentageencherevendu", (int)pourcentageencherevendu);
            request.setAttribute("pourcentageencherenonvendu", (int)pourcentageencherenonvendu);
            request.setAttribute("pourcentagecommissionactuel", pourcentagecommissionactuel);
            
            RequestDispatcher rqd = request.getRequestDispatcher("Statistiquetemplate.jsp");
            rqd.forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
