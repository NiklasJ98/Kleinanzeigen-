/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.kleinanzeigen_portfolio_1.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author nfi
 */
//@Entity
public class Anzeige implements Serializable {

    public Anzeige() {
    }
    
    @Id
    @GeneratedValue
    private String titel;
    
    private String ersteller;
    
    private String kategorie;
    
    private enum art{ BIETE, SUCHE}
    
    private String beschreibung;
    
    private String erstelldatum;
    
    private String preis;
    
    private enum preis_art{ FESTPREIS, VERHANDLUNGSBASIS}
    
    
    @ManyToOne 
    private User user = new User();
    
    @OneToMany(mappedBy= "Anzeige")
    List<Category> category = new ArrayList<>();

    public String getErsteller() {
        return ersteller;
    }

    public void setErsteller(String ersteller) {
        this.ersteller = ersteller;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }



    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getErstelldatum() {
        return erstelldatum;
    }

    public void setErstelldatum(String erstelldatum) {
        this.erstelldatum = erstelldatum;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }




    
}
