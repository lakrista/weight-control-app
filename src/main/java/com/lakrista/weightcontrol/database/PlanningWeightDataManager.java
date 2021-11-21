package com.lakrista.weightcontrol.database;

import com.lakrista.weightcontrol.domain.PlanningWeight;

public class PlanningWeightDataManager extends AbstractDataBaseManager<PlanningWeight> {

    private static final String DATA_BASE = "planning_weight";

    public PlanningWeightDataManager() {
        super(DATA_BASE);
    }

    @Override
    public PlanningWeight get(Long id) {
        return getEntityManager().find(PlanningWeight.class, id);
    }
}
