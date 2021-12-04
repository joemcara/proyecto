/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.model;

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
class Premio {

    private int id;
    private int puesto;
    private String descripcion;
    private int idConcurso;
    private Concurso concurso;

    public Premio(int id, int puesto, String descripcion, int idConcurso, Concurso concurso) {
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

    public void saveFile(String nomFile) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))) {
            pw.print(id + "|" + puesto + "|" + descripcion + "|" + idConcurso);
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
}
