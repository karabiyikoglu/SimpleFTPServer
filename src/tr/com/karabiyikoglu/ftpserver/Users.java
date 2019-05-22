/*
 * Users.java
 *
 * Created on June 4, 2006, 10:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tr.com.karabiyikoglu.ftpserver;

/**
 *
 * @author ismail1
 */
public class Users {
    
    /** Creates a new instance of Users */
    public Users() {
    }
    public Users(String kullanici,String sifre,String kok_klasor,String yazma_izni){
        this.kullanici = kullanici;
        this.sifre = sifre;
        this.kok_klasor = kok_klasor;
        if(yazma_izni.equals("true"))
            this.yazma_izni = true;
        else
            this.yazma_izni = false;
    }

    /**
     * Holds value of property kullanici.
     */
    private String kullanici;

    /**
     * Getter for property kullanici.
     * @return Value of property kullanici.
     */
    public String getKullanici() {
        return this.kullanici;
    }

    /**
     * Setter for property kullanici.
     * @param kullanici New value of property kullanici.
     */
    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    /**
     * Holds value of property sifre.
     */
    private String sifre;

    /**
     * Getter for property sifre.
     * @return Value of property sifre.
     */
    public String getSifre() {
        return this.sifre;
    }

    /**
     * Setter for property sifre.
     * @param sifre New value of property sifre.
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    /**
     * Holds value of property kok_klasor.
     */
    private String kok_klasor;

    /**
     * Getter for property kok_klasor.
     * @return Value of property kok_klasor.
     */
    public String getKok_klasor() {
        return this.kok_klasor;
    }

    /**
     * Setter for property kok_klasor.
     * @param kok_klasor New value of property kok_klasor.
     */
    public void setKok_klasor(String kok_klasor) {
        this.kok_klasor = kok_klasor;
    }

    /**
     * Holds value of property yazma_izni.
     */
    private boolean yazma_izni;

    /**
     * Getter for property yazma_izni.
     * @return Value of property yazma_izni.
     */
    public boolean isYazma_izni() {
        return this.yazma_izni;
    }

    /**
     * Setter for property yazma_izni.
     * @param yazma_izni New value of property yazma_izni.
     */
    public void setYazma_izni(boolean yazma_izni) {
        this.yazma_izni = yazma_izni;
    }

    
}
