package com.farmcollector;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.farmcollector.model.PlantingInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FarmCollectorApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddPlantingInfo() throws Exception {
        PlantingInfo plantingInfo = new PlantingInfo();
        plantingInfo.setCropType("Corn");
        plantingInfo.setPlantingArea(100.0);
        plantingInfo.setExpectedProduct(200.0);

        mockMvc.perform(post("/api/farm/planted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(plantingInfo)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFarmReport() throws Exception {
        mockMvc.perform(get("/api/farm/reports/farm/1?season=Harvest"))
                .andExpect(status().isOk())
                .andExpect(content().string("Crop: Tomato, Expected: 200.0, Actual: 190.0\n" +
                        "Crop: Potatoes, Expected: 80.0, Actual: 85.0\n"));
    }
}