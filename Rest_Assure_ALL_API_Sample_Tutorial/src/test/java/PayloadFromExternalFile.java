import static io.restassured.RestAssured.*;

import java.nio.file.Paths;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class PayloadFromExternalFile {

	@Test
	public void addBook() throws IOException {

		try {

			String filepath = "C:\\Users\\SachinNagarajAchari\\OneDrive - Qyrus Inc\\Desktop\\Automation-Testing\\prepratio_interview\\Rest_Assured\\payload.json";
			Scanner scanner = new Scanner(new File(filepath));
			String jsonBody = scanner.useDelimiter("\\Z").next();

			RestAssured.baseURI = "http://216.10.245.166";
			given().log().all().header("Content-Type", "application/json").body(jsonBody).when()
					.post("Library/Addbook.php").then().log().all().statusCode(200);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
