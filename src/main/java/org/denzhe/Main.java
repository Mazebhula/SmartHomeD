package org.denzhe;

import org.json.JSONObject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<JSONObject> appliances = new ReadInput("src/main/java/org/denzhe/sample/data/data.csv")
                .getAppliances();
        for (JSONObject appliance : appliances) {
            System.out.println(appliance);
        }
    }
}