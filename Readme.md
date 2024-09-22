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