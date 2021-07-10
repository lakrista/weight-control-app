package com.lakrista.weightcontrol.controllers;

import com.lakrista.weightcontrol.database.PlanningWeightDataManager;
import com.lakrista.weightcontrol.domain.PlanningWeight;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.Duration;
import java.time.LocalDate;

import static java.lang.Double.parseDouble;
import static java.lang.Math.round;
import static java.lang.String.format;
import static java.time.LocalDate.now;

public class PlanningController {
    @FXML
    public Button saveButton;
    @FXML
    private TextField currentWeight;
    @FXML
    private TextField desiredWeight;
    @FXML
    private DatePicker dateTo;
    @FXML
    public Button calculateButton;
    @FXML
    private Label calculatedData;

    private long  calculatedDailyWeight;

    private final PlanningWeightDataManager planningWeightDataManager = new PlanningWeightDataManager();

    @FXML
    private void calculate(final ActionEvent event) {
        final LocalDate endDate = dateTo.getValue();
        final Duration duration = Duration.between(now().atStartOfDay(), endDate.atStartOfDay());
        final long diffDays = Math.abs(duration.toDays());

        final double difWeight = parseDouble(currentWeight.getText()) - parseDouble(desiredWeight.getText());
        final double lostWeightDay = difWeight * 1000 / diffDays;

        calculatedDailyWeight = round(lostWeightDay);
        calculatedData.setText(getCalculatedDataText(diffDays, calculatedDailyWeight));
        saveButton.setVisible(true);
    }

    @FXML
    private void save(final ActionEvent event) {
        final PlanningWeight planningWeight = PlanningWeight.builder()
                .currentWeight(parseDouble(currentWeight.getText()))
                .desiredWeight(parseDouble(desiredWeight.getText()))
                .calculationDate(now())
                .dateTo(dateTo.getValue())
                .calculatedDailyWeight(calculatedDailyWeight)
                .build();
        planningWeightDataManager.create(planningWeight);

        System.out.println(planningWeightDataManager.get(1L));
    }

    private String getCalculatedDataText(final long diffDays, final long lostWeightDay) {
        return format("Count of days: %d\nLost weight per day: %d", diffDays, lostWeightDay);
    }
}
