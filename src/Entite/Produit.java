/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

/**
 *
 * @author adral
 */
public class Produit {
    
    int id_prod,qte_paye;
    String nom_prod;

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getQte_paye() {
        return qte_paye;
    }

    public void setQte_paye(int qte_paye) {
        this.qte_paye = qte_paye;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public Produit(int id_prod, int qte_paye, String nom_prod) {
        this.id_prod = id_prod;
        this.qte_paye = qte_paye;
        this.nom_prod = nom_prod;
    }

    public Produit() {
    }

    public Produit(int id_prod) {
        this.id_prod = id_prod;
    }
   
    
}
