package com.example.myapplication.customlistView;

public class Facture {
    private String nom;

    // Image name (Without extension)
    private String image;
    private int montant;

    public Facture(String nom, String image, int montant) {
        this.nom= nom;
        this.image= image;
        this.montant= montant;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString()  {
        return this.nom;
}
}



