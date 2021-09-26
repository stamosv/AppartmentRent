package com.blue.ground.InterviewApp;

import com.blue.ground.InterviewApp.reviews.ReviewsRepositoryImpl;
import com.blue.ground.InterviewApp.reviews.ReviewsUseCase;
import com.blue.ground.InterviewApp.units.Unit;
import com.blue.ground.InterviewApp.units.UnitsUseCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewAppApplicationTests {

	@Autowired
	private UnitsUseCase unitsUseCase;

	@Autowired
	private ReviewsUseCase reviewsUseCase;

	@Autowired
	private ReviewsRepositoryImpl reviewsRepositoryImpl;

	@Test
	public void contextLoads() {
	}

	@Test
	public void retrieveFullUnitsListTest() {
		List<Unit> units = unitsUseCase.retrieveFullList();
		Assert.assertEquals(units.size(), 22);
	}

	@Test
	public void searchUnitsTest() {
		String searchWord = "Attica";
		List<Unit> units = unitsUseCase.searchUnits(searchWord);
		Assert.assertEquals(units.size(), 2);
	}

	@Test
	public void sortUnitsAscTest() {
		List<Unit> units = unitsUseCase.sortUnitsAsc();
		Assert.assertEquals(units.get(0).getTitle(), "Catalunya");
	}

	@Test
	public void sortUnitsDescTest() {
		List<Unit> units = unitsUseCase.sortUnitsDesc();
		Assert.assertEquals(units.get(0).getTitle(), "Paradise on Earth");
	}

	@Test
	public void postReview() {
		reviewsUseCase.postReview(2L, 3, "testComment");
		Assert.assertEquals(reviewsRepositoryImpl.findAll().size(), 6);
	}

	@Test
	public void retrievePageUnits() {
		Integer page = 1;
		List<Unit> units = unitsUseCase.retrievePageUnits(page);
		Assert.assertEquals(units.get(0).getTitle(), "Blue Moon");
		Assert.assertEquals(units.get(9).getTitle(), "Cozy italian place");

		units = unitsUseCase.retrievePageUnits(page+2);
		Assert.assertEquals(units.get(0).getTitle(), "The roof");
		Assert.assertEquals(units.get(1).getTitle(), "Villa");
	}

}
