package co.edu.uniquindio.flashmark.service.interfaces;

import co.edu.uniquindio.flashmark.model.Categoria;
import co.edu.uniquindio.flashmark.model.Producto;
import co.edu.uniquindio.flashmark.model.Usuario;

import java.util.List;

public interface ProductoService {
    Producto publicarProducto(Producto producto);
    Producto actualizarProducto(Producto producto);
    void eliminarProducto(String id);
    Producto buscarProducto(String id);
    List<Producto> listarProductos();
    List<Producto> listarProductosPorCategoria(Categoria categoria);
    List<Producto> listarProductosPorVendedor(Usuario vendedor);
}
