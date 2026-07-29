package co.edu.uniquindio.flashmark.repository;

import co.edu.uniquindio.flashmark.model.Categoria;
import co.edu.uniquindio.flashmark.model.Producto;
import co.edu.uniquindio.flashmark.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, String> {
    List<Producto> findByVendedor(Usuario vendedor);
    List<Producto> findByCategoria(Categoria categoria);
}
