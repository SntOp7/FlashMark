package co.edu.uniquindio.flashmark.repository;

import co.edu.uniquindio.flashmark.model.Mensaje;
import co.edu.uniquindio.flashmark.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends  JpaRepository<Mensaje, String> {
    List<Mensaje> findByProducto(Producto producto);
}
