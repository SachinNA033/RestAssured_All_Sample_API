
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class GraphQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Query
		System.out.println("Query GraphQL");
		given().log().all().header("Content-Type", "application/json").body(
				"{\"query\":\"query($code:ID!) { country (code:$code)\\n  {\\n  \\n name\\n    capital\\n    currency\\n    emoji\\n    continent {\\n      name\\n    }\\n}\\n}\",\"variables\":{\"code\":\"IN\"}}")
				.post("https://countries.trevorblades.com/").then().log().all().statusCode(200);

		//Mutation
		System.out.println("Mutation GraphQL");
		given().log().all().header("Content-Type", "application/json").body(
				"{\"operationName\":null,\"variables\":{\"input\":\"My first Album\",\"userId\":1},\"query\":\"mutation ($input: String!, $userId: ID!) {\\n  createAlbum(input: {title: $input, userId: $userId}) {\\n    id\\n    title\\n    user {\\n      id\\n      name\\n    }\\n  }\\n}\\n\"}")
				.post("https://graphqlzero.almansi.me/api").then().log().all().statusCode(200);

	}

}
