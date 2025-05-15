package org.denzhe;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumptionTrend {
    private final ArrayList<Map<String, Double>> consumption = new ArrayList<>();

    public ArrayList<Map<String, Double>> getConsumption() {
        return new ArrayList<>(consumption);
    }

    public ConsumptionTrend() {
        List<JSONObject> appliances = new ReadInput("src/main/java/org/denzhe/sample/data/data.csv")
                .getAppliances();

        for (JSONObject appliance : appliances) {
            Map<String, Double> values = new HashMap<>();
            String name = appliance.getString("Appliance");
            
            double value = Integer.parseInt(appliance.getString("power")) * appliance.getFloat("duration");
            values.put(name, value);
            consumption.add(values);
        }
    }

    private Map<String, Double> combine(Map<String, Double> values) {
        Map<String, Double> result = new HashMap<>();
        for (Map.Entry<String, Double> entry : values.entrySet()) {
            String name = entry.getKey();
            Double value = entry.getValue();
            if (name != null && value != null) {
                result.merge(name, value, Double::sum);
            }
        }
        return result;
    }
}
