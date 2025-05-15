package org.denzhe;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInput {
    ArrayList<JSONObject> appliances = new ArrayList<>();
    String line;
    public ReadInput(String path){
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            while (( line = in.readLine() )!=null){
                String[] datapoints = line.split(",");
                JSONObject usage = new JSONObject();
                usage.put("timeStamp",datapoints[0]);
                usage.put("Appliance",datapoints[1]);
                usage.put("power",datapoints[2]);
                usage.put("duration",datapoints[3]);
                appliances.add(usage);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<JSONObject> getAppliances() {
        return appliances;
    }
}
