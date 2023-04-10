package testcases;

import static io.restassured.RestAssured.given;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import utility.DataExtractor;

public class CreateCustomerAPI {

	
	@Test(dataProviderClass = DataExtractor.class, dataProvider = "dataExtractor", groups= {"Smoke","Functional"})	
	public void TC1_validAPIKeys(String name, String email, String desc) {
		 
		//create get API
		
		Response res = given().auth()
				.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
				.formParam("name", name)
				.formParam("email", email)
				.formParam("description",desc)
				.post("https://api.stripe.com/v1/customers");
		
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
		
		
		softObject.assertEquals(res.getStatusCode(), 200);
		System.out.println("after 1");
		softObject.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
		System.out.println("after 2");
//		softObject.assertEquals(res.jsonPath().get("data[0].email"), "vaibhav@testing.com");
//		System.out.println("after 3");
		softObject.assertEquals(res.getTime(), 1000);
		
		softObject.assertAll();
		
		
	}
	
	@Test(groups = "Smoke")
	public void TC2_skipTestcase() {
	
		if(true)
		{
			throw new SkipException("Test is Skipped");
		}
		
		else
		{
			System.out.println("Not Skipped");
		}
		
		
	}
	
	
	
	
}
