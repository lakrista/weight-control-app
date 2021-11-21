package com.lakrista.weightcontrol.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DailyWeightData {

    private String weighingDate;
    private String morningWeight;
}
