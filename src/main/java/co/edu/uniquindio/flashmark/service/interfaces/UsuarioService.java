package co.edu.uniquindio.flashmark.service.interfaces;

import co.edu.uniquindio.flashmark.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarUsuario(String id);
    Usuario buscarUsuario(String id);
    List<Usuario> listarUsuarios();
    Usuario iniciarSesion(String correo, String contrasenia);
}
