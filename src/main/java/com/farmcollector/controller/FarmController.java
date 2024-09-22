package com.farmcollector.controller;

import com.farmcollector.model.Farm;
import com.farmcollector.model.PlantingInfo;
import com.farmcollector.model.HarvestingInfo;
import com.farmcollector.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farm")
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping("/planted")
    public ResponseEntity<PlantingInfo> addPlantingInfo(@RequestBody PlantingInfo plantingInfo) {
        PlantingInfo savedInfo = farmService.addPlantingInfo(plantingInfo);
        return ResponseEntity.ok(savedInfo);
    }

    @PostMapping("/harvested")
    public ResponseEntity<HarvestingInfo> addHarvestingInfo(@RequestBody HarvestingInfo harvestingInfo) {
        HarvestingInfo savedInfo = farmService.addHarvestingInfo(harvestingInfo);
        return ResponseEntity.ok(savedInfo);
    }

    @GetMapping("/reports/farm/{farmId}")
    public ResponseEntity<String> getFarmReport(@PathVariable Long farmId, @RequestParam String season) {
        Farm farm = farmService.getFarmById(farmId);
        List<PlantingInfo> plantingInfos = farmService.getPlantingInfo(farm, season);
        List<HarvestingInfo> harvestingInfos = farmService.getHarvestingInfo(farm, season);

        // Generate the report using a helper method
        String report = generateReport(plantingInfos, harvestingInfos);
        return ResponseEntity.ok(report);
    }

    private String generateReport(List<PlantingInfo> plantingInfos, List<HarvestingInfo> harvestingInfos) {
        StringBuilder report = new StringBuilder();

        plantingInfos.forEach(plantingInfo -> {
            Optional<HarvestingInfo> correspondingHarvest = harvestingInfos.stream()
                    .filter(h -> h.getCropType().equals(plantingInfo.getCropType()))
                    .findFirst();

            Double actualHarvest = correspondingHarvest
                    .map(HarvestingInfo::getActualHarvestedProduct)
                    .orElse(0.0);  // Default to 0.0 if no harvest info is available

            report.append("Crop: ").append(plantingInfo.getCropType())
                    .append(", Expected: ").append(plantingInfo.getExpectedProduct())
                    .append(", Actual: ").append(actualHarvest)
                    .append("\n");
        });

        return report.toString();
    }
}