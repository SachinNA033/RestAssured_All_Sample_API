import files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payLoad.complexJson());

		// 1. Print No of courses returned by API
		int coursecount = js.getInt("courses.size()"); // size() is a Array method which gives the count of courses
		System.out.println(coursecount);

		// 2.Print Purchase Amount
		String purchaseamount = js.getString("dashboard.purchaseAmount");
		System.out.println(purchaseamount);

		// 3. Print Title of the first course
		String titleoffirstcourse = js.get("courses[0].title");
		System.out.println(titleoffirstcourse);

		// 4. Print All course titles and their respective Prices

		for (int i = 0; i < coursecount; i++) {

			String cousetitles = js.get("courses[" + i + "].title");
			System.out.println(cousetitles);

			System.out.println(js.get("courses[" + i + "].price").toString());
		}

		// 5. Print no of copies sold by RPA Course
		for (int i = 0; i < coursecount; i++) {

			String title = js.get("courses[" + i + "].title");

			if (title.equals("RPA")) {

				System.out.println("RPA copies count " + js.get("courses[" + i + "].copies").toString());
				break;

			}

		}

		// 6. Verify if Sum of all Course prices matches with Purchase Amount
		int totlaprice=0;
		for (int i = 0; i < coursecount; i++) {
			

			totlaprice+=(Integer)js.get("courses[" + i + "].price");
		
		
		}
		
		System.out.println("Total Price of the courses is "+totlaprice);

	}

}
