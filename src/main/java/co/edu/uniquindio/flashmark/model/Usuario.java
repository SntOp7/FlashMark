package co.edu.uniquindio.flashmark.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(unique = true, nullable = false)
    private String correo;
    @Column(nullable = false)
    private String password;
    private String telefono;
    private String ciudad;
    private String fotoPerfil;
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "vendedor")
    private List<Producto> productos;

    @OneToMany(mappedBy = "emisor")
    private List<Mensaje> mensajesEnviados;

    @OneToMany(mappedBy = "receptor")
    private List<Mensaje> mensajesRecibidos;


    public Usuario(String ciudad, String nombre, String apellido, String correo, String password, String telefono, String fotoPerfil, LocalDate fechaRegistro) {
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
