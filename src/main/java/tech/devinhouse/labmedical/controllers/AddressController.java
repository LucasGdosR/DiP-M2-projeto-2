package tech.devinhouse.labmedical.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labmedical.dtos.AddressRequest;
import tech.devinhouse.labmedical.entities.AddressEntity;
import tech.devinhouse.labmedical.services.AddressService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddressEntity> register(@RequestBody @Valid AddressRequest request) {
        return ResponseEntity.created(URI.create("/api/enderecos")).body(service.register(request));
    }

    @GetMapping
    public ResponseEntity<List<AddressEntity>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
