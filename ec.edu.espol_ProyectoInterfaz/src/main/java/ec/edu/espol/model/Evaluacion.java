
package ec.edu.espol.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author onlyw
 */
public class Evaluacion {
    private String email;
    private int idinscripcion;
    private int idcriterio;
    private double notaevaluacion;

    public Evaluacion(String email, int idinscripcion, int idcriterio, double notaevaluacion) {
        this.email = email;
        this.idinscripcion = idinscripcion;
        this.idcriterio = idcriterio;
        this.notaevaluacion = notaevaluacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(int idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public int getIdcriterio() {
        return idcriterio;
    }

    public void setIdcriterio(int idcriterio) {
        this.idcriterio = idcriterio;
    }

    public double getNotaevaluacion() {
        return notaevaluacion;
    }

    public void setNotaevaluacion(double notaevaluacion) {
        this.notaevaluacion = notaevaluacion;
    }

    @Override
    public String toString() {
        return "Email: " + email + ", CódigoInscripción: " + idinscripcion + ", CódigoCriterio: " + idcriterio + ", Puntaje: " + notaevaluacion;
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if (o==this)
            return true;
        if(this.getClass()!=o.getClass())
            return false;
        Evaluacion e=(Evaluacion)o;
        return e.idcriterio==this.idinscripcion && e.idinscripcion==this.idinscripcion;         
    }
    public static Evaluacion nextEvaluacion(Scanner sc) {
        System.out.println("Ingrese los datos de la evaluacion: ");
        sc.useDelimiter("\n");
        int idinscripcion = Util.nextID("Inscripciones.txt");
        int idcriterio = Util.nextID("Criterio.txt");        
        System.out.println("ingrese el email del jurado: ");
        String email = sc.next();
        System.out.println("ingrese la nota : ");
        double notaevaluacion = sc.nextDouble();
        Evaluacion nuevo = new Evaluacion(email, idinscripcion, idcriterio,notaevaluacion);

        return nuevo;
    }
    
    public void saveFile(String nomFile){
        try(BufferedWriter br = new BufferedWriter( new FileWriter(nomFile, true))){
            br.write(email+"|"+idinscripcion+"|"+idcriterio+"|"+notaevaluacion);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }      
}

