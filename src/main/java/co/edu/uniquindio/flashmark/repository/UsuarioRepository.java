package co.edu.uniquindio.flashmark.repository;

import co.edu.uniquindio.flashmark.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByCorreo(String correo);
    boolean existsByCorreo(String correo);
}
