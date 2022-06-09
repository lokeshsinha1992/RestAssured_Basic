package org.api.tests;

import org.apache.http.HttpStatus;
import org.api.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestDeletePerson {


	private PersonServiceHelper personServiceHelper;

	@BeforeClass
	public void init(){
		personServiceHelper = new PersonServiceHelper();
	}


	@Test
	public void deletePerson(){

		int status_code = personServiceHelper.deletePerson(17).getStatusCode();
		System.out.println(status_code);
		assertEquals(status_code, HttpStatus.SC_OK, "Deleted");


	}

}
