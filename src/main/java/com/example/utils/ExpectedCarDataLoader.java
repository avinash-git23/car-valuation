package com.example.utils;

import com.example.model.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpectedCarDataLoader {
    public static Map<String, Car> loadExpectedData(String csvPath) throws IOException {
        Map<String, Car> expectedCars = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(csvPath));
        // Skip header row (line 0)
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length >= 3) {
                String reg = parts[0].trim();
                String model = parts[1].trim();
                int year = Integer.parseInt(parts[2].trim());
                // Normalize registration (remove spaces) for key consistency
                expectedCars.put(reg.replaceAll("\\s", ""), new Car(reg, model, year));
            }
        }
        return expectedCars;
    }
}
