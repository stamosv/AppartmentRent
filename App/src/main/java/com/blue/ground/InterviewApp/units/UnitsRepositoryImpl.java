package com.blue.ground.InterviewApp.units;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="unitsRepository")
public interface UnitsRepositoryImpl extends JpaRepository<Unit, Long> {

}
