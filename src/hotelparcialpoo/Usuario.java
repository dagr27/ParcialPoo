/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author ErikR
 * @author DanielG
 * @author EstherL
 * @author Brenda
 */

public class Usuario {
      String user;
    String password;
    String name;
    String lastname;
    int type;
    
    Scanner leer = new Scanner(System.in);
    public Usuario(){}
    public Usuario(String usuario, String nombre, String apellido){
    this.user = usuario;
    this.name = nombre;
    this.lastname = apellido;
    }
    public void setUsuario(String usuario){
        this.user = usuario;
    }
    public void setName(String nombre){
        this.name = nombre;
    }
    public void setLastname(String apellido){
        this.lastname = apellido;
    }
    public String getUsuario(){
    return user;
    }
    public String getName(){
    return name;
    }
    public String getLastname(){
    return lastname;
    }  
}
