/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yoser
 */
public class Dueño {

    private int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private ArrayList<Mascota> mascota;
    
    public Dueño(int id, String nombres, String apellidos, String telefono,String email, ArrayList<Mascota> mascota){
        this.id = id;
        this.nombre= nombres;
        this.apellidos= apellidos;
        this.telefono= telefono;
        this.email= email;
        this.mascota= mascota;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Mascota> getMascota() {
        return mascota;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMascota(ArrayList<Mascota> mascota) {
        this.mascota = mascota;
    }
    
    
    public static Dueño nextDueño(Scanner sc){
        System.out.println("Ingrese los datos del Dueño segun se indica: ");
        System.out.println("id ");
        int id = sc.nextInt();
        System.out.println("ingrese los nombres: ");
        String nombres = sc.next();
        System.out.println("ingrese los apellidos: ");
        String apellidos = sc.next();
        System.out.println("ingrese el telefono: ");
        String telefono = sc.next();
        System.out.println("ingrese el email: ");
        String email= sc.next();
        ArrayList<Mascota> mascotasD = new ArrayList<Mascota>();
        System.out.println("cuantas mascotas tiene este Dueño ");
    }
  

}
