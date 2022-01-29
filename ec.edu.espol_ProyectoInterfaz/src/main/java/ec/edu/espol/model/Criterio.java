/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yoser
 */
public class Criterio {

    private int id;
    private int puesto;
    private String descripcion;
    private int idConcurso;
    private Concurso concurso;

    public Criterio(int id, int puesto, String descripcion, int idConcurso) {
        this.id = id;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.idConcurso = idConcurso;
        this.concurso = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    @Override
    public String toString() {
        return "Criterio{" + "id=" + id + ", puesto=" + puesto + ", descripcion=" + descripcion + ", idConcurso=" + idConcurso + ", concurso=" + concurso + '}';
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
        Criterio e = (Criterio) o;
        return e.getId() == this.getId();
    }

    public void saveFile(String nomFile) {
        try ( BufferedWriter bf = new BufferedWriter(new FileWriter (nomFile,true))) {
            bf.write(id + "|" + puesto + "|" + descripcion + "|" + idConcurso + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Concurso> readFile(String nomFile) {
        ArrayList<Concurso> concursos = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(nomFile))) {
            String linea;
            while ((linea = br.readLine())!= null) {
                //1|mascotas disfrazadas|2021-12-23|2022-01-03|2022-02-13|disfraces|23.0
                String[] datos = linea.split("\\|");
                Concurso nuevo = new Concurso(Integer.parseInt(datos[0]), datos[1], LocalDate.parse(datos[2]), LocalDate.parse(datos[3]), LocalDate.parse(datos[4]), datos[5], Double.parseDouble(datos[6]));
                concursos.add(nuevo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Lectura de archivo concurso ERROR");
        }
        return concursos;
    }

    public static int idConcurso(String nombreConcurso) {
        ArrayList<Concurso> lista = Premio.readFile("Concurso.txt");
        for (Concurso unico : lista) {
            if (unico.getNombre().equalsIgnoreCase(nombreConcurso)) {
                return unico.getId();
            }
        }
        return 0;

    }

    public static Criterio nextCriterio(Scanner sc) {
        sc.useDelimiter("\n");
        System.out.println("ingrese datos del criterio");
        int id = Util.nextID("Criterios.txt");
        System.out.println("Ingrese al puesto que pertenece este criterio");
        int puesto = sc.nextInt();
        System.out.println("Ingrese la descripcion del Criterio ");
        String descripcion = sc.next();
        System.out.println("Ingrese el nombre del concurso ");
        String nombre = sc.next();
        int idConcurso = Criterio.idConcurso(nombre);

        Criterio nuevo = new Criterio(id, puesto, descripcion, idConcurso);
        return nuevo;
    }
}
