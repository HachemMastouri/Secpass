/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Arrays;
import java.util.stream.Collectors;

import java.security.SecureRandom;

/**
 *
 * @author hachem
 */
public class Password {
    private String mdp_plain;
    private String salt;
    private String mdp_hashed;
    private final int taille_mdp=18;
    public static final String char_Poss = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
    public static final String Majus_Poss = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public Password(){}
    
    public Password(String mdp_plain){
        this.mdp_plain = mdp_plain;
    }
    public Password(String mdp_plain , String salt){
        this.mdp_plain = mdp_plain;
        this.salt = salt;
    }
    public Password(String mdp_plain, String salt, String mdp_hashed) {
        this(mdp_plain);
        this.salt = salt;
        this.mdp_hashed = mdp_hashed;
    }
    //setters et getters de Password : 
    
    public String getMdp_plain() {
        return mdp_plain;
    }

    public void setMdp_plain(String mdp_plain) {
        this.mdp_plain = mdp_plain;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMdp_hashed() {
        return mdp_hashed;
    }
    
    // les methodes de Password : 
    public String chaine_vers_binaire(String mdp){
        byte[] bytes = mdp.getBytes();
        StringBuilder binaire = new StringBuilder();
        for (byte b : bytes) {
            int valeur = b;
            for (int i = 7; i >= 0; i--) {
                if ((valeur & (1 << i)) == 0)
                    binaire.append('0');
                else 
                {
                    binaire.append('1');
                }
            }
            binaire.append(" ");
        }
        return binaire.toString().trim();
    }
    
    public String binaire_vers_hex(String binaire){
        String[] parts_bin = binaire.split(" ");
        StringBuilder hex = new StringBuilder();

        for (String part_bin : parts_bin) {
            int val_dec = Integer.parseInt(part_bin, 2);
            String val_hex = Integer.toHexString(val_dec);
            hex.append(val_hex).append(' ');
        }

        return hex.toString().trim();
    }
    
    public String hex_vers_binaire(String hex){
        StringBuilder binaire = new StringBuilder();

        for (char hex_Char : hex.toCharArray()){
            int val_dec = Character.digit(hex_Char,16);
            String partie_bin = String.format("%4s", Integer.toBinaryString(val_dec)).replace(' ', '0');
            binaire.append(partie_bin).append(' ');}
        return binaire.toString().trim();
    }
    
    public String hex_vers_chaine(String hex) {
        StringBuilder chaine = new StringBuilder();
        String[] parties_Hex = hex.split(" ");
        for (String partie_Hex : parties_Hex) {
            // Convertir la partie hexadécimale en décimal
            int decimalValue = Integer.parseInt(partie_Hex, 16);
            // Ajouter le caractère correspondant à la chaîne
            chaine.append((char) decimalValue);
        }
        return chaine.toString();
    }
    
    public String generate_salt(int taille){
        SecureRandom random = new SecureRandom();
        StringBuilder password_genere = new StringBuilder();

        for (int i = 0; i < taille; i++) {
            int index = random.nextInt(Password.Majus_Poss.length());
            char randomChar = Password.Majus_Poss.charAt(index);
            password_genere.append(randomChar);
        }

        return password_genere.toString();
    }
     
    public String generate_Password(int taille){
        SecureRandom random = new SecureRandom();
        StringBuilder password_genere = new StringBuilder();

        for (int i = 0; i < taille; i++) {
            int index = random.nextInt(Password.char_Poss.length());
            char randomChar = Password.char_Poss.charAt(index);
            password_genere.append(randomChar);
        }

        return password_genere.toString();
    }
        public void inverserBit(char[] bits, int position) {
        if (position < 1 || position > 8) {
            throw new IllegalArgumentException("La position doit être entre 1 et 8 inclus");
        }
        if (bits[8 - position] == '0') {
            bits[8 - position] = '1';}
        else {
            bits[8 - position] = '0';
        }
    }
        
        public void secure_Salt(String salt){
            String s0 = this.chaine_vers_binaire(salt);
            String [] sous_chaines = s0.split(" ");
            String s1 = Arrays.stream(sous_chaines).map(mot -> {
                    char[] bits = mot.toCharArray();
                    inverserBit(bits, 2);
                    inverserBit(bits, 3);
                    inverserBit(bits, 5);
                    inverserBit(bits, 8);
                    return new String(bits);
                }).collect(Collectors.joining(" "));
            String aux = this.binaire_vers_hex(s1);
            String [] auxs = aux.split(" ");
            this.salt = Arrays.stream(auxs).map(mot->""+mot).collect(Collectors.joining(""));
        }
        
        public String reverse(String will_be_reversed){
            String reversed = new StringBuilder(will_be_reversed).reverse().toString();
            return reversed;
        }
        
        public String adjust_Password(String mdp){
            int i=18-mdp.length();
            int j=0;
            while(i>0){
                StringBuilder r = new StringBuilder(mdp);
                r.append(Password.Majus_Poss.charAt(j));
                j++;
                i--;
            }
            return mdp;
        }
    // authentification : salt faut être fixe : 
        public String auth_hash(String mdp , String salt){
            mdp=this.adjust_Password(mdp);
            this.mdp_plain=mdp;
            this.salt=salt;
            String s = this.getMdp_plain()+this.getSalt();
            String result = this.chaine_vers_binaire(s);
            result+=" 01001000 ";
            result+="01100001 ";
            result+="01100011 ";
            result+="01101000 ";
            result+="01100101 ";
            result+="01101101";
            String [] mots = result.split(" ");
            String s1 = Arrays.stream(mots).map(mot -> {
                    char[] bits = mot.toCharArray();
                    inverserBit(bits, 2);
                    inverserBit(bits, 3);
                    inverserBit(bits, 5);
                    inverserBit(bits, 8);
                    return new String(bits);
                }).collect(Collectors.joining(" "));
            String aux = this.binaire_vers_hex(s1);
            String [] auxs = aux.split(" ");
            String without_reverse = Arrays.stream(auxs).map(mot->""+mot).collect(Collectors.joining(""));
            this.mdp_hashed=this.reverse(without_reverse);
            return this.mdp_hashed;
        }
        
    // le plus important : chifrer() et dechifrer();
        public String chiffrer(){
            this.mdp_plain=generate_Password(18);
            this.salt=generate_salt(8);
            String s = this.getMdp_plain()+this.getSalt();
            String result = this.chaine_vers_binaire(s);
            result+=" 01001000 ";
            result+="01100001 ";
            result+="01100011 ";
            result+="01101000 ";
            result+="01100101 ";
            result+="01101101";
            String [] mots = result.split(" ");
            //this.mdp_hashed = Arrays.stream(mots).map(mot->""+mot).collect(Collectors.joining(""));
            String s1 = Arrays.stream(mots).map(mot -> {
                    char[] bits = mot.toCharArray();
                    inverserBit(bits, 2);
                    inverserBit(bits, 3);
                    inverserBit(bits, 5);
                    inverserBit(bits, 8);
                    return new String(bits);
                }).collect(Collectors.joining(" "));
            String aux = this.binaire_vers_hex(s1);
            String [] auxs = aux.split(" ");
            String without_reverse = Arrays.stream(auxs).map(mot->""+mot).collect(Collectors.joining(""));
            this.mdp_hashed=this.reverse(without_reverse);
            this.secure_Salt(this.salt);
            return this.mdp_hashed;
        }
    
        public String dechiffrer(String hash_reversed , String salt_secured){
            String hash = this.reverse(hash_reversed);
            String s = this.hex_vers_binaire(hash);
            String [] si = s.split(" ");
            StringBuilder collapsed = new StringBuilder();
            for (int i = 0 ; i<si.length-1; i+=2){
                collapsed.append(si[i].trim()).append(si[i + 1].trim()).append(" ");
            }
            String collaps = collapsed.toString();
            String [] mots = collaps.split(" ");
            String s1 = Arrays.stream(mots).map(mot -> {
                    char[] bits = mot.toCharArray();
                    inverserBit(bits, 2);
                    inverserBit(bits, 3);
                    inverserBit(bits, 5);
                    inverserBit(bits, 8);
                    return new String(bits);
                }).collect(Collectors.joining(" "));
            String aux = this.binaire_vers_hex(s1);
            String resultat_aux = this.hex_vers_chaine(aux);
            String result = resultat_aux.substring(0,18);
            return result;
        }
        
}
