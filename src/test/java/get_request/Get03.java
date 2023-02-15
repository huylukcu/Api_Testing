package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {

        /*
         Given
               https://jsonplaceholder.typicode.com/todos/23
         When
               User send GET Request to the URL
         Then
               HTTP Status Code should be 200
         And
             Response format should be "application/json"
         And
             "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
         And
             "completed" is false
         And
             "userId" is 2
        */
       @Test
        public void get03(){
            //Set the url
           spec.pathParams("first","todos","second",23);

            //Set the expected data

            //Send the request and get the response
           Response response=given().spec(spec).when().get("/{first}/{second}");
            response.prettyPrint();

          //Do Assertion
           //1.Way
           response.then().
                   statusCode(200).
                   contentType("application/json").
                   body("userId",equalTo(2)).
                   body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                   body("completed",equalTo(false));

           //2.Way
           response.then().
                   contentType("application/json").
                   statusCode(200).body("userId",equalTo(2),"title",
                   equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                   "completed",equalTo(false));

        }

    }


