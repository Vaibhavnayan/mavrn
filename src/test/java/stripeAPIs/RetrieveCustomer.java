package stripeAPIs;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class RetrieveCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Rest API of Retrieve Customer
		//get method
		//https://api.stripe.com/v1/customers?limit=2
		//no body
		//authorization
		
		//Step1-> rest assured - import rest assured package
		//Step2-> specify your request
		//Step3-> Capture the response
		
		
//		Response res = given().get("https://api.stripe.com/v1/customers");	
		
//		Response res = given()
//				.auth()
//				.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
//				.get("https://api.stripe.com/v1/customers");

		
//		Response res = given().queryParam("limit", "2")
//				.queryParam("email", "vaibhav@testing.com")
//				.auth()
//				.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
//				.get("https://api.stripe.com/v1/customers");
		
		//headers
		
		Response res = given().queryParam("limit", "2")
				.queryParam("email", "vaibhav@testing.com")
				//.auth()
				//.basic("sk_test_51LSffFSHAzlVCn31FW0YK27tfSobOx6QqOUCUM81tAnNzIdmyQp84DNshSTPV4cEVPttOdNwtVdbC9MeHMtuKSUX00j6TBz8NP", "")
				.header("Authorization","Basic c2tfdGVzdF81MUxTZmZGU0hBemxWQ24zMUZXMFlLMjd0ZlNvYk94NlFxT1VDVU04MXRBbk56SWRteVFwODRETnNoU1RQVjRjRVZQdHRPZE53dFZkYkM5TWVITXR1S1NVWDAwajZUQno4TlA6")
				//.header("Content-Type","application/json")
				.get("https://api.stripe.com/v1/customers");

		
		res.prettyPrint();
		
		String custID = res.jsonPath().get("data[0].id");
		
		System.out.println(custID);
		
		
		//System.out.println(res);
		
		//TESTNG
		
		
		
	}

}
