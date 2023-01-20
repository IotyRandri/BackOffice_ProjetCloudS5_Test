
<%@page import="java.util.ArrayList,Model.Utilisateur,Model.Categorie,Model.Commission" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Enchere</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2>Statistiques</h2>
            </div>
            
            <div class="row">
                <table class="table table-active" border="1">
                    <thead>
                        <th>Nombre Utilisateurs</th>
                        <th>Solde Collectes</th>
                        <th>Encheres Vendus</th>
                        <th>Encheres Non-Vendus</th>
                        <th>Pourcentage Commissions</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= request.getAttribute("nbutilisateurs") %></td>
                            <td><%= request.getAttribute("soldecollecteactuel") %></td>
                            <td><%= request.getAttribute("pourcentageencherevendu") %></td>
                            <td><%= request.getAttribute("pourcentageencherenonvendu") %></td>
                            <td><%= request.getAttribute("pourcentagecommissionactuel") %> %</td>
                        </tr>
                    </tbody>
                </table>
                
            </div>
            
            <div class="row">
                <h3>Utilisateur avec le plus de vente</h3>
                
                <% ArrayList<Utilisateur> maxventeutilisateur = (ArrayList<Utilisateur>) request.getAttribute("maxventeutilisateur"); %>
                <table class="table table-active" border="1">
                    <thead>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Adresse</th>
                        <th>Email</th>
                        <th>Prix Total des Ventes</th>
                    </thead>
                    <tbody>
                        <% for (Utilisateur u : maxventeutilisateur) {%>
                        <tr>
                            <td><%= u.getNom() %></td>
                            <td><%= u.getPrenom() %></td>
                            <td><%= u.getAdresse() %></td>
                            <td><%= u.getEmail() %></td>
                            <td><%= u.getTotalprixvente() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
            
            <div class="row">
                <h3>Categorie avec le plus de vente</h3>
                
                <% ArrayList<Categorie> maxventecategorie = (ArrayList<Categorie>) request.getAttribute("maxventecategorie"); %>
                <table class="table table-active" border="1">
                    <thead>
                        <th>Nom</th>
                        <th>Prix Total des Ventes</th>
                    </thead>
                    <tbody>
                        <% for (Categorie c : maxventecategorie) {%>
                        <tr>
                            <td><%= c.getNom() %></td>
                            <td><%= c.getTotalprixvente() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
            
            <div class="row">
                <h3>Commissions par mois</h3>

                <% ArrayList<Commission> commissionparmois = (ArrayList<Commission>) request.getAttribute("commissionparmois"); %>
                <table class="table table-active" border="1">
                    <thead>
                        <th>Mois</th>
                        <th>Annee</th>
                        <th>Commission</th>
                    </thead>
                    <tbody>
                        <% for ( Commission c : commissionparmois) {%>
                        <tr>
                            <td><%= c.getMois() %></td>
                            <td><%= c.getAnnee() %></td>
                            <td><%= c.getValeur() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
