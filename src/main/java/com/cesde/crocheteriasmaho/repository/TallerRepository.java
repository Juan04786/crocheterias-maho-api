package com.cesde.crocheteriasmaho.repository;

import com.cesde.crocheteriasmaho.model.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface TallerRepository extends JpaRepository<Taller, Long> {

    List<Taller> findByFechaAfterOrderByFechaAsc(LocalDateTime desde);

    @Query("SELECT t FROM Taller t WHERE t.cupoMaximo > " +
           "(SELECT COUNT(i) FROM Inscripcion i WHERE i.taller = t)")
    List<Taller> findConCupoDisponible();
}
