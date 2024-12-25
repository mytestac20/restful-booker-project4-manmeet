package com.herokuapp.mytests;

import com.herokuapp.model.BookingPojo;
import com.herokuapp.testbase.TestBase;
import com.herokuapp.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPutTest extends TestBase {
    static String id;
    @Test
    public void verifyUpdateUser(){
        String firstName = "james" + TestUtils.getRandomValue();
        String lastName = "Brown" + TestUtils.getRandomValue();
        int totalPrice = 111;
        boolean depositPaid = true;
        HashMap<String, String> bookingDates = new HashMap<>();
        String checkIn = "2018-01-01";
        String checkOut = "2010-01-01";
        bookingDates.put("checkin", checkIn);
        bookingDates.put("checkout", checkOut);
        String additionalNeeds = "Breakfast";

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice(totalPrice);
        bookingPojo.setDepositpaid(depositPaid);
        bookingPojo.setBookingdates(bookingDates);
        bookingPojo.setAdditionalneeds(additionalNeeds);

        Response response = given().log().ifValidationFails()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPojo)
                .post("/booking");

        id = response.jsonPath().getString("bookingid");

        response.prettyPrint();
        response.then().log().ifValidationFails().statusCode(200);
    }
}
