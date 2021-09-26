package com.blue.ground.InterviewApp.units;

import com.blue.ground.InterviewApp.units.Unit;

import java.util.List;

public interface UnitsUseCase {

    List<Unit> searchUnits(String searchWord);

    List<Unit> retrieveFullList();

    List<Unit> sortUnitsAsc();

    List<Unit> sortUnitsDesc();

    List<Unit> retrievePageUnits(Integer page);
}
