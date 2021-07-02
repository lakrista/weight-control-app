package com.lakrista.weightcontrol.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import static java.lang.Double.parseDouble;
import static java.time.LocalDate.now;

public class PlanningController {

    @FXML
    private Button calculateButton;

    @FXML
    private TextField currentWeight;

    @FXML
    private TextField desiredWeight;

    @FXML
    private DatePicker dateTo;

    @FXML
    private Label calculatedData;

    @FXML
    private void calculate(ActionEvent event) {
        final LocalDate endDate = dateTo.getValue();
        final Duration duration = Duration.between(now().atStartOfDay(), endDate.atStartOfDay());
        final long diffDays = Math.abs(duration.toDays());

        final double difWeight = parseDouble(currentWeight.getText()) - parseDouble(desiredWeight.getText());
        final double lostWeightDay = difWeight * 1000 / diffDays;

        calculatedData.setText("Count of days: " + diffDays + "\n" + "Lost weight per day: " + lostWeightDay);
    }
}
