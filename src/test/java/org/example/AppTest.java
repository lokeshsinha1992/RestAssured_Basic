package org.example;



import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import static org.hamcrest.Matchers.anything;
//import static org.hamcrest.Matchers.is;


/**
 * Unit test for simple App.
 */
public class AppTest 
{


    @BeforeSuite
   void setup()   {
       System.out.println("Setup");
   }


   static RequestSpecification getCommonSpec()
   {
       RequestSpecBuilder builder = new RequestSpecBuilder();

       builder.setBaseUri("http://localhost:3000");



       RequestSpecification requestSpecification = builder.build();
       return requestSpecification;
   }

   @Test
    void get_person(){
    System.out.println("Gte re");


      Response response =  RestAssured.given().spec(getCommonSpec()).when().get("/persons").andReturn();


       JsonPath jpath = response.jsonPath();

       String result = jpath.get("[0].address");

       System.out.println("Address : " + result);

     //  System.out.println(response.asString());


   }

    @Test
    void get_user(){
        System.out.println("Gte re");


        Response response =  RestAssured.given().spec(getCommonSpec()).when().get("/users").andReturn();


        JsonPath jpath = response.jsonPath();

        String result = jpath.get("[0].email");

        System.out.println("Email : " + result);

        // System.out.println("Email  : "+ response.asString());

        response.getBody().prettyPrint();



    }


    @AfterSuite
    void tearDown(){
    System.out.println("Tear Down");
    }

}
