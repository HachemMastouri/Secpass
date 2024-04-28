/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hache
 */


public class Site {
    private String site_nom;
    private String username;
    private Password mdp_site;
    
    //constructeur : 
     
    public Site(){}
    
    public Site(String site_nom, String username, Password mdp_site) {
        this.site_nom = site_nom;
        this.username = username;
        this.mdp_site = mdp_site;
    }
    //setters et getters de site : 

    public String getSite_nom() {
        return site_nom;
    }

    public void setSite_nom(String site_nom) {
        this.site_nom = site_nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Password getMdp_site() {
        return mdp_site;
    }

    public void setMdp_site(Password mdp_site) {
        this.mdp_site = mdp_site;
    }
    
    
    public String toString(){
        return this.site_nom;
    }
}
