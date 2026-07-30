package co.edu.uniquindio.flashmark.service.impl;

import co.edu.uniquindio.flashmark.exception.CasillasVaciasException;
import co.edu.uniquindio.flashmark.exception.CategoriaNoEncontradaException;
import co.edu.uniquindio.flashmark.model.Categoria;
import co.edu.uniquindio.flashmark.repository.CategoriaRepository;
import co.edu.uniquindio.flashmark.service.interfaces.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        if(categoria.getNombre()==null){
            throw new CasillasVaciasException("Categoria incompleta para guardar");
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarCategoria(String id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new CategoriaNoEncontradaException("Categoria no encontrada"));
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
}
