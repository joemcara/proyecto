/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.model;

import ec.edu.espol.proyecto.uil.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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

    public Dueño(int id, String nombres, String apellidos, String telefono, String email, ArrayList<Mascota> mascota) {
        this.id = id;
        this.nombre = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.mascota = mascota;
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

    public void addMascota(Mascota nueva) {
        this.getMascota().add(nueva);
    }

    @Override
    public String toString() {
        return "Dueño{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", email=" + email + ", mascota=" + mascota + '}';
    }
    

    public static Dueño nextDueño(Scanner sc) {
        System.out.println("Ingrese los datos del Dueño segun se indica: ");
        System.out.println("nombre del archivo a registrar");
        String nomfile = sc.next();
        int id = Util.nextID(nomfile);
        System.out.println("ingrese los nombre: ");
        String nombres = sc.next();
        System.out.println("ingrese los apellidos: ");
        String apellidos = sc.next();
        System.out.println("ingrese el telefono: ");
        String telefono = sc.next();
        System.out.println("ingrese el email: ");
        String email = sc.next();
        ArrayList<Mascota> mascotasL = new ArrayList<Mascota>();

        Dueño nuevo = new Dueño(id, nombres, apellidos, telefono, email, mascotasL);

        return nuevo;
    }
    public void saveFile(String nomFile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(id+"|"+nombre+"|"+apellidos+"|"+telefono+"|"+email+"|"+mascota);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
