package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {
    /*Given
	        1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                "userId": 21,
                "title": "Read the books",
                "completed": false
               }
            When
                I send PUT Request to the Url
            Then
                Status code is 200
            And response body is like
                {
                "userId": 21,
                "title": "Wash the dishes",
                "completed": false
                }
*/
    @Test
    public void put(){
        //Set the url
        spec.pathParams("first","todos","second",123);

        //Set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData= obj.expectedDataJPH(21,"Read the books",true);
        System.out.println(expectedData);

        //send the request get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object>actualData = response.as(HashMap.class); //De_Serialization
        System.out.println(actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
    }
 }
