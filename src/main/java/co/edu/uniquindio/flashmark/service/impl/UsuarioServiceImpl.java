package co.edu.uniquindio.flashmark.service.impl;

import co.edu.uniquindio.flashmark.exception.CorreoDuplicadoException;
import co.edu.uniquindio.flashmark.exception.UsuarioNoEncontradoException;
import co.edu.uniquindio.flashmark.model.Usuario;
import co.edu.uniquindio.flashmark.repository.UsuarioRepository;
import co.edu.uniquindio.flashmark.service.interfaces.UsuarioService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
       if(usuarioRepository.existsByCorreo(usuario.getCorreo()) || usuarioRepository.existsById(usuario.getId())){
           throw new CorreoDuplicadoException("Ya existe un usuario con el mismo correo o ID");
       }
       usuario.setFechaRegistro(LocalDate.now());

       return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Usuario otro = usuarioRepository.findByCorreo(usuario.getCorreo());

        if(otro != null && !otro.getId().equals(usuario.getId())){
            throw new CorreoDuplicadoException("Ya existe un usuario con el mismo correo");
        }
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setCorreo(usuario.getCorreo());
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setCiudad(usuario.getCiudad());
        usuarioExistente.setFotoPerfil(usuario.getFotoPerfil());

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void eliminarUsuario(String id) {
        if(!usuarioRepository.existsById(id)){
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);

    }

    @Override
    public Usuario buscarUsuario(String id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado"));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
