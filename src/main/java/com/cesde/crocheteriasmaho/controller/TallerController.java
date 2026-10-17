package com.cesde.crocheteriasmaho.controller;

import com.cesde.crocheteriasmaho.model.Inscripcion;
import com.cesde.crocheteriasmaho.model.Taller;
import com.cesde.crocheteriasmaho.service.InscripcionService;
import com.cesde.crocheteriasmaho.service.TallerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/talleres")
public class TallerController {
    private final TallerService tallerService;
    private final InscripcionService inscripcionService;

    public TallerController(TallerService tallerService, InscripcionService inscripcionService) {
        this.tallerService = tallerService;
        this.inscripcionService = inscripcionService;
    }

    // @RequestBody
    @PostMapping
    public ResponseEntity<Taller> crear(@RequestBody Taller taller) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tallerService.crear(taller));
    }

    // @RequestParam
    @GetMapping
    public ResponseEntity<List<Taller>> listar(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde) {
        return ResponseEntity.ok(tallerService.listar(desde));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Taller>> disponibles() {
        return ResponseEntity.ok(tallerService.conCupo());
    }

    // @PathVariable
    @GetMapping("/{id}")
    public ResponseEntity<Taller> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(tallerService.obtener(id));
    }

    // @PathVariable + @RequestBody
    @PostMapping("/{tallerId}/inscripciones")
    public ResponseEntity<Inscripcion> inscribir(@PathVariable Long tallerId,
                                                 @RequestBody Inscripcion inscripcion) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inscripcionService.inscribir(tallerId, inscripcion));
    }
}
