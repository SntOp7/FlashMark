package co.edu.uniquindio.flashmark.service.impl;

import co.edu.uniquindio.flashmark.exception.CasillasVaciasException;
import co.edu.uniquindio.flashmark.model.Mensaje;
import co.edu.uniquindio.flashmark.repository.MensajeRepository;
import co.edu.uniquindio.flashmark.service.interfaces.MensajeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServiceImpl implements MensajeService {
    private final MensajeRepository mensajeRepository;

    public MensajeServiceImpl(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Override
    public Mensaje enviarMensaje(Mensaje mensaje) {
        if(mensaje.getTexto() == null){
            throw new CasillasVaciasException("Mensaje vacio");
        }
        return mensajeRepository.save(mensaje);
    }

    @Override
    public List<Mensaje> listarMensajes() {
        return mensajeRepository.findAll();
    }
}
