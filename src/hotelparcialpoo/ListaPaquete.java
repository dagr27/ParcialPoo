/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 

 * @author EstherL

 * 
 */
public class ListaPaquete {
     private ArrayList<Paquete> packs;
    public ListaPaquete(){
        packs = new ArrayList<>();
    }
    public void add(){
        Scanner leer = new Scanner(System.in);
        for(int i=1;i<=2;i++){
            Paquete pack = new Paquete();
            if(i==1){
                pack.setIdPack(i);
                pack.setType("PREMIUM");
                pack.setPrice(150);
                pack.setService("Acceso a buffet de desayuno, acceso ilimitado a la piscina, servicio a la habitación, acceso ilimitado al minibar acceso a internet ilimitado y tiene un costo extra de 150 dólares por día.");
            }else if(i==2){
                pack.setIdPack(i);
                pack.setType("BASICO");
                pack.setPrice(10);
                pack.setService("Acceso a la piscina, acceso a internet ilimitado.");
            }
            packs.add(pack);
        }
    }
    
    public void add(Paquete pack) throws Exception{
        if(pack != null){
            if (packs.contains(pack)) {
                packs.add(pack);               
            }
            Exception e = new Exception("No se permiten Duplicados");
            throw e;
            
        }else{
            throw new Exception("No se puede agregar un estudiante nulo");
        }
    }
    
    public void CambiarServicio(int tipo, String servicio){
        if(tipo == 1){
            packs.get(0).setService(servicio);
        }else{
            packs.get(1).setService(servicio);
        }
    }
    
    public void CambiarPrecio(int tipo, int precio){
        if(precio > 1){
            if(tipo == 1){
                packs.get(0).setPrice(precio);
            }else{
                packs.get(1).setPrice(precio);
            }
        }else{
            System.out.println("\033[33mINGRESE UN NUMERO VALIDO.");
        }
    }
    
    public int Buscar(int idPaquete){
        int total = 0;
        total = packs.get(idPaquete-1).price;
        return total;
    }
   
    
    public void MostrarPaquete(){
        for(Paquete paquete : packs) {
            System.out.println(paquete.type);
            System.out.println(paquete.service);
            System.out.println(paquete.price);
            packs.remove(1);
        }
    }
}
