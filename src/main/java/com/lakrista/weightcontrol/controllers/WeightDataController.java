package com.lakrista.weightcontrol.controllers;

import com.lakrista.weightcontrol.database.DailyWeightDataManager;
import com.lakrista.weightcontrol.domain.DailyWeight;
import com.lakrista.weightcontrol.dto.DailyWeightData;
import com.lakrista.weightcontrol.mappers.DailyWeightMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

public class WeightDataController {
    @FXML
    private DatePicker weighingDate;
    @FXML
    private TextField morningWeight;
    @FXML
    private Button addWeightButton;
    @FXML
    private TableView<DailyWeightData> dataTable;

    private final DailyWeightDataManager dailyWeightDataManager = new DailyWeightDataManager();

    public void initialize() {
        final List<DailyWeight> dailyWeightList = dailyWeightDataManager.getAll();

        final ObservableList<DailyWeightData> data = FXCollections.observableArrayList(dailyWeightList.stream().map(DailyWeightMapper.INSTANCE::dailyWeightToDailyWeightData).collect(Collectors.toList()));
        dataTable.setItems(data);
    }

    @FXML
    public void addWeight(ActionEvent event) {
        final DailyWeight dailyWeight = DailyWeight.builder()
                .weighingDate(weighingDate.getValue())
                .morningWeight(morningWeight.getText().isBlank() ? 0 : parseDouble(morningWeight.getText()))
                .build();

        dailyWeightDataManager.create(dailyWeight);

       /* if (dataTable.getItems().isEmpty()) { //TODO: add weight to table
            final ObservableList<DailyWeight> list = FXCollections.observableArrayList();
            list.add()
            dataTable.setItems();
        } else {
            dataTable.getItems().add(dailyWeight);
        }
        dataTable.setItems();*/
    }
}
