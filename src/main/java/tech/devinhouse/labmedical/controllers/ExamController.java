package tech.devinhouse.labmedical.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.devinhouse.labmedical.dtos.ExamRequest;
import tech.devinhouse.labmedical.dtos.ExamResponse;
import tech.devinhouse.labmedical.services.ExamService;

import java.net.URI;

@RestController
@RequestMapping("/api/exames")
public class ExamController {

    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExamResponse> register(
            @RequestBody @Valid ExamRequest request,
            UriComponentsBuilder uriBuilder) {

        ExamResponse response = service.register(request);

        URI uri = uriBuilder
                .path("/api/exames/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamResponse> update(@PathVariable Integer id, @RequestBody @Valid ExamRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
