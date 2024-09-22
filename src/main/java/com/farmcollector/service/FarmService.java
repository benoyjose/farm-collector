package com.farmcollector.service;

import com.farmcollector.model.Farm;
import com.farmcollector.model.PlantingInfo;
import com.farmcollector.model.HarvestingInfo;
import com.farmcollector.repository.FarmRepository;
import com.farmcollector.repository.PlantingInfoRepository;
import com.farmcollector.repository.HarvestingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private PlantingInfoRepository plantingInfoRepository;

    @Autowired
    private HarvestingInfoRepository harvestingInfoRepository;

    public Farm getFarmById(Long farmId) {
        return farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found with ID: " + farmId));
    }

    public PlantingInfo addPlantingInfo(PlantingInfo plantingInfo) {
        return plantingInfoRepository.save(plantingInfo);
    }

    public HarvestingInfo addHarvestingInfo(HarvestingInfo harvestingInfo) {
        return harvestingInfoRepository.save(harvestingInfo);
    }

    public List<PlantingInfo> getPlantingInfo(Farm farm, String season) {
        return plantingInfoRepository.findByFarmAndSeason(farm, season);
    }

    public List<HarvestingInfo> getHarvestingInfo(Farm farm, String season) {
        return harvestingInfoRepository.findByFarmAndSeason(farm, season);
    }
}