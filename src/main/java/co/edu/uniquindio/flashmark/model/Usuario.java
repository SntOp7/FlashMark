package co.edu.uniquindio.flashmark.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private int telefono;
    private String ciudad;
    private String fotoPerfil;
    private LocalDate fechaRegistro;

    public Usuario(String ciudad, String nombre, String apellido, String correo, String password, int telefono, String fotoPerfil, LocalDate fechaRegistro) {
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.telefono = telefono;
        this.fotoPerfil = fotoPerfil;
        this.fechaRegistro = fechaRegistro;
    }
}
