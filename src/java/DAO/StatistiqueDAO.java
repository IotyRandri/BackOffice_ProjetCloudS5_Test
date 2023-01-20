/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Categorie;
import Model.Commission;
import Model.Utilisateur;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author randr
 */
public class StatistiqueDAO {
    Connection c;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    private Connection getConnnection() throws SQLException{
        if (c == null){
            c = ConnectionBase.getconnectedPOSTGRES("vae", "vae", "vae");
        }
        return c;
    }
    
    public ArrayList<Utilisateur> getMaxVenteUtilisateur() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select * from ventemax_utilisateur");
        resultSet = preparedStatement.executeQuery();
        
        ArrayList<Utilisateur> listemaxvente = new ArrayList<Utilisateur>();
        while (resultSet.next()){
            Utilisateur u = new Utilisateur();
            u.setId(resultSet.getInt("Utilisateursid"));
            u.setNom(resultSet.getString("nom"));
            u.setPrenom(resultSet.getString("prenom"));
            u.setAdresse(resultSet.getString("adresse"));
            u.setEmail(resultSet.getString("email"));
            u.setDateNaissance(resultSet.getDate("datenaissance"));
            u.setTotalprixvente(resultSet.getDouble("prixtotalvente"));
            listemaxvente.add(u);
        }
        
//        c.close();
            
        return listemaxvente;
    }
    
    public ArrayList<Categorie> getMaxVenteCategorie() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select * from ventemax_categorie");
        resultSet = preparedStatement.executeQuery();
        
        ArrayList<Categorie> listemaxvente = new ArrayList<Categorie>();
        while (resultSet.next()){
            Categorie c = new Categorie();
            c.setId(resultSet.getInt("idCategorie"));
            c.setNom(resultSet.getString("nom"));
            c.setTotalprixvente(resultSet.getDouble("prixtotalvente"));
            listemaxvente.add(c);
        }
        
//        c.close();

            
        return listemaxvente;
    }
    
    public ArrayList<Commission> getCommissionparmois() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select * from commissionparmois");
        resultSet = preparedStatement.executeQuery();
        
        ArrayList<Commission> listecommission = new ArrayList<Commission>();
        while (resultSet.next()){
            Commission c = new Commission();
            c.setMois(resultSet.getInt("mois"));
            c.setAnnee(resultSet.getInt("annee"));
            c.setValeur(resultSet.getDouble("moyennecommissionparmois"));
            listecommission.add(c);
        }
        
//        c.close();
            
        return listecommission;
    }
    
    public int getNombreUtilisateur() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select count(id) from utilisateurs");
        resultSet = preparedStatement.executeQuery();
        int nbutilisateur = 0;
        
        while (resultSet.next()){
            nbutilisateur = resultSet.getInt(1);
        }
        
        return nbutilisateur;
    }
    
    public double getSoldeCollecteActuel() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select sum(montant) as soldeactuel from ArgentCollectes");
        resultSet = preparedStatement.executeQuery();
        double soldecollecteactuel = 0;
        
        while (resultSet.next()){
            soldecollecteactuel = resultSet.getDouble(1);
        }
        
        return soldecollecteactuel;
    }
    
    public double getPourcentageCommissionActuel() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select c.pourcentage from commissions c order by dates desc limit 1");
        resultSet = preparedStatement.executeQuery();
        
        double pourcentage = 0;
        while (resultSet.next()){
            pourcentage = resultSet.getDouble(1);
        }
        
        return pourcentage*100;
    }
    
    public int getNombreTotalEnchere() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select count(e.id) as nbtotalenchere from enchere e");
        resultSet = preparedStatement.executeQuery();
        
        int nombretotalenchere = 0;
        while (resultSet.next()){
            nombretotalenchere = resultSet.getInt(1);
        }
        
        return nombretotalenchere;
    }
    
    public int getNombreTotalEnchereVendu() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select count(enchereid) as nbtotalencherevendu from EnchereTerminer");
        resultSet = preparedStatement.executeQuery();
        
        int nombreencherevendu = 0;
        while (resultSet.next()){
            nombreencherevendu = resultSet.getInt(1);
        }
        
        return nombreencherevendu;
    }
    
    public int getNombreTotalEnchereNonVendu() throws SQLException{
        getConnnection();
        
        preparedStatement = c.prepareStatement("Select count(id) as nbtotalencherenonvendu from enchere where id not in (select enchereid from EnchereTerminer)");
        resultSet = preparedStatement.executeQuery();
        
        int nombreencherenonvendu = 0;
        while (resultSet.next()){
            nombreencherenonvendu = resultSet.getInt(1);
        }
        
        return nombreencherenonvendu;
    }
    
    private void closeConnection() throws SQLException{
        this.c.close();
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

}
