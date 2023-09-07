package delete_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete02 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/{bookingId}
        When
         I send DELETE Request to the Url
      Then
         Status code is 200
         And Response body is "Created"
     */

@Test
    public void delete02(){
    spec.pathParams("first","booking","second",48080);

    String expectedData = "Created";

    Response response = (Response) given().
            spec(spec).
            headers("Cookie","token=0d5878b7adccc3").
            contentType(ContentType.JSON).delete("/{first}/{second}");
    response.prettyPrint();


}
}
