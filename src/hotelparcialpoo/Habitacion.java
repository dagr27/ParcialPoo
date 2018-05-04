/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;

import java.util.Scanner;

/**
 *
 * @author ErikR
 * @author DanielG
 * @author EstherL
 * @author BrendaG
 */
public class Habitacion {
String idRoom;
    String status;
    String type;
    int price;
    
    Scanner leer = new Scanner(System.in);
    public Habitacion(){}
    public Habitacion(String idHabitacion, String estado, String tipo, int precio){
    this.idRoom = idHabitacion;
    this.status = estado;
    this.price = precio;
    }
    public void setIdRoom(String id){
        this.idRoom = id;
    }
    public void setStatus(String estado){
        this.status = estado;
    }
    public void setType(String tipo){
        this.type = tipo;
    }
    public void setPrice(int precio){
        this.price = precio;
    }
    
    public String getIdRoom(){
    return idRoom;
    }
    public String getStatus(){
    return status;
    }
    public String getType(){
    return type;
    }
    public int getPrice(){
    return price;
    }  
}
