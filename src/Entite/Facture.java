/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

import java.util.logging.Logger;

/**
 *
 * @author adral
 */
public class Facture {
    private int id_facture;
    public String ref_facture;
    public String produits;
    public String Montants;
    public int montant;
    public String nomFournisseur;
    //private static final Logger LOG = Logger.getLogger(Facture.class.getName());

    public Facture() {
    }

    public Facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public Facture(int id_facture, String ref_facture, String produits, String Montants, int montant, String nomFournisseur) {
        this.id_facture = id_facture;
        this.ref_facture = ref_facture;
        this.produits = produits;
        this.Montants = Montants;
        this.montant = montant;
        this.nomFournisseur = nomFournisseur;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public String getRef_facture() {
        return ref_facture;
    }

    public void setRef_facture(String ref_facture) {
        this.ref_facture = ref_facture;
    }

    public String getProduits() {
        return produits;
    }

    public void setProduits(String produits) {
        this.produits = produits;
    }

    public String getMontants() {
        return Montants;
    }

    public void setMontants(String Montants) {
        this.Montants = Montants;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }
    
    
}
