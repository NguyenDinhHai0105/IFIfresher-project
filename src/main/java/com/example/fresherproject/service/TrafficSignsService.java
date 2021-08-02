package com.example.fresherproject.service;

import com.example.fresherproject.model.TrafficSigns;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrafficSignsService {
    List<TrafficSigns> getAllTrafficSigns();
    void addSigns(TrafficSigns trafficSigns);
}
