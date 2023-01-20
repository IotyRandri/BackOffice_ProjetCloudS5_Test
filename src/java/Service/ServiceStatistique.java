/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DAO.StatistiqueDAO;
import Model.Categorie;
import Model.Commission;
import Model.Utilisateur;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author randr
 */
public class ServiceStatistique {
    StatistiqueDAO sDAO;
    
    private StatistiqueDAO getStatistiqueDAO(){
        if (sDAO == null){
            sDAO = new StatistiqueDAO();
        }
        return sDAO;
    }
    
    
    public ArrayList<Utilisateur> getMaxVenteUtilisateur() throws SQLException{
        sDAO = getStatistiqueDAO();
        return sDAO.getMaxVenteUtilisateur();
    }
    
    public ArrayList<Categorie> getMaxVenteCategorie() throws SQLException{
        sDAO = getStatistiqueDAO();
        return sDAO.getMaxVenteCategorie();
    }
    
    public ArrayList<Commission> getCommissionparMois() throws SQLException{
        sDAO = getStatistiqueDAO();
        return sDAO.getCommissionparmois();
    }
    
    public int getNombreUtilisateur() throws SQLException{
        sDAO = getStatistiqueDAO();
        return sDAO.getNombreUtilisateur();
    }
    
    public double getSoldeCollecteActuel() throws SQLException{
        sDAO = getStatistiqueDAO();
        return sDAO.getSoldeCollecteActuel();
    }
    
    public double getPourcentageCommissionActuel() throws SQLException{
        sDAO = getStatistiqueDAO();
        return sDAO.getPourcentageCommissionActuel();
    }
    
    public double getPourcentageEnchereVendu() throws SQLException{
        sDAO = getStatistiqueDAO();
        int nbtotalenchere = sDAO.getNombreTotalEnchere();
        int nbtotalencherevendu = sDAO.getNombreTotalEnchereVendu();
        System.out.println(nbtotalenchere);
        double pourcentage = ( (double)nbtotalencherevendu/(double)nbtotalenchere)*100;
        System.out.println(pourcentage);
        return pourcentage;
    }
    
    public double getPourcentageEnchereNonVendu() throws SQLException{
        sDAO = getStatistiqueDAO();
        int nbtotalenchere = sDAO.getNombreTotalEnchere();
        int nbtotalencherenonvendu = sDAO.getNombreTotalEnchereNonVendu();
        System.out.println(nbtotalencherenonvendu);
        double pourcentage = ((double)nbtotalencherenonvendu/(double)nbtotalenchere)*100;
        System.out.println(pourcentage);
        return pourcentage;
    }
        
    
    
}
