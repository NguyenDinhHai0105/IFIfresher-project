package com.example.fresherproject.service.impl;

import com.example.fresherproject.exception.ResourceNotFoundException;
import com.example.fresherproject.model.TrafficSigns;
import com.example.fresherproject.repository.TrafficSignsRepository;
import com.example.fresherproject.service.TrafficSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrafficSignsServiceImpl implements TrafficSignsService {

    @Autowired
    TrafficSignsRepository trafficSignsRepository;

    @Override
    public List<TrafficSigns> getAllTrafficSigns() {
        return trafficSignsRepository.findAll();
    }

    @Override
    public void addSigns(TrafficSigns trafficSigns) {
        trafficSignsRepository.save(trafficSigns);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> updateSign(TrafficSigns trafficSignDetail, Long id) throws ResourceNotFoundException {
        TrafficSigns trafficSign = trafficSignsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("traffic signs not found with id: " + id));
        trafficSign.setCode(trafficSignDetail.getCode());
        trafficSign.setDescription(trafficSignDetail.getDescription());
        trafficSign.setName(trafficSignDetail.getName());
        trafficSign.setImg(trafficSignDetail.getImg());
        trafficSign.setType(trafficSignDetail.getType());
        trafficSignsRepository.save(trafficSign);
        Map<String, Boolean> response = new HashMap<>();
        response.put("signs updated", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteSign(Long id) throws ResourceNotFoundException {
        TrafficSigns trafficSigns = trafficSignsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("traffic sign not found with id: " + id));
        trafficSignsRepository.delete(trafficSigns);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
