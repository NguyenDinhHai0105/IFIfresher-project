package com.example.fresherproject.controller;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.TrafficSigns;
import com.example.fresherproject.service.TrafficSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traffic-signs")
@CrossOrigin(origins = "*", maxAge = 3600)

public class TrafficSignsController {

    @Autowired
    TrafficSignsService trafficSignsService;

    @GetMapping("")
    public List<TrafficSigns> getAllTrafficSigns () {
        return trafficSignsService.getAllTrafficSigns();
    }

    @PostMapping("")
    public void addSigns(@RequestBody TrafficSigns trafficSigns) {
        trafficSignsService.addSigns(trafficSigns);
    }

    @PutMapping("/{id}")
    public void updateSigns(@RequestBody TrafficSigns trafficSigns, @PathVariable Long id) throws ResourceNotFoundException {
        trafficSignsService.updateSign(trafficSigns, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSigns(@PathVariable Long id) throws ResourceNotFoundException {
        trafficSignsService.deleteSign(id);
    }
}
