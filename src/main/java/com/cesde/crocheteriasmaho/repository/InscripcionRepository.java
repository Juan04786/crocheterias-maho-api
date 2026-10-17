package com.cesde.crocheteriasmaho.repository;

import com.cesde.crocheteriasmaho.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    boolean existsByTallerIdAndParticipanteEmail(Long tallerId, String email);

    long countByTallerId(Long tallerId);

    long countByParticipanteEmail(String email);
}
