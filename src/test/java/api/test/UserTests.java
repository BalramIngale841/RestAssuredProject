package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setupData() {
	    faker = new Faker();
	    userpayload = new User();

	    // Assign valid and reasonable data to the fields
	    userpayload.setId(faker.number().numberBetween(1, 10000)); // Generates a positive ID
	    userpayload.setUsername(faker.name().username());
	    userpayload.setFirstName(faker.name().firstName());
	    userpayload.setLastName(faker.name().lastName());
	    userpayload.setEmail(faker.internet().safeEmailAddress());
	    userpayload.setPassword(faker.internet().password(5, 10));
	    userpayload.setPhone(faker.phoneNumber().cellPhone());
	    userpayload.setUserstatus(1); // Optional, as it defaults to 0
	}

	
	@Test(priority=1)
	public void TestPostUser(){
		
		Response response =UserEndPoints.createUser(userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		
	}
	
	@Test(priority=2)
	public void TestGetUserByName() {
		
		Response response =UserEndPoints.ReadUser(this.userpayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	
	@Test(priority=3)
	public void TestUpdateUserByName()
	{
		
		//update data using payload
		
	 userpayload.setFirstName(faker.name().firstName());
     userpayload.setLastName(faker.name().lastName());
     userpayload.setEmail(faker.internet().safeEmailAddress());
		
	 Response response =UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
	 //checking data after update
		
		
		Response responseafterupdate =UserEndPoints.ReadUser(this.userpayload.getUsername());
		
		responseafterupdate.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		
	}
	
	
	@Test(priority=4)
	public void TestDeleteUserByName()
	{
		 Response response=	UserEndPoints.deleteUser(this.userpayload.getUsername());
		
		 Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
