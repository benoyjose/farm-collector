package com.farmcollector.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude = "farm")
@ToString(exclude = "farm")
public class HarvestingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropType;
    private Double actualHarvestedProduct;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;

    private String season;
}