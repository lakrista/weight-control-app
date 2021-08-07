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
public class DailyWeight {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private LocalDate weighingDate;
    @Column
    private double morningWeight;
    @Column
    private double eveningWeight;
}
