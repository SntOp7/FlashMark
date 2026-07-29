package co.edu.uniquindio.flashmark.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String texto;
    private LocalDateTime fecha;
    @ManyToOne
    private Usuario emisor;
    @ManyToOne
    private Usuario receptor;
    @ManyToOne
    private Producto producto;

    public Mensaje(LocalDateTime fecha, String texto, Usuario emisor, Usuario receptor, Producto producto) {
        this.fecha = fecha;
        this.texto = texto;
        this.emisor = emisor;
        this.receptor = receptor;
        this.producto = producto;
    }
}
