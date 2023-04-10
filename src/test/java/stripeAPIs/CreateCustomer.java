package stripeAPIs;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.response.Response;
public class CreateCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//without any request body
		
//		Response res = given().auth()
//				.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
//				.post("https://api.stripe.com/v1/customers");

		//with request body
		//form body
		
//		Response res = given().auth()
//				.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
//				.formParam("name", "vaibhav")
//				.formParam("email", "vaibhav@test.com")
//				.formParam("description","this is a test data").log().all()
//				.post("https://api.stripe.com/v1/customers");

		
		Response res = given().auth()
				.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
				.formParam("name", "vaibhav")
				.formParam("email", "vaibhav@test.com")
				.formParam("description","this is a test data")
				.formParam("address[city]","bangalore")
				.formParam("address[country]","IN")
				.formParam("preferred_locales[0]","Hello")
				.formParam("preferred_locales[1]","Hi")
				.post("https://api.stripe.com/v1/customers");
		
	//capture the response data
		//res.prettyPrint();
		
		String custID = res.jsonPath().get("id");
		String email = res.jsonPath().get("email");
		String city = res.jsonPath().get("address.city");
		String prefLocal = res.jsonPath().get("preferred_locales[0]");
		
		System.out.println(custID);
		System.out.println(email);
		System.out.println(city);
		System.out.println(prefLocal);
		
		//response code
		System.out.println(res.getStatusCode());
		
		System.out.println(res.getStatusLine());
		
		System.out.println(res.getTime());
		
		
//Testcases-> use the capture data and compare with expected response (assertions)
		
		
		
		
		
		//request body - in json body
		
		//https://reqres.in/api/users
		//create user using json body
		
		// {"name":"vaibhav", "job":"tester"}
		
//		String reqBody = "{\"name\":\"vaibhav\", \"job\":\"tester\"}"; 
//		
//		//String message = "hello\"this is my string";
//		
//		Response res = given().body(reqBody).header("Content-Type","application/json")
//				.post("https://reqres.in/api/users");
//		

		
		// request body using json file
				
//		Response res = given().body(new File("C:\\Users\\HP\\APITesting_7AM\\apitesting\\src\\test\\resources\\test.json"))
//				.header("Content-Type","application/json")
//		.post("https://reqres.in/api/users");
		
		
		
		
		
		
		
		//GET-> auth, queryparam, header
		//POST -> pass form data, json body, log request data in console	
		
		
		
		
	}

}
