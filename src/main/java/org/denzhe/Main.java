package org.denzhe;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Map<String,Double>> cons = new ConsumptionTrend().getConsumption();
        for (Map<String,Double> con : cons){
            System.out.println(con);
        }
    }
}