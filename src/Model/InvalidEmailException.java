/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hache
 */
public class InvalidEmailException extends Exception {
  
    public InvalidEmailException() {
        super("L'adresse e-mail fournie est invalide. Elle doit contenir le caractère '@'.");
    }

    public InvalidEmailException(String message) {
        super(message);
    }
}
