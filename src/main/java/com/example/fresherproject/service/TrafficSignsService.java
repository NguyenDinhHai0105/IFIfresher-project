package com.example.fresherproject.service;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.Questions;
import com.example.fresherproject.model.TrafficSigns;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TrafficSignsService {
    List<TrafficSigns> getAllTrafficSigns();
    void addSigns(TrafficSigns trafficSigns);
    ResponseEntity<Map<String, Boolean>> updateSign (TrafficSigns trafficSigns, Long id) throws ResourceNotFoundException;
    ResponseEntity<Map<String, Boolean>> deleteSign (Long id) throws ResourceNotFoundException;
}
