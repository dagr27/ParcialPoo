/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;

/*import java.util.InputMismatchException;*/
import java.util.Scanner;
/**
 *
 * @author Daniel Gómez
 */
public class Reservacion {
    static ListaReservacion lista = new ListaReservacion();
    int idReservation;
    String check_in;
    String check_out;
    String idRoom;
    String idPack;
    int price;
    String user;
    
    Scanner leer = new Scanner(System.in);
    public Reservacion(){}
    public Reservacion(int id, String fecha_entrada, String fecha_salida, String idHabitacion, String idPaquete, int precio, String usuario){
    this.idReservation = id;
    this.check_in = fecha_entrada;
    this.check_out = fecha_salida;
    this.idRoom = idHabitacion;
    this.idPack = idPaquete;
    this.price = precio;
    this.user = usuario;
    }
      public void setId(int id){
        this.idReservation = id;
    }
    public void setCheck_in(String fecha_entrada){
        this.check_in = fecha_entrada;
    }
    public void setCheck_out(String fecha_salida){
        this.check_out = fecha_salida;
    }
    public void setIdRoom(String idHabitacion){
        this.idRoom = idHabitacion;
    }
    public void setIdPack(String idPaquete){
        this.idPack = idPaquete;
    }
    public void setPrice(int precio){
        this.price = precio;
    }
    public void setUser(String usuario){
        this.user = usuario;
    }
    
    public int getId(){
    return idReservation;
    }
    public String getCheck_in(){
    return check_in;
    }
    public String getCheck_out(){
    return check_out;
    }
    public String getIdRoom(){
    return idRoom;
    }
    public String getIdPack(){
    return idPack;
    }
    public int getPrice(){
    return price;
    }
    public String getUser(){
    return user;
    }
    
}
