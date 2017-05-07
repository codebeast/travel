package com.codebeast.service;

import com.codebeast.domain.Landmark;
import com.codebeast.repository.LandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andrew Jeffrey on 07/05/2017.
 */
@Service
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;

    @Autowired
    public LandmarkService(final LandmarkRepository landmarkRepository) {
        this.landmarkRepository = landmarkRepository;
    }

    public Landmark save(final Landmark landmark) {
        return landmarkRepository.save(landmark);
    }

    public Iterable<Landmark> findAll() {
        return landmarkRepository.findAll();
    }

    public List<Landmark> findByName(final String name) {
        return landmarkRepository.findByName(name);
    }
}
