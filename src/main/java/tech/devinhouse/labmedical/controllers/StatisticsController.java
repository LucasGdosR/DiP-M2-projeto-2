package tech.devinhouse.labmedical.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labmedical.dtos.Statistics;
import tech.devinhouse.labmedical.services.StatisticsService;

@RestController
@RequestMapping("/api/estatisticas")
public class StatisticsController {

    private final StatisticsService service;

    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Statistics> getStatistics() {
        return ResponseEntity.ok(service.getStatistics());
    }
}
