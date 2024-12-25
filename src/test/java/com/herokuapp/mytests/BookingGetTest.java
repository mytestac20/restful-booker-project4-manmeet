package com.herokuapp.mytests;

import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingGetTest  extends TestBase {


    @Test
    public void verifyUserAllTheBooking(){
        Response response = given()
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);

    }
    @Test
    public void verifyBookingAllBookingID(){
        Response response = given()

                .when()
                .get("/booking/4");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}