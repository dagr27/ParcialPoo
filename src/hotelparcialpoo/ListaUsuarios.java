/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelparcialpoo;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author ErikR
 * @author DanielG
 * @author EstherL
 * @author Brenda
 */
public class ListaUsuarios {
    private ArrayList<Usuario>users;
    public ListaUsuarios(){
        users = new ArrayList<>();
    }
    public void add(){
        Scanner leer = new Scanner(System.in);
        Usuario user = new Usuario();
        System.out.println("Ingrese el Usuario");
        String userId = leer.nextLine();
        if(ifExits(userId)== 0){
            users.add(user);       
            user.setUsuario(userId);
            System.out.println("Ingrese el nombre y luego el appelido");
            user.setName(leer.nextLine());
            user.setLastname(leer.nextLine());
        }else{
            System.out.println("\033[33mEste huesped ya esta registrado en la plataforma, intentelo nuevamente.");
        }
    }
    public void add(Usuario user) throws Exception{
        if(user != null){
            if (!users.contains(user)) {
                users.add(user);               
            }
            Exception e = new Exception("No se permiten Duplicados");
            throw e;
        }else{
            throw new Exception("No se puede agregar un estudiante nulo");
        }
    }
    public void MostrarUsuario(){
        int count = 1;
        for(Usuario usuario : users) {
            System.out.println(count+".Usuario: ["+usuario.user+"]"+" Nombre: ["+usuario.name+"]"+" Apellido: ["+usuario.lastname+"]");
            count += 1;
        }
    }
    public int ifExits(String username){
        int count = 0;
        for(Usuario usuario : users) {
            if(users.get(count).user.equals(username)){
                return 1;
            }
            count += 1;
        }
        return 0;
    }

}