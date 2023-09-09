/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entite.Produit;
import bd.ConnectBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author adral
 */
public class ServiceProduit {
    
    public static int SaveProduit(Produit p1){
        int retour=0;
        
        Connection connexion1=ConnectBD.SeConnecter();
        String interSql="insert into produit (nom_prod,qte_paye) values(?,?)";
        PreparedStatement ps1=null;
        
        try {
            ps1=connexion1.prepareStatement(interSql);
            ps1.setString(1, p1.getNom_prod());
            ps1.setInt(2,p1.getQte_paye());
            retour=ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion1!=null){
            try {
                connexion1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps1!=null){
            try {
                ps1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retour;
    
    }
    
    public static Produit ReadProduit(String Nom_prod){
        Produit p1=new Produit();
        
        Connection connexion=ConnectBD.SeConnecter();
        String select="select * from produit where nom_prod=?";
        PreparedStatement ps=null;
        
        try {
            ps=connexion.prepareStatement(select);
            ps.setString(1,Nom_prod);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet tab=null;
        try {
            tab=ps.executeQuery();
            if(tab.next()){
                p1.setId_prod(tab.getInt(1));
                p1.setNom_prod(tab.getString(2));
                p1.setQte_paye(tab.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return p1;
    }
    
    public static int UpdateProduit(Produit prod){     
        int retour=0;
        Connection connexion=ConnectBD.SeConnecter();
        String requeteUpdate="update produit set nom_prod=?, qte_paye=? where id_prod=?";
        
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(requeteUpdate);
            ps.setString(1,prod.getNom_prod());
            ps.setInt(2, prod.getQte_paye());
            ps.setInt(3, prod.getId_prod());
            retour=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        
        return retour;
    }
    
    
    public static int DeleteProduit(String nom_prod){
        int retour=0;
        Produit pd=new Produit();
        Connection connexion=ConnectBD.SeConnecter();
        String requeteDel="delete from produit where nom_prod=?";
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(requeteDel);
            ps.setString(1, nom_prod);
            retour=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    
}
