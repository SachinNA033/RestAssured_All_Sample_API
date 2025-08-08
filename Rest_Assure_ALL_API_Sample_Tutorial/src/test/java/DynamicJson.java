import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payLoad;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class DynamicJson {
	
	
	@Test(dataProvider="bookdata")
	public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
		given().log().all().header("Content-Type","application/json").
		body(payLoad.addBook(isbn, aisle)).
		when().post("Library/Addbook.php").
		then().log().all().statusCode(200);
		
	}
	
	//Parameterizing the API
	
	@DataProvider(name="bookdata")
	
	public Object[][] getdta(){
		
		return  new Object[][] {{"Ojfwty", "43678"},{"Asjfwty", "89436"},{"EFOjfwty", "79436"}};
		
	}
	

}
