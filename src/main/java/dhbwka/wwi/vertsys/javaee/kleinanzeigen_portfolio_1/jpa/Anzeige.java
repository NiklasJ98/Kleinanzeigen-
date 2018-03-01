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
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Eine Anzeige
 */
@Entity
public class Anzeige implements Serializable {
//

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "anzeigen_ids")
    @TableGenerator(name = "anzeigen_ids", initialValue = 0, allocationSize = 50)
    private long id;

    @ManyToOne
    @NotNull(message = "Die Anzeige muss einem Benutzer zugeordnet werden.")
    private User user;

    @ManyToOne
    private Category category;

    private enum art {
        BIETE, SUCHE
    }

    @Column(length = 50)
    @NotNull(message = "Der Titel darf nicht leer sein.")
    @Size(min = 1, max = 50, message = "Der Titel muss zwischen ein und 50 Zeichen lang sein.")
    private String titel;

    @Lob
    @NotNull
    private String beschreibung;

    @NotNull(message = "Das Datum darf nicht leer sein.")
    private Date date;

    @NotNull(message = "Der Preis darf nicht leer sein.")
    private String preis;

    private enum preis_art {
        FESTPREIS, VERHANDLUNGSBASIS
    }

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Anzeige() {
    }

    public Anzeige(long id, User user, Category category, String titel, String beschreibung, Date date, String preis) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.date = date;
        this.preis = preis;
    }

    //</editor-fold>
//    <editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    //    </editor-fold>
}
