package co.edu.uniquindio.flashmark.repository;

import co.edu.uniquindio.flashmark.model.Mensaje;
import co.edu.uniquindio.flashmark.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends  JpaRepository<Mensaje, String> {
    List<Mensaje> findByProducto(Producto producto);
}
