package ec.edu.espol.proyecto.model;

import ec.edu.espol.proyecto.uil.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author onlyw
 */
public class MiembroJurado {

    private int idjurado;
    private String nombre;
    private String apellido;
    private String email;
    private String perfil;
    private ArrayList<Evaluacion> evaluacion;

    public MiembroJurado(int idjurado, String nombre, String apellido, String email, String perfil) {
        this.idjurado = idjurado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.perfil = perfil;
        this.evaluacion = new ArrayList<>();
    }

    public ArrayList<Evaluacion> getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(ArrayList<Evaluacion> evaluacion) {
        this.evaluacion = evaluacion;
    }

    public int getIdjurado() {
        return idjurado;
    }

    public void setIdjurado(int idjurado) {
        this.idjurado = idjurado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Idjurado: " + idjurado + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email + ", Perfil: " + perfil + ", Evaluacion: " + evaluacion + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        MiembroJurado m = (MiembroJurado) o;
        return m.idjurado == this.idjurado;
    }

    public static MiembroJurado nextJurado(Scanner sc) {
        System.out.println("Ingrese los datos del jurado: ");
        sc.useDelimiter("\n");
        int idjurado = Util.nextID("MiembroJurado.txt");
        System.out.println("ingrese los nombre: ");
        String nombres = sc.next();
        System.out.println("ingrese los apellidos: ");
        String apellidos = sc.next();
        System.out.println("ingrese el email: ");
        String email = sc.next();
        System.out.println("ingrese el perfil: ");
        String perfil = sc.next();

        MiembroJurado nuevo = new MiembroJurado(idjurado, nombres, apellidos, email, perfil);

        return nuevo;
    }

    public void saveFile(String nomFile) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))) {
            pw.println(idjurado + "|" + nombre + "|" + apellido + "|" + email + "|" + perfil);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
