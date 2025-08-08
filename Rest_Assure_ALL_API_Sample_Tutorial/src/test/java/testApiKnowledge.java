import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class testApiKnowledge {

	public static void main(String[] args) {

		String response=given().log().all().accept(ContentType.JSON)
				.param("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.param("client_secret", "erZOWM9g3UtwNRj340YYaK_W").param("grant_type", "client_credentials")
				.param("scope", "trust").post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		JsonPath js=new JsonPath(response);
		String token=js.get("access_token");
		System.out.println("Access token is = "+token);

	}

}
