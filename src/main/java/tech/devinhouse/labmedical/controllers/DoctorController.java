package tech.devinhouse.labmedical.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.devinhouse.labmedical.dtos.DoctorRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;
import tech.devinhouse.labmedical.services.DoctorService;

import java.net.URI;

@RestController
@RequestMapping("/api/usuarios")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> register(
            @RequestBody @Valid DoctorRequest request,
            UriComponentsBuilder uriBuilder) {

        DoctorResponse response = service.register(request);

        URI uri = uriBuilder
                .path("/api/usuarios/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> update(@PathVariable Integer id, @RequestBody @Valid DoctorRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<DoctorResponse> changePassword(@PathVariable Integer id, @RequestBody String password) {
        return ResponseEntity.ok(service.changePassword(id, password));
    }
}
