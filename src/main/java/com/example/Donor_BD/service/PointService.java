package com.example.Donor_BD.service;

import com.example.Donor_BD.model.Point;
import com.example.Donor_BD.repository.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    private final PointRepository repository;

    public PointService(PointRepository repository) {
        this.repository = repository;
    }

    public List<Point> getAll() {
        return repository.findAll();
    }

    public Point getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Point save(Point point) {
        return repository.save(point);
    }

    public Point update(Integer id, Point updatedPoint) {
        Point point = repository.findById(id).orElseThrow();
        point.setCity(updatedPoint.getCity());
        point.setAddress(updatedPoint.getAddress());
        point.setPhone(updatedPoint.getPhone());
        point.setFioHeader(updatedPoint.getFioHeader());
        return repository.save(point);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}