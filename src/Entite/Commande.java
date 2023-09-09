/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

/**
 *
 * @author adral
 */
public class Commande {
    private int id_commande;
    public String ref_commande;
    public int qte_prod;
    public int montant;
    public String date_commande;
    public String date_recu_commande;

    public String getDate_recu_commande() {
        return date_recu_commande;
    }

    public void setDate_recu_commande(String date_recu_commande) {
        this.date_recu_commande = date_recu_commande;
    }
    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getRef_commande() {
        return ref_commande;
    }

    public void setRef_commande(String ref_commande) {
        this.ref_commande = ref_commande;
    }

    public int getQte_prod() {
        return qte_prod;
    }

    public void setQte_prod(int qte_prod) {
        this.qte_prod = qte_prod;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public Commande(int id_commande, String ref_commande, int qte_prod, int montant, String date_commande) {
        this.id_commande = id_commande;
        this.ref_commande = ref_commande;
        this.qte_prod = qte_prod;
        this.montant = montant;
        this.date_commande = date_commande;
    }

    public Commande(int id_commande) {
        this.id_commande = id_commande;
    }
    
    public Commande(){
        
    }
    
}
