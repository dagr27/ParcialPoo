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
 * 
 */
public class Paquete {
    int idPack;
    String type;
    int price;
    String service;
    
    Scanner leer = new Scanner(System.in);
    public Paquete(){}
    public Paquete(int idPaquete, String tipo, int precio, String servicio){
    this.idPack = idPaquete;
    this.type = tipo;
    this.price = precio;
    this.service = servicio;
    }
    public void setIdPack(int id){
        this.idPack = id;
    }
    public void setType(String tipo){
        this.type = tipo;
    }
    public void setPrice(int precio){
        this.price = precio;
    }
    public void setService(String servicio){
        this.service = servicio;
    }
    
    public int getIdPack(){
    return idPack;
    }
    public String getType(){
    return type;
    }
    public int getPrice(){
    return price;
    }
    public String getService(){
    return service;
    }
    
}
