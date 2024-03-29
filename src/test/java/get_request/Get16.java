package get_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import test_data.HerOkuAppTestData;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get16 extends HerOkuAppBaseUrl {
    /*
        Given
                https://restful-booker.herokuapp.com/booking/55
        When
                I send GET Request to the URL
        Then
                Status code is 200
                         {
                                "firstname": "Edgar",
                                "lastname": "Dominguez",
                                "totalprice": 111,
                                "depositpaid": true,
                                "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                                },
                                "additionalneeds": "Breakfast"
                            }
     */
    @Test
    public void get16() {

        // Set the Url
        spec.pathParams("first","booking","second",555);

        // Set the expected data
        String expectedDataInString = new HerOkuAppTestData().expectedDataInString("Edgar", "Dominguez", 111, true, "2018-01-01", "2019-01-01", "Breakfast");

        BookingPojo expectedData = JsonUtils.convertJsonToJavaObject(expectedDataInString, BookingPojo.class);
        System.out.println("expectedData = " + expectedData);

        // Send the Request and get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        BookingPojo actualData = JsonUtils.convertJsonToJavaObject(response.asString(), BookingPojo.class);// To use Pojo Class with Object Mapper is the best!!!
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());
    }
}