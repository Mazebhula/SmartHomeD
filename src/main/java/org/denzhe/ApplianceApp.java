package org.denzhe;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApplianceApp extends Application {

    @FXML
    private TableView<Appliance> table;
    
    @FXML
    private TableColumn<Appliance, String> nameColumn;
    
    @FXML
    private TableColumn<Appliance, Double> consumptionColumn;

    public static class Appliance {
        private final String name;
        private final double consumption;

        public Appliance(String name, double consumption) {
            this.name = name;
            this.consumption = consumption;
        }

        public String getName() {
            return name;
        }

        public double getConsumption() {
            return consumption;
        }
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/denzhe/main.fxml"));
        loader.setController(this);
        Scene scene = new Scene(loader.load());
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        consumptionColumn.setCellValueFactory(new PropertyValueFactory<>("consumption"));
        
        refreshData();
        
        primaryStage.setTitle("Smart Home Engy Monitor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void refreshData() {
        table.getItems().clear();
        ConsumptionTrend trend = new ConsumptionTrend();
        for (Map<String, Double> consumption : trend.getConsumption()) {
            for (Map.Entry<String, Double> entry : consumption.entrySet()) {
                table.getItems().add(new Appliance(entry.getKey(), entry.getValue()));
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}