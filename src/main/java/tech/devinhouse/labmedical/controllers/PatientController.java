package tech.devinhouse.labmedical.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.devinhouse.labmedical.dtos.PatientPostRequest;
import tech.devinhouse.labmedical.dtos.PatientPutRequest;
import tech.devinhouse.labmedical.dtos.PatientResponse;
import tech.devinhouse.labmedical.services.PatientService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> register(
            @RequestBody @Valid PatientPostRequest request,
            UriComponentsBuilder uriBuilder) {

        PatientResponse response = service.register(request);

        URI uri = uriBuilder
                .path("/api/pacientes/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable Integer id, @RequestBody @Valid PatientPutRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
