package com.codebeast.repository;

import com.codebeast.domain.Landmark;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by Andrew Jeffrey on 07/05/2017.
 */
public interface LandmarkRepository extends  ElasticsearchRepository<Landmark, String> {

    List<Landmark> findByName(String name);

}
