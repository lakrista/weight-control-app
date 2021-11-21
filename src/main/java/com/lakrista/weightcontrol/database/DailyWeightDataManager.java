package com.lakrista.weightcontrol.database;

import com.lakrista.weightcontrol.domain.DailyWeight;

public class DailyWeightDataManager extends AbstractDataBaseManager<DailyWeight> {

    private static final String DATA_BASE = "daily_weight";

    public DailyWeightDataManager() {
        super(DATA_BASE);
    }

    @Override
    public DailyWeight get(Long id) {
        return getEntityManager().find(DailyWeight.class, id);
    }
}
