package com.codebeast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

/**
 * Created by Andrew Jeffrey on 07/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "travel", type = "landmark")
public class Landmark {

    @Id
    private String id;
    private GeoPoint location;
    private String name;
    private String description;
}
