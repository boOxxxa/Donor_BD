package com.example.Donor_BD.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Donor_BD.model.Point;
import com.example.Donor_BD.service.PointService;
import com.example.Donor_BD.repository.PointRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
@CrossOrigin
public class PointController {
    @Autowired
    private PointService pointService;
    private final PointService service;

    public PointController(PointService service) {
        this.service = service;
    }

    @GetMapping
    public List<Point> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Point getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Point> createPoint(@RequestBody Point point) {
        Point saved = pointService.save(point);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public Point update(@PathVariable Integer id, @RequestBody Point updated) {
        return service.update(id, updated);
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoint(@PathVariable Integer id) {
        if (!pointRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pointRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/
}