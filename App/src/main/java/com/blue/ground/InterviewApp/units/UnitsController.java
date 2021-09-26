package com.blue.ground.InterviewApp.units;

import com.blue.ground.InterviewApp.reviews.ReviewsUseCaseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UnitsController {

    private static Logger logger = LogManager.getLogger(ReviewsUseCaseImpl.class);

    @Autowired
    UnitsUseCase unitsUsecase;

    @GetMapping("/searchUnits/{searchWord}")
    public List<Unit> searchUnits(@PathVariable String searchWord) {
        List<Unit> units = new ArrayList<>();
        try {
            units = unitsUsecase.searchUnits(searchWord);
        } catch (Exception e) {
            logger.error("Exception occurred on searchUnits! Details: " + e.getMessage());
        }
        return units;
    }

    @GetMapping(value = "/retrieveFullList")
    public List<Unit> retrieveFullList() {
        List<Unit> units = new ArrayList<>();
        try {
            units = unitsUsecase.retrieveFullList();
        } catch (Exception e) {
            logger.error("Exception occurred on retrieveFullList! Details: " + e.getMessage());
        }
        return units;
    }

    @GetMapping(value = "/sortUnitsAsc")
    public List<Unit> sortUnitsAsc() {
        List<Unit> units = new ArrayList<>();
        try {
            units = unitsUsecase.sortUnitsAsc();
        } catch (Exception e) {
            logger.error("Exception occurred on sortUnitsAsc! Details: " + e.getMessage());
        }
        return units;
    }

    @GetMapping(value = "/sortUnitsDesc")
    public List<Unit> sortUnitsDesc() {
        List<Unit> units = new ArrayList<>();
        try {
            units = unitsUsecase.sortUnitsDesc();
        } catch (Exception e) {
            logger.error("Exception occurred on sortUnitsDesc! Details: " + e.getMessage());
        }
        return units;
    }

    @GetMapping(value = "/retrievePageUnits/{page}")
    public List<Unit> retrievePageUnits(@PathVariable Integer page) {
        List<Unit> units = new ArrayList<>();
        try {
            units = unitsUsecase.retrievePageUnits(page);
        } catch (Exception e) {
            logger.error("Exception occurred on retrievePageUnits! Details: " + e.getMessage());
        }
        return units;
    }

}
