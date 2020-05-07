package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombres", nullable = false, length = 45)
    private String nombres;
    @Column(name = "apellidos", nullable = false, length = 45)
    private String apellidos;
    @Column(name = "correo", nullable = false, length = 45)
    private String correo;
    private int score;

    // constructores
    public Cliente() {
        super();
    }

    public Cliente(int id, String nombres, String apellidos, String correo, int score) {
        this.setId(id);
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setCorreo(correo);
        this.setScore(score);
    }

    // getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}