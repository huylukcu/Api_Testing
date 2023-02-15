package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsIterableContaining.hasItem;

    public class Get04 extends JsonPlaceHolderBaseUrl {
        /*
           Given
               https://jsonplaceholder.typicode.com/todos
           When
                I send a GET request to the Url
           And
               Accept type is “application/json”
           Then
               HTTP Status Code should be 200
           And
               Response format should be "application/json"
           And
               There should be 200 todos
           And
               "quis eius est sint explicabo" should be one of the todos title
           And
               2, 7, and 9 should be among the userIds
        */
        @Test
        public void get04(){
            //Set the url
            spec.pathParam("first","todos");

            //Set the expected data

            //Send the request and get the response
            Response response=given().spec(spec).accept(ContentType.JSON).when().get("/{first}");
            //response.prettyPrint();

            //Do Assertion
            response.then().
                    assertThat().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    body("",hasSize(200),
                            "title",hasItem("quis eius est sint explicabo"),
                            "userId",hasItems(2,7,9));
      /*
        Note 1: When you execute assertion, Java stops execution after the first failure.
                It means, assertions after the failure were not executed.
                But the assertion before the failure were passed, because the assertions before the  failure were executed.
        Note 2: If you type your code as execution will stop after the failure, it is called "Hard Assertion".
        Note 3: If you type your code as execution will not stop after the failure, it is called "Soft Assertion".
        Note 4: If you use multiple "body()" method it will work like "Hard Assertion"
                If you use one single "body()" method with multiple assertions it will work like "Soft Assertion"
       */
        }

    }
