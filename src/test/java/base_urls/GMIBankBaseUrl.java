package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GMIBankBaseUrl {
     protected RequestSpecification spec;

        @Before//If you sue @Before annotation at the top of a method, it will be executed before every test method.
        public void setUp(){

            spec = new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api").build();
        }
    }
