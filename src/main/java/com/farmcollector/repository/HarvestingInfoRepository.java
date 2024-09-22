package com.farmcollector.repository;

import com.farmcollector.model.HarvestingInfo;
import com.farmcollector.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestingInfoRepository extends JpaRepository<HarvestingInfo, Long> {
    List<HarvestingInfo> findByFarmAndSeason(Farm farm, String season);
}