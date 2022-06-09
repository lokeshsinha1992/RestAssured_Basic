package org.api.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.api.contants.Endpoints;
import org.api.model.PersonPoJo;
import org.api.utils.ConfigManager;

import java.lang.reflect.Type;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class PersonServiceHelper {

    // functions which will fetch data from endpoints

    // Get/Post/Get Single/ Patch/ delete
	// We need to read the config variables
	// Need to tell rest assured abt the url and port
	// Making a get request on this url and send the data to TestGetPerson

	private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
	private static final String PORT = ConfigManager.getInstance().getString("port");

	
	public PersonServiceHelper(){
		
		RestAssured.baseURI = BASE_URL;
		RestAssured.port = Integer.parseInt(PORT);
		RestAssured.useRelaxedHTTPSValidation();


	}

	public List<PersonPoJo> getAllPerson(){

		Response response = RestAssured.given().log().all().contentType(ContentType.JSON)
				.get(Endpoints.GET_ALL_PERSON).andReturn();

		Type type = new TypeReference<List<PersonPoJo>>(){}.getType();

		List<PersonPoJo> personPoJoList = response.as(type);

		return personPoJoList;

	}

	public Response createPerson(){
		// Make a post call

		PersonPoJo person = new PersonPoJo();
		person.setId(17);
		person.setAddress("address asd");
		person.setAge(32);
		person.setFirstName("Peson 17");
		person.setLastName("last name 17");
		person.setPhoneNumbers("33213-2232-565");

		Response response = RestAssured.given().contentType(ContentType.JSON)
				.when().body(person).post(Endpoints.CREATE_PERSON).andReturn();

		assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Person is created");

		return response;
	}


	public Response updatePerson(Integer id){

		PersonPoJo personPoJo = new PersonPoJo();
		personPoJo.setPhoneNumbers("4454-1554-4545");
		personPoJo.setLastName("aaaaa asd");
		personPoJo.setAge(33);
		personPoJo.setAddress("asd asd aweqwe asddfdfg");


		Response response = RestAssured.given().contentType(ContentType.JSON)
				.pathParam("id", id).when().body(personPoJo).patch(Endpoints.UPDATE_PERSON)
				.andReturn();


		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

		return response;
	}


	public Response deletePerson(Integer id){

		Response response = RestAssured.given().contentType(ContentType.JSON)
				.pathParam("id", id).when().delete(Endpoints.DELETE_PERSON)
				.andReturn();

		assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		return response;
	}

}
