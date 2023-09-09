/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Entite.Client;
import bd.ConnectBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adral
 */
public class ServiceClient {
    
    public static boolean VerifierDoublonClient(String nom_client){
        boolean retour=false;
        Connection connexion= ConnectBD.SeConnecter();
        String selectionUnique="select * from client where nom_client=?";
        PreparedStatement ps1=null;
        
        try {
            ps1=connexion.prepareStatement(selectionUnique);
            ps1.setString(1, nom_client);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet fetchallasPhp=null;
        try {
            fetchallasPhp=ps1.executeQuery();
            if(fetchallasPhp.next()){
                retour=true;
            }
            else{
                retour=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps1!=null){
            try {
                ps1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(fetchallasPhp!=null){
            try {
                fetchallasPhp.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    
    public static int SaveClient(Client cl1){
        int retour=0;
        
        if(VerifierDoublonClient(cl1.getNom_client())){
            retour=2;
        }else{
               Connection connexion1=ConnectBD.SeConnecter();
        String InsertSql="insert into Client(nom_client,prenom_client,adresse_client) values(?,?,?)";
        
        PreparedStatement objectPrecompile=null;
        try {
            objectPrecompile=connexion1.prepareStatement(InsertSql);
            objectPrecompile.setString(1,cl1.getNom_client());
            objectPrecompile.setString(2,cl1.getPrenom_client());
            objectPrecompile.setString(3,cl1.getAdresse_client());
            retour=objectPrecompile.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        if(connexion1!=null){
            try {
                connexion1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(objectPrecompile!=null){
            try {
                objectPrecompile.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
        }
        
      return retour;
    }
    
    public static Client ReadClient(String nom_client){
       Client cl1=new Client();
        Connection connexion=ConnectBD.SeConnecter();
        String SelectionSql="select * from client where nom_client=?";
        PreparedStatement ps1=null;
        
        try {
            ps1=connexion.prepareStatement(SelectionSql);
            ps1.setString(1, nom_client);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet tableau=null;
        try {
            tableau=ps1.executeQuery();
            if(tableau.next()){
                cl1.setId_client(tableau.getInt(1));
                cl1.setNom_client(tableau.getString(2));
                cl1.setPrenom_client(tableau.getString(3));
                cl1.setAdresse_client(tableau.getString(4));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
           try {
               connexion.close();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        if(tableau!=null){
           try {
               tableau.close();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        if(ps1!=null){
           try {
               ps1.close();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        return cl1;
    }
    
    public static int UpdateClient(Client cl2){
        int retour=0;
        //1 ==>Error--
        String requeteUpdate="update client set nom_client=?, Prenom_client=?, adresse_client=? where id_client=?";
        Connection connexion1=ConnectBD.SeConnecter();
        PreparedStatement objectcompile=null;
        try {
            objectcompile=connexion1.prepareStatement(requeteUpdate);
            objectcompile.setString(1, cl2.getNom_client());
            objectcompile.setString(2, cl2.getPrenom_client());
            objectcompile.setString(3, cl2.getAdresse_client());
            objectcompile.setInt(4, cl2.getId_client());
            retour=objectcompile.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion1!=null){
            try {
                connexion1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(objectcompile!=null){
            try {
                objectcompile.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    
    
    public static int DeleteClient(String nom_client){
        int retour=0;
        Connection connexion=ConnectBD.SeConnecter();
        String RequeteSup="delete from Client where nom_client= ?";
        PreparedStatement prepareobject=null;
        try {
            prepareobject=connexion.prepareStatement(RequeteSup);
            prepareobject.setString(1, nom_client);
            retour=prepareobject.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(prepareobject!=null){
            try {
                prepareobject.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    
    
}
