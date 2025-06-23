package com.example.Donor_BD.controller;

import com.example.Donor_BD.model.Point;
import com.example.Donor_BD.service.PointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
@CrossOrigin
public class PointController {

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
    public Point create(@RequestBody Point point) {
        return service.save(point);
    }

    @PutMapping("/{id}")
    public Point update(@PathVariable Integer id, @RequestBody Point updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}