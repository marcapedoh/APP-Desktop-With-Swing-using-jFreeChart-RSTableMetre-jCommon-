/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Entite.Facture;
import bd.ConnectBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author adral
 */
public class ServiceFacture {
    public static boolean VerifierDoublonFacture(String ref_facture){
        boolean retour=false;
        Connection connexion= ConnectBD.SeConnecter();
        String selectionUnique="select * from facture where ref_facture =?";
        PreparedStatement ps1=null;
        
        try {
            ps1=connexion.prepareStatement(selectionUnique);
            ps1.setString(1, ref_facture);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ps1!=null){
            try {
                ps1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(fetchallasPhp!=null){
            try {
                fetchallasPhp.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    
    public static int SaveFacture(Facture fac1){
        int retour=0;
        
        if(VerifierDoublonFacture(fac1.getRef_facture())){
            retour=2;
        }else{
               Connection connexion1=ConnectBD.SeConnecter();
        String InsertSql="insert into Facture(ref_facture,produits,montant,nomFournisseur) values(?,?,?,?)";
        
        PreparedStatement objectPrecompile=null;
        try {
            objectPrecompile=connexion1.prepareStatement(InsertSql);
            objectPrecompile.setString(1,fac1.getRef_facture());
            objectPrecompile.setString(2,fac1.getProduits());
            objectPrecompile.setDouble(3,fac1.getMontant());
            objectPrecompile.setString(4,fac1.getNomFournisseur());
            
            retour=objectPrecompile.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        if(connexion1!=null){
            try {
                connexion1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(objectPrecompile!=null){
            try {
                objectPrecompile.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
        }
        
      return retour;
    }
    
    public static Facture ReadFacture(String ref_facture){
       Facture fac1=new Facture();
        Connection connexion=ConnectBD.SeConnecter();
        String SelectionSql="select * from facture where ref_facture=?";
        PreparedStatement ps1=null;
        
        try {
            ps1=connexion.prepareStatement(SelectionSql);
            ps1.setString(1, ref_facture);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet tableau=null;
        try {
            tableau=ps1.executeQuery();
            if(tableau.next()){
                fac1.setId_facture(tableau.getInt(1));
                fac1.setRef_facture(tableau.getString(2));
                fac1.setProduits(tableau.getString(3));
                fac1.setMontant(tableau.getInt(4));
                fac1.setNomFournisseur(tableau.getString(5));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
           try {
               connexion.close();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        if(tableau!=null){
           try {
               tableau.close();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        if(ps1!=null){
           try {
               ps1.close();
           } catch (SQLException ex) {
               Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        return fac1;
    }
    
    public static int UpdateClient(Facture fac2){
        int retour=0;
        //1 ==>Error--
        String requeteUpdate="update facture set ref_facture=?, Produit=?, montant=? nom_fournisseur where id=?";
        Connection connexion1=ConnectBD.SeConnecter();
        PreparedStatement objectcompile=null;
        try {
            objectcompile=connexion1.prepareStatement(requeteUpdate);
            objectcompile.setString(1, fac2.getRef_facture());
            objectcompile.setString(2, fac2.getProduits());
            objectcompile.setDouble(3, fac2.getMontant());
            objectcompile.setString(4, fac2.getNomFournisseur());
            objectcompile.setInt(5, fac2.getId_facture());
            retour=objectcompile.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion1!=null){
            try {
                connexion1.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(objectcompile!=null){
            try {
                objectcompile.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    
    
    public static int DeleteFacture(String ref_facture){
        int retour=0;
        Connection connexion=ConnectBD.SeConnecter();
        String RequeteSup="delete from facture where ref_facture= ?";
        PreparedStatement prepareobject=null;
        try {
            prepareobject=connexion.prepareStatement(RequeteSup);
            prepareobject.setString(1, ref_facture);
            retour=prepareobject.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(connexion!=null){
            try {
                connexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(prepareobject!=null){
            try {
                prepareobject.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceFacture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retour;
    }
    

    
}
