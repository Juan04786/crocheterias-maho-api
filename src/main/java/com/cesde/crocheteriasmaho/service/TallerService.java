package com.cesde.crocheteriasmaho.service;

import com.cesde.crocheteriasmaho.exception.RecursoNoEncontradoException;
import com.cesde.crocheteriasmaho.model.Taller;
import com.cesde.crocheteriasmaho.repository.TallerRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TallerService {
    private final TallerRepository tallerRepo;

    public TallerService(TallerRepository tallerRepo) {
        this.tallerRepo = tallerRepo;
    }

    public Taller crear(Taller taller) {
        return tallerRepo.save(taller);
    }

    public Taller obtener(Long id) {
        return tallerRepo.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Taller no existe: " + id));
    }

    public List<Taller> listar(LocalDateTime desde) {
        if (desde == null) {
            return tallerRepo.findAll();
        }
        return tallerRepo.findByFechaAfterOrderByFechaAsc(desde);
    }

    public List<Taller> conCupo() {
        return tallerRepo.findConCupoDisponible();
    }
}