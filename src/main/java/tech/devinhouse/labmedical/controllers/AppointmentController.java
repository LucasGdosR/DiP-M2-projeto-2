package tech.devinhouse.labmedical.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.devinhouse.labmedical.dtos.AppointmentRequest;
import tech.devinhouse.labmedical.dtos.AppointmentResponse;
import tech.devinhouse.labmedical.services.AppointmentService;

import java.net.URI;

@RestController
@RequestMapping("/api/consultas")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> register(
            @RequestBody @Valid AppointmentRequest request,
            UriComponentsBuilder uriBuilder) {

        AppointmentResponse response = service.register(request);

        URI uri = uriBuilder
                .path("/api/consultas/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> update(@PathVariable Integer id, @RequestBody @Valid AppointmentRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
