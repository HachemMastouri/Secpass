/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.ArrayList;

/**
 *
 * @author hachem
 */
public final class Root extends User{
    private String email;
    private String tel;
    
    // constructeur : 
    public Root (){}
    
    public Root(String nom_util , Password mdp_util){
        super(nom_util , mdp_util);
    }
    
    public Root(String nom_util, Password mdp_util, ArrayList<Site> sites , String email , String tel){
        super(nom_util,mdp_util,sites);
        this.email=email;
        this.tel=tel;
    }
    
    // setters et getters : 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
