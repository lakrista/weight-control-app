package com.lakrista.weightcontrol.mappers;

import com.lakrista.weightcontrol.domain.DailyWeight;
import com.lakrista.weightcontrol.dto.DailyWeightData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface DailyWeightMapper {

    DailyWeightMapper INSTANCE = getMapper(DailyWeightMapper.class);

    @Mapping(source = "weighingDate", target = "weighingDate", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "morningWeight", target = "morningWeight")
    DailyWeightData dailyWeightToDailyWeightData(DailyWeight dailyWeight);
}
