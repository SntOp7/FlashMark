package co.edu.uniquindio.flashmark.service.interfaces;

import co.edu.uniquindio.flashmark.model.Mensaje;

import java.util.List;

public interface MensajeService {
    Mensaje enviarMensaje(Mensaje mensaje);
    List<Mensaje> listarMensajes();
}
