package com.blue.ground.InterviewApp.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.*;


@Service(value = "unitsUseCase")
public class UnitsUseCaseImpl implements UnitsUseCase {

    private static Logger logger = LogManager.getLogger(UnitsUseCaseImpl.class);

    @Autowired
    private UnitsRepositoryImpl unitsRepository;

    final static Integer MIN = 1;

    final static Integer MAX = 10;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<Unit> retrieveFullList() {
        List<Unit> units = new ArrayList<>();
        try {
            units = unitsRepository.findAll();
        } catch (Exception e) {
            logger.error("Exception occurred on retrieveFullList! Details: " + e.getMessage());
        }
        return units;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<Unit> searchUnits(String searchWord) {
        List<Unit> units = unitsRepository.findAll();
        ArrayList<Unit> searchedSubList = new ArrayList<>();
        try {
            for (Unit unit : units) {
                if (unit.getTitle().contains(searchWord) || unit.getRegion().contains(searchWord)) {
                    searchedSubList.add(unit);
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred on searchUnits! Details: " + e.getMessage());
        }
        return searchedSubList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<Unit> sortUnitsAsc() {
        List<Unit> units = unitsRepository.findAll();
        try {
            units.sort(Comparator.comparing(Unit :: getScore));
        } catch (Exception e) {
            logger.error("Exception occurred on sortUnitsAsc! Details: " + e.getMessage());
        }
        return units;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<Unit> sortUnitsDesc() {
        List<Unit> units = unitsRepository.findAll();
        try {
            units.sort(Comparator.comparing(Unit :: getScore).reversed());
        } catch (Exception e) {
            logger.error("Exception occurred on sortUnitsDesc! Details: " + e.getMessage());
        }
        return units;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<Unit> retrievePageUnits(Integer page) {
        List<Unit> units = unitsRepository.findAll();
        List<Unit> subUnitsList = new ArrayList<>();
        try {
            subUnitsList = createPageList(page, units, subUnitsList);
        } catch (Exception e) {
            logger.error("Exception occurred on retrievePageUnits! Details: " + e.getMessage());
        }
        return subUnitsList;
    }

    private List<Unit> createPageList(Integer page, List<Unit> units, List<Unit> subUnitsList) {
        for (int i = ((page * MAX) - MAX); i <= ((page * MAX) - MIN); i++) {
            if (i <= units.size() + 1) {
                subUnitsList.add(units.get(i));
            } else {
                break;
            }
        }
        return subUnitsList;
    }


}
