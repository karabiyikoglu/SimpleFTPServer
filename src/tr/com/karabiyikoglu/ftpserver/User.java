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
public class User {
    
    /** Creates a new instance of Users */
    public User() {
    }
    public User(String username,String password,String rootFolder,String writePermission){
        this.username = username;
        this.password = password;
        this.rootFolder = rootFolder;
        if(writePermission.equals("true"))
            this.writePermission = true;
        else
            this.writePermission = false;
    }

    /**
     * Holds value of property kullanici.
     */
    private String username;

    /**
     * Getter for property kullanici.
     * @return Value of property kullanici.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Setter for property kullanici.
     * @param username New value of property kullanici.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Holds value of property sifre.
     */
    private String password;

    /**
     * Getter for property sifre.
     * @return Value of property sifre.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for property sifre.
     * @param password New value of property sifre.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Holds value of property kok_klasor.
     */
    private String rootFolder;

    /**
     * Getter for property kok_klasor.
     * @return Value of property kok_klasor.
     */
    public String getRootFolder() {
        return this.rootFolder;
    }

    /**
     * Setter for property kok_klasor.
     * @param rootFolder New value of property kok_klasor.
     */
    public void setRootFolder(String rootFolder) {
        this.rootFolder = rootFolder;
    }

    /**
     * Holds value of property yazma_izni.
     */
    private boolean writePermission;

    /**
     * Getter for property yazma_izni.
     * @return Value of property yazma_izni.
     */
    public boolean isWritePermission() {
        return this.writePermission;
    }

    /**
     * Setter for property yazma_izni.
     * @param writePermission New value of property yazma_izni.
     */
    public void setWritePermission(boolean writePermission) {
        this.writePermission = writePermission;
    }

    
}
