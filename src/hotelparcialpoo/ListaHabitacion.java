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
    
        public void CambiarEstado(String idHabitacion, int estado){
        int i = 0;
        String mensaje = "";
        for(Habitacion habitacion : rooms) {
            if(idHabitacion.equals(rooms.get(i).idRoom)){
                if(estado==1){
                rooms.get(i).setStatus("Disponible");
               }else{
                rooms.get(i).setStatus("No disponible");
               }
                
                mensaje = "EL ESTADO SE CAMBIO CORRECTAMENTE.";
            }else{
                mensaje = "LA HABITACION QUE INGRESO NO EXISTE.";
            }
            i += 1;
        }
        System.out.println(mensaje);
    }
    
    public void CambiarEstadoPiso(String piso, int estado){
        int contador=1;
        int i = 0;
        String mensaje = "";
        for(Habitacion habitacion : rooms) {
           if(rooms.get(i).idRoom.equals(piso+contador)){
               if(estado==1){
                rooms.get(i).setStatus("Disponible");
               }else{
                rooms.get(i).setStatus("No disponible");
               }
               mensaje = "ESTADO CAMBIADO CORRECTAMENTE.";
            }else{
               mensaje = "\033[31mEL PISO QUE INGRESO NO EXISTE.";
               
           }
           contador +=1;
        if(contador>10){
            contador = 1;
        }
        i += 1;
    }
        System.out.println(mensaje);
    }
    
    public void CambiarPrecio(int precioBase){
            int contadorID = 1;
            int ascii = 65;
            char letra = ((char)(ascii));
            int i = 0;
            if(precioBase > 1){
            for(Habitacion habitacion : rooms) {
                if(contadorID <= 10){
                    if(letra==((char)(69)) || letra==(char)(70)){
                        rooms.get(i).setPrice((precioBase+((precioBase*10)/100)));
                    }else{
                        rooms.get(i).setPrice(precioBase); 
                    }
                    contadorID += 1;
                }else{
                    contadorID = 1;
                    ascii = ascii + 1;
                    letra = ((char)(ascii));
                }
                i += 1;
            }
            }else{
                System.out.println("\033[33mINGRESE UN NUMERO VALIDO");
            }
    }
    
    public int VerificarHabitacion(String idHabitacion){
        int contador = 1;
        for(Habitacion habitacion : rooms) {
            if(rooms.get(contador).status.equals("Disponible")){
                return 1;
            }
            contador += 1;
            }
        return 0;
    }
    
    public int Buscar(String idHabitacion){
        int contador = 0;
        int total = 0;
        for(Habitacion habitacion : rooms) {
            if(rooms.get(contador).idRoom.equals(idHabitacion)){
                total = rooms.get(contador).price;
            }else{
            contador += 1;
            }
        }
        return total;
    }
    
     public void MostrarHabitacion(){
        for(Habitacion habitacion : rooms) {
            System.out.println(habitacion.idRoom);
            System.out.println(habitacion.price);
            System.out.println(habitacion.status);
        }
    }
}
