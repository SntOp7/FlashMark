package co.edu.uniquindio.flashmark.controller;

import co.edu.uniquindio.flashmark.model.Usuario;
import co.edu.uniquindio.flashmark.service.interfaces.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(){
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.registrarUsuario(usuario);
        return "redirect:/usuarios/login";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(){
        return "login";
    }

    @PostMapping
    public String iniciarSesion(@RequestParam String correo, @RequestParam String password, HttpSession session){
        Usuario usuario = usuarioService.iniciarSesion(correo, password);

        session.setAttribute("usuario", usuario);
        return "redirect:/inicio";
    }
}
