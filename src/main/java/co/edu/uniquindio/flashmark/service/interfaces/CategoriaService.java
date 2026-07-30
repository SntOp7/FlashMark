package co.edu.uniquindio.flashmark.service.interfaces;

import co.edu.uniquindio.flashmark.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria guardarCategoria(Categoria categoria);
    Categoria buscarCategoria(String id);
    List<Categoria> listarCategorias();
}
