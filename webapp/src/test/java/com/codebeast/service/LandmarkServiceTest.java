package com.codebeast.service;

import com.codebeast.Application;
import com.codebeast.domain.Landmark;
import com.sun.org.apache.bcel.internal.generic.LAND;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Andrew Jeffrey on 07/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LandmarkServiceTest {

    @Autowired
    private LandmarkService landmarkService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Landmark.class);
        esTemplate.createIndex(Landmark.class);
        esTemplate.putMapping(Landmark.class);
        esTemplate.refresh(Landmark.class);
    }

    @Test
    public void save() throws Exception {

        final Landmark landmark = Landmark.builder()
                .id("hotel")
                .name("hotel")
                .description("I am a hotel")
                .location(new GeoPoint(1.1,2.2))
                .build();

        Landmark savedLandmark = landmarkService.save(landmark);

        assertNotNull(savedLandmark.getId());
        assertEquals(savedLandmark.getName(), landmark.getName());
        assertEquals(savedLandmark.getDescription(), landmark.getDescription());
        assertEquals(savedLandmark.getLocation(), landmark.getLocation());
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findByName() throws Exception {
    }

}