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
public class PasswordManager {
    private String nom="SecPass";
    private String username;
    private Password mdp_app;
    private ArrayList<User> users;

    public PasswordManager(String username , Password mdp_app) {
        this.username=username;
        this.mdp_app=mdp_app;
        this.users = new ArrayList<>();
    }
    
    public PasswordManager(String username , Password mdp_app , ArrayList<User> users) {
        this.username=username;
        this.mdp_app=mdp_app;
        this.users = users;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Password getMdp_app() {
        return mdp_app;
    }

    public void setMdp_app(Password mdp_app) {
        this.mdp_app = mdp_app;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
