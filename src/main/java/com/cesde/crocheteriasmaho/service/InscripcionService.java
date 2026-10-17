package com.cesde.crocheteriasmaho.service;

import com.cesde.crocheteriasmaho.exception.ConflictoException;
import com.cesde.crocheteriasmaho.exception.ReglaNegocioException;
import com.cesde.crocheteriasmaho.model.Inscripcion;
import com.cesde.crocheteriasmaho.model.Taller;
import com.cesde.crocheteriasmaho.repository.InscripcionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class InscripcionService {
    private final InscripcionRepository inscripcionRepo;
    private final TallerService tallerService;

    public InscripcionService(InscripcionRepository inscripcionRepo, TallerService tallerService) {
        this.inscripcionRepo = inscripcionRepo;
        this.tallerService = tallerService;
    }

    @Transactional
    public Inscripcion inscribir(Long tallerId, Inscripcion datos) {
        Taller taller = tallerService.obtener(tallerId); // lanza 404 si no existe

        // REGLA 1: el taller debe tener cupo
        if (inscripcionRepo.countByTallerId(tallerId) >= taller.getCupoMaximo()) {
            throw new ReglaNegocioException("El taller no tiene cupos disponibles");
        }

        // REGLA 2: no se puede inscribir dos veces el mismo correo
        if (inscripcionRepo.existsByTallerIdAndParticipanteEmail(tallerId, datos.getParticipanteEmail())) {
            throw new ConflictoException("El participante ya está inscrito en este taller");
        }

        // REGLA 3: el taller debe ser futuro; se calcula el descuento por fidelidad
        if (taller.getFecha().isBefore(LocalDateTime.now())) {
            throw new ReglaNegocioException("No se puede inscribir a un taller que ya pasó");
        }
        BigDecimal precio = taller.getPrecio();
        if (inscripcionRepo.countByParticipanteEmail(datos.getParticipanteEmail()) >= 2) {
            precio = precio.multiply(new BigDecimal("0.90")); // 10% de descuento
        }

        datos.setTaller(taller);
        datos.setPrecioPagado(precio);
        datos.setFechaInscripcion(LocalDateTime.now());
        return inscripcionRepo.save(datos);
    }
}
