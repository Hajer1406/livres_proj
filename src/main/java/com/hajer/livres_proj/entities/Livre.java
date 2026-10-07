package com.hajer.livres_proj.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivre;
    private String titreLivre;
    private Long nombrePages;
    private Date datePublication;

    @ManyToOne
    private Ecrivain ecrivain;

    public Livre() {
        super();
    }

    public Livre(String titreLivre, Long nombrePages, Date datePublication) {
        super();
        this.titreLivre = titreLivre;
        this.nombrePages = nombrePages;
        this.datePublication = datePublication;
    }

    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public Long getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(Long nombrePages) {
        this.nombrePages = nombrePages;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Ecrivain getEcrivain() {
        return ecrivain;
    }

    public void setEcrivain(Ecrivain ecrivain) {
        this.ecrivain = ecrivain;
    }

    @Override
    public String toString() {
        return "Livre [idLivre=" + idLivre + ", titreLivre=" + titreLivre + ", nombrePages=" + nombrePages
                + ", datePublication=" + datePublication + "]";
    }
}
