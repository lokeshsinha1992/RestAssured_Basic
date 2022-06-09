package org.api.tests;

import org.api.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class TestPostPerson {

	private PersonServiceHelper personServiceHelper;

	@BeforeClass
	public void init(){
		personServiceHelper = new PersonServiceHelper();
	}


	@Test
	public void createPOSTPerson(){
		String id = personServiceHelper.createPerson().jsonPath().getString("id");
		System.out.println(id);

		assertNotNull(id, "Person id is not null");


	}

}
