/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entite.Commande;
import bd.ConnectBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adral
 */
public class ServiceCommande {
    
    public static int SaveCommande(Commande cde){
        int retour=0;
        Connection connexion=ConnectBD.SeConnecter();
        String requetesql="insert into commande(ref_commande,Qte_prod,montant,Date_commande,date_recuCommande) values(?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(requetesql);
            ps.setString(1,cde.getRef_commande());
            ps.setInt(2,cde.getQte_prod());
            ps.setInt(3,cde.getMontant());
            ps.setString(4,cde.getDate_commande());
            ps.setString(5,cde.getDate_recu_commande());
            retour=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retour;
    }
    
    public static Commande ReadCommande(String ref_commande){
        Commande cde1=new Commande();
        Connection connexion=ConnectBD.SeConnecter();
        String selectionsql="select * from Commande where ref_commande=?";
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(selectionsql);
            ps.setString(1, ref_commande);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet tab=null;
        try {
            tab=ps.executeQuery();
            if(tab.next()){
                cde1.setId_commande(tab.getInt(1));
                cde1.setRef_commande(tab.getString(2));
                cde1.setQte_prod(tab.getInt(3));
                cde1.setMontant(tab.getInt(4));
                cde1.setDate_commande(tab.getString(5));
                cde1.setDate_recu_commande(tab.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(tab!=null){
            try {
                tab.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cde1;
    }
    
    public static int UpdateCommande(Commande cde1){
        int result=0;
        Connection connexion=ConnectBD.SeConnecter();
        String sql="update commande set ref_commande=?,qte_prod=?,montant=?, date_commande=?, date_recuCommande=? where id_commande=?";
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(sql);
            ps.setString(1,cde1.getRef_commande());
            ps.setInt(2,cde1.getQte_prod());
            ps.setInt(3, cde1.getMontant());
            ps.setString(4,cde1.getDate_commande());
            ps.setString(5, cde1.getDate_recu_commande());
            ps.setInt(6,cde1.getId_commande());
            result=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return result;
    }
    public static int DeleteCommande(String ref_commande){
        int retour=0;
        Connection connexion=ConnectBD.SeConnecter();
        String sql=" Delete from commande where ref_commande=?";
        PreparedStatement ps=null;
        try {
            ps=connexion.prepareStatement(sql);
            ps.setString(1,ref_commande);
            retour=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retour;
    }
}
