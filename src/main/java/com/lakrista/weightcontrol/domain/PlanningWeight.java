package com.lakrista.weightcontrol.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@Entity
public class PlanningWeight {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private double currentWeight;
    @Column
    private double desiredWeight;
    @Column
    private LocalDate calculationDate;
    @Column
    private LocalDate dateTo;
    @Column
    private double calculatedDailyWeight;
}
