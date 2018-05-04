/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;
import java.text.ParseException;
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
    static ListaUsuarios lista = new ListaUsuarios();
    ListaReservacion list = Reservacion.lista;
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
    public void inicio() {
        System.out.println("----- Bienvenido -----");
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Agregar Huesped");
        System.out.println("3. Registrar Reserva");
        System.out.println("4. Salir");    
    }
    public void mostrar() throws ParseException{
        int opcion = 1;
        while (opcion != 4) {
            inicio();
            try {
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                         System.out.println("Ingrese sus credenciales de Administrador");
                         login();
                        break;
                    case 2:
                        System.out.println("Registrando Huesped");
                        lista.add();
                        break;
                    case 3:
                        System.out.println("Agregar Nueva Reservacion");
                        list.add();
                        break;
                    case 4:
                        System.out.println("Gracias Por usar el sistema");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, ingrese una de las opciones.");
                leer.nextLine();
            }
        }
    } 
    public void login() throws ParseException{
        ListaUsuarios u = new ListaUsuarios();
        Menu menu = Menu.getInstance();
        Scanner leer = new Scanner(System.in);
        String usuario,contra;
        usuario = leer.nextLine();
        contra = leer.nextLine();
        if(usuario.equals("admin") && contra.equals("12345")){
            System.out.println("----Modulo Administrador----");
            menu.mostrar();
        }else{
            System.out.println("Intentalo de nuevo");
        }
    }
    
}

