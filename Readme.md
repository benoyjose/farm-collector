# Farm Collector API

## Overview

The Farm Collector API allows users to manage farming data, including planting and harvesting information. This document provides details on how to interact with the API.

## API Endpoints

### 1. Add Planting Information

**POST** `http://localhost:8080/api/farm/planted`

#### Request Body

The request body should be in JSON format. Below is an example of how to structure the JSON for adding planting information:

```json
{
  "cropType": "Tomato",
  "plantingArea": 100.0,
  "expectedProduct": 200.0,
  "farm": {
    "id": 1
  },
  "season": "Harvest"
}
```

### 2. Add Harvested Information

**POST** `http://localhost:8080/api/farm/harvested`

#### Request Body

The request body should be in JSON format. Below is an example of how to structure the JSON for adding harvested information:

```json
{
    "id": 3,
    "cropType": "Tomato",
    "actualHarvestedProduct": 190.0,
    "farm": {
        "id": 1,
        "name": null
    },
    "season": "Harvest"
}
```

### 3. Get Report

**GET** `http://localhost:8080/api/farm/reports/farm/{farmId}?season={season}`

#### Query Parameters

- **farmId**: The ID of the farm (e.g., `1`).
- **season**: The season for which you want the report (e.g., `Harvest`).

#### Example Request

```plaintext
http://localhost:8080/api/farm/reports/farm/1?season=Harvest
```
### OUTPUT
```text
Crop: Tomato, Expected: 200.0, Actual: 190.0
Crop: Potatoes, Expected: 80.0, Actual: 85.0
Crop: Tomato, Expected: 200.0, Actual: 190.0
```