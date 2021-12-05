/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.model;

import ec.edu.espol.proyecto.uil.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yoser
 */
public class Premio {

    private int id;
    private int puesto;
    private String descripcion;
    private int idConcurso;
    private Concurso concurso;

    public Premio(int id, int puesto, String descripcion, int idConcurso) {
        this.id = id;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.idConcurso = idConcurso;
        this.concurso = null;
    }

    //getters
    public int getId() {
        return id;
    }

    public int getPuesto() {
        return puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    @Override
    public String toString() {
        return "Premio{" + "id=" + id + ", puesto=" + puesto + ", descripcion=" + descripcion + ", idConcurso=" + idConcurso + '}';
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
        Premio e = (Premio) o;
        return e.getId() == this.getId();
    }

    public void saveFile(String nomFile) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))) {
            pw.print(id + "|" + puesto + "|" + descripcion + "|" + idConcurso + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Concurso> readFile(String nomFile) {
        ArrayList<Concurso> concursos = new ArrayList<>();
        try ( Scanner sc = new Scanner(new File(nomFile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                //1|mascotas disfrazadas|2021-12-23|2022-01-03|2022-02-13|disfraces|23.0
                String[] datos = linea.split("\\|");
                Concurso nuevo = new Concurso(Integer.parseInt(datos[0]), datos[1], LocalDate.parse(datos[2]), LocalDate.parse(datos[3]), LocalDate.parse(datos[4]), datos[5], Double.parseDouble(datos[6]));
                concursos.add(nuevo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return concursos;
    }

    public static int idDueño(String nombreConcurso) {
        ArrayList<Concurso> lista = Premio.readFile("Concurso.txt");
        for (Concurso unico : lista) {
            if (unico.getNombre().equalsIgnoreCase(nombreConcurso)) {
                return unico.getId();
            }
        }
        return 0;

    }

    public static Premio nextPremio(Scanner sc) {
        sc.useDelimiter("\n");
        System.out.println("ingrese datos de un concurso");
        int id = Util.nextID("Premio.txt");
        System.out.println("Ingrese al puesto que pertenece este premio");
        int puesto = sc.nextInt();
        System.out.println("Ingrese la descripcion del Premio ");
        String descripcion = sc.next();
        System.out.println("Ingrese el nombre del concurso ");
        String nombre = sc.next();
        int idConcurso = Premio.idDueño(nombre);

        Premio nuevo = new Premio(id, puesto, descripcion, idConcurso);
        return nuevo;
    }

    public static int idMascota(String nombremascota) {
        ArrayList<Concurso> lista = Premio.readFile("Mascota.txt");
        for (Concurso unico : lista) {
            if (unico.getNombre().equalsIgnoreCase(nombremascota)) {
                return unico.getId();
            }
        }
        return 0;

    }
}
