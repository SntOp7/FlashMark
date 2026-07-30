package co.edu.uniquindio.flashmark.service.impl;

import co.edu.uniquindio.flashmark.exception.CorreoDuplicadoException;
import co.edu.uniquindio.flashmark.exception.ProductoDuplicadoException;
import co.edu.uniquindio.flashmark.exception.ProductoNoEncontradoException;
import co.edu.uniquindio.flashmark.exception.UsuarioNoEncontradoException;
import co.edu.uniquindio.flashmark.model.Categoria;
import co.edu.uniquindio.flashmark.model.Producto;
import co.edu.uniquindio.flashmark.model.Usuario;
import co.edu.uniquindio.flashmark.repository.ProductoRepository;
import co.edu.uniquindio.flashmark.service.interfaces.ProductoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    @Override
    public Producto publicarProducto(Producto producto) {
        if(productoRepository.existsById(producto.getId())){
            throw new ProductoDuplicadoException("Ya existe un producto registrado con el mismo identificador");
        }
        producto.setFechaPublicacion(LocalDate.now());
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        Producto productoExistente = productoRepository.findById(producto.getId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if(productoRepository.existsById(producto.getId())){
            throw new ProductoDuplicadoException("Ya existe un producto registrado con el mismo identificador");
        }
        productoExistente.setFechaPublicacion(LocalDate.now());
        productoExistente.setImagen(producto.getImagen());
        productoExistente.setCategoria(productoExistente.getCategoria());
        productoExistente.setPrecio(producto.getPrecio());

        return productoRepository.save(productoExistente);
    }

    @Override
    public void eliminarProducto(String id) {
        if(!productoRepository.existsById(id)){
            throw new ProductoNoEncontradoException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public Producto buscarProducto(String id) {
        return productoRepository.findById(id).orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado"));
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> listarProductosPorCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Producto> listarProductosPorVendedor(Usuario vendedor) {
        return productoRepository.findByVendedor(vendedor);
    }
}
