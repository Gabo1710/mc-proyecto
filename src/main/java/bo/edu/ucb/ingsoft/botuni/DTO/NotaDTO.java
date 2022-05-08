package bo.edu.ucb.ingsoft.botuni.DTO;

import java.sql.Date;


public class NotaDTO {

    private float evaluacionc;
    private float evaluacionf;
    private Integer nota;
    private String materia;
    public NotaDTO(float evaluacionc, float evaluacionf, Integer nota, String materia) {
        this.evaluacionc = evaluacionc;
        this.evaluacionf = evaluacionf;
        this.nota = nota;
        this.materia=materia;
    }

    public float getEvaluacionc() {
        return evaluacionc;
    }

    public void setEvaluacionc(float evaluacionc) {
        this.evaluacionc = evaluacionc;
    }

    public float getEvaluacionf() {
        return evaluacionf;
    }

    public void setEvaluacionf(float evaluacionf) {
        this.evaluacionf = evaluacionf;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }



    @Override
    public String toString() {
        return "NotaDTO{" +
                "evaluacionc=" + evaluacionc +
                ", evaluacionf=" + evaluacionf +
                ", nota=" + nota +
                ", materia='" + materia + '\'' +
                '}';
    }
}