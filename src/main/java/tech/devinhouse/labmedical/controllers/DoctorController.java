package tech.devinhouse.labmedical.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.devinhouse.labmedical.dtos.DoctorPostRequest;
import tech.devinhouse.labmedical.dtos.DoctorPutRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;
import tech.devinhouse.labmedical.dtos.Password;
import tech.devinhouse.labmedical.entities.DoctorEntity;
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
    public ResponseEntity<DoctorEntity> register(
            @RequestBody @Valid DoctorPostRequest request,
            UriComponentsBuilder uriBuilder) {

        DoctorEntity response = service.register(request);

        URI uri = uriBuilder
                .path("/api/usuarios/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> update(@PathVariable Integer id, @RequestBody @Valid DoctorPutRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<DoctorResponse> changePassword(@PathVariable Integer id, @RequestBody @Valid Password password) {
        return ResponseEntity.ok(service.changePassword(id, password.getPassword()));
    }
}
