package com.farmcollector.repository;

import com.farmcollector.model.PlantingInfo;
import com.farmcollector.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantingInfoRepository extends JpaRepository<PlantingInfo, Long> {
    List<PlantingInfo> findByFarmAndSeason(Farm farm, String season);
}