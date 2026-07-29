package co.edu.uniquindio.flashmark.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String titulo;
    private String descripcion;
    private Double precio;
    @Enumerated(EnumType.STRING)
    private EstadoProducto estado;
    private LocalDate fechaPublicacion;
    private String imagen;

    @ManyToOne
    private Usuario vendedor;

    @ManyToOne
    private Categoria categoria;

    public Producto(String titulo, String descripcion, double precio, EstadoProducto estado, LocalDate fechaPublicacion, String imagen, Usuario vendedor, Categoria categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
        this.imagen = imagen;
        this.vendedor = vendedor;
        this.categoria = categoria;
    }
}
