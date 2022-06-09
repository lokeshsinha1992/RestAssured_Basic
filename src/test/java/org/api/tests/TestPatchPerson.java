package org.api.tests;

import io.restassured.response.Response;
import org.api.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPatchPerson {

	private PersonServiceHelper personServiceHelper;

	@BeforeClass
	public void init(){
		personServiceHelper = new PersonServiceHelper();
	}

	@Test
	public void updatePATCHPerson(){

		String id = personServiceHelper.updatePerson(17).jsonPath().getString("id");

		assertNotNull(id, "Updated");


	}


}
