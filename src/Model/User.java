/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hachem
 */

import java.util.ArrayList;

public sealed class User implements Comparable<User> permits Root {
    private String nom_util;
    private Password mdp_util;
    private ArrayList<Site> sites;
   
    public User(){}
    
    public User(String nom_util, Password mdp_util, ArrayList<Site> sites) {
        this.nom_util = nom_util;
        this.mdp_util = mdp_util;
        this.sites = sites;
    }
    
    public User(ArrayList<Site> sites) {
        this.sites = sites;
    }
    
    public User(String nom_util, Password mdp_util) {
        this.nom_util = nom_util;
        this.mdp_util = mdp_util;
    }
    
    public User(String nom_util , String mdp){
        this.nom_util=nom_util;
        this.mdp_util=new Password(mdp);
    }
    
    //getters et setters : 
    public String getNom_util() {
        return nom_util;
    }

    public void setNom_util(String nom_util) {
        this.nom_util = nom_util;
    }

    public Password getMdp_util() {
        return mdp_util;
    }

    public void setMdp_util(Password mdp_util) {
        this.mdp_util = mdp_util;
    }

    public ArrayList<Site> getSites() {
        return sites;
    }

    public void setSites(ArrayList<Site> sites) {
        this.sites = sites;
    }
    
    // les méthodes de User :
    
    // Méthode pour ajouter un site à la liste des sites
    public void ajouter_site(Site site) {
        sites.add(site);
    }

    // Méthode pour supprimer un site de la liste des sites
    public void supprimer_site(Site site) {
        sites.remove(site);
    }
    
    @Override
    public String toString(){
        return ("username = "+this.nom_util+"-----------------Password = ******************");
    }
    @Override
    public int compareTo(User otherUser) {
        // Comparaison basée sur le nom_util
        return this.nom_util.compareTo(otherUser.nom_util);
    }
}
