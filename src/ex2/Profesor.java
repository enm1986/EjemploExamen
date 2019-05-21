/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.ArrayList;

/**
 *
 * @author navar
 */
public class Profesor extends Persona {

    private ArrayList<Asignatura> lista_asignaturas = new ArrayList<>();

    public Profesor() {
    }

    public Profesor(String nombre, String apellido1, String apellido2, ArrayList<Asignatura> lista) {
        super(nombre, apellido1, apellido2);
        this.lista_asignaturas = lista;
    }

    public Profesor(Profesor p) {
        super(p);
        this.lista_asignaturas = p.lista_asignaturas;
    }

    public ArrayList<Asignatura> getLista_asignatura() {
        return lista_asignaturas;
    }

    public void setLista_asignatura(ArrayList<Asignatura> lista_asignaturas) {
        this.lista_asignaturas = lista_asignaturas;
    }

}
