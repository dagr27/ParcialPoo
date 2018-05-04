/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author ErikR
 */
public class ListaHabitacion {
    private ArrayList<Habitacion> rooms;
    public ListaHabitacion(){
        rooms = new ArrayList<>();
    }
    int nHabitacion = 59;
    
    public void add(){
        Scanner leer = new Scanner(System.in);
        int contadorID = 1;
        int ascii = 65;
        char letra = ((char)(ascii));
        int precioBase = 60;

        for(int i=0;i<=nHabitacion;i++)
        {
            Habitacion room = new Habitacion();
                String result = String.valueOf(letra)+String.valueOf(contadorID);
                room.setIdRoom(result);
                room.setStatus("Disponible");
                
                if(contadorID%2==0){
                    room.setType("Doble");
                    room.setPrice(precioBase+((precioBase*15)/100));
                }else{
                    room.setType("Sencilla");
                    room.setPrice(precioBase);
                }

                if(letra==((char)(69)) || letra==(char)(70)){
                    if(contadorID%2==0){
                        room.setPrice(precioBase+(((precioBase*10)+(precioBase*15))/100));
                    }else{
                        room.setPrice(precioBase+((precioBase*10)/100));
                    }
                }
                
                contadorID += 1;
                rooms.add(room);
           
                if(contadorID>10){
                    contadorID = 1;
                    ascii = ascii + 1;
                    letra = ((char)(ascii));
                }
            }
        
    }
    public void add(Habitacion room) throws Exception{
        if(room != null){
            if (rooms.contains(room)) {
                rooms.add(room);               
            }
            Exception e = new Exception("No se permiten duplicados");
            throw e;
            
        }else{
            throw new Exception("No se puede agregar una habitacion nula");
        }
    }
    
    public void AgregarHabitacion(){
        Scanner leer = new Scanner(System.in);
        int contadorID = 1;
        int ascii = 65;
        char letra = ((char)(ascii));
        int precioBase = 60;
        Habitacion room = new Habitacion();
        for(int i=0;i<=rooms.size()+1;i++)
        {
           
                String result = String.valueOf(letra)+String.valueOf(contadorID-1);
                room.setIdRoom(result);
                room.setStatus("Disponible");
                
                if(contadorID%2==0){
                    room.setType("Doble");
                    room.setPrice(rooms.get(0).price+((rooms.get(0).price*15)/100));
                }else{
                    room.setType("Sencilla");
                    room.setPrice(rooms.get(0).price);
                }

                if(letra==((char)(69)) || letra==(char)(70)){
                    if(contadorID%2==0){
                        room.setPrice(rooms.get(0).price+(((rooms.get(0).price*10)+(rooms.get(0).price*15))/100));
                    }else{
                        room.setPrice(rooms.get(0).price+((rooms.get(0).price*10)/100));
                    }
                }
                
                contadorID += 1;
           
                if(contadorID>10){
                    contadorID = 1;
                    ascii = ascii + 1;
                    letra = ((char)(ascii));
                }
            }
        rooms.add(room);
        System.out.println("\033[32mHABITACION AGREGADA CORRECTAMENTE.");
    }
    
     public void MostrarHabitacion(){
        for(Habitacion habitacion : rooms) {
            System.out.println(habitacion.idRoom);
            System.out.println(habitacion.price);
            System.out.println(habitacion.status);
        }
    }
}
