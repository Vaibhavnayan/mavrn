package testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import utility.DataExtractor;



public class GetCustomerAPI {
	

	@Test(dataProviderClass = DataExtractor.class, dataProvider = "dataExtractor", groups="Functional")	
	public void TC1_validAPIKey(String name, String email, String desc) {
		 
		//create get API
		
		Response res = given().queryParam("limit", "2")
				.queryParam("email", email)
				//.auth()
				//.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
				.header("Authorization","Basic c2tfdGVzdF81MUxTZmZGU0hBemxWQ24zMUZXMFlLMjd0ZlNvYk94NlFxT1VDVU04MXRBbk56SWRteVFwODRETnNoU1RQVjRjRVZQdHRPZE53dFZkYkM5TWVITXR1S1NVWDAwajZUQno4TlA6")
				//.header("Content-Type","application/json")
				.get("https://api.stripe.com/v1/customers");
		
		//res.prettyPrint();
		
		System.out.println("TC1");
		//assertions- to compare the response
		
		
		//get the response
		//get the status code
		
		//pm.expect

		//assertions --which is used compare your expected and acutual data
		
		//status code should be 200
		
		//hard assertions & soft assertion
		
		//hard assertion - is going to stop your test case once any assertion is failed
		
//		Assert.assertEquals(res.getStatusCode(), 200);
//		System.out.println("after 1");
//		Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
//		System.out.println("after 2");
//		Assert.assertEquals(res.jsonPath().get("data[0].email"), "vaibhav@testing.com");
//		System.out.println("after 3");
		
		
		
		//soft assertion - is NOT going to stop your test case if any assertion is failed
		//but it will log the failed ones.
		
		SoftAssert softObject = new SoftAssert();
		
		
		softObject.assertEquals(res.getStatusCode(), 400);
		System.out.println("after 1");
		softObject.assertEquals(res.getStatusLine(), "HTTP/1.1 400 OK");
		System.out.println("after 2");
		softObject.assertEquals(res.jsonPath().get("data[0].email"), "vaibhav@testing.com");
		System.out.println("after 3");
		softObject.assertEquals(res.getTime(), 1000);
		
		softObject.assertAll();
		
		
		
		
	}
	
	
	@Test(groups= "Smoke")
	public void TC2_invalidAPIKey() {
		
		
		Response res = given().queryParam("limit", "2")
				.queryParam("email", "vaibhav@testing.com")
				//.auth()
				//.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
				.header("Authorization","Basic tfdGVzdF81MUxTZmZGU0hBemxWQ24zMUZXMFlLMjd0ZlNvYk94NlFxT1VDVU04MXRBbk56SWRteVFwODRETnNoU1RQVjRjRVZQdHRPZE53dFZkYkM5TWVITXR1S1NVWDAwajZUQno4TlA6")
				//.header("Content-Type","application/json")
				.get("https://api.stripe.com/v1/customers");
		
		//res.prettyPrint();
		
		System.out.println("TC2");
		
		
		
		Assert.assertEquals(res.getStatusCode(), 401);
		Assert.assertEquals(res.getStatusLine(),"HTTP/1.1 401 Unauthorized");
		
		
	}
	
	
	//selenium
	// Launch website -> navigation in website -> close the website
	
//	@BeforeMethod
//	public void launchwebsite() {
//		System.out.println("Launching website");
//		
//		//token generation
//	}
//	
//	
//	//selenium
//		// Launch Browser->Launch website -> navigation in website -> close the website-> close browser
//	
//	@BeforeTest
//	public void launchbrowser() {
//		System.out.println("Launching browser");
//	}
////	
////	
//	@AfterMethod
//	public void closeWebsite()
//	{
//		System.out.println("CLosing website");
//	}
////	
//	@AfterTest
//	public void closebrowser() {
//		System.out.println("Closing browser");
//	}

	
	
	
//BeforeTest-->BeforeMethod-->TC1-->AfterMethod-->BeforeMethod-->TC2-->AfterMethod()-->AfterTest
	

}
