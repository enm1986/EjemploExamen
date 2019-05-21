/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author navar
 */
public class Asignatura extends Curso {

    private String asignatura;

    public Asignatura() {
    }

    public Asignatura(String asignatura, String curso, String titulo) {
        super(curso, titulo);
        this.asignatura = asignatura;
    }

    public Asignatura(Asignatura a) {
        super(a);
        this.asignatura = a.asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    
    
}
