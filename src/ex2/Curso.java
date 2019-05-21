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
public class Curso {
    private String curso;
    private String titulo;

    public Curso() {
    }

    public Curso(String curso, String titulo) {
        this.curso = curso;
        this.titulo = titulo;
    }
    
    public Curso(Curso c) {
        this.curso = c.curso;
        this.titulo = c.titulo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
                
}
