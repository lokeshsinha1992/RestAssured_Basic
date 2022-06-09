package org.api.tests;


import org.api.helpers.PersonServiceHelper;
import org.api.model.PersonPoJo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertFalse;


import java.util.List;


public class TestGetPerson {


	private PersonServiceHelper personServiceHelper;

	@BeforeClass
	public void init(){
		personServiceHelper = new PersonServiceHelper();


	}

	@Test
	public void testGetAllPerson(){
		List<PersonPoJo> personPoJoList = personServiceHelper.getAllPerson();

		System.out.println(personPoJoList);

		assertNotNull(personPoJoList, "Person Exists and it is not null");
		assertFalse(personPoJoList.isEmpty(), "False");


	}

}
