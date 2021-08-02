package com.example.fresherproject.service.impl;

import com.example.fresherproject.model.TrafficSigns;
import com.example.fresherproject.repository.TrafficSignsRepository;
import com.example.fresherproject.service.TrafficSignsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
