package com.qasushildahale.RA02_CreateBooking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class Create_Booking {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;

    @Test
    @Description("Create a booking with valid information, Verify satus is 200 OK")
    public  void booking(){

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);

        rs.body("{\n" +
                "    \"firstname\" : \"Arn\",\n" +
                "    \"lastname\" : \"dah\",\n" +
                "    \"totalprice\" : 28,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : \n" +
                "    {\n" +
                "        \"checkin\" : \"{{$randomDateRecent}}\",\n" +
                "        \"checkout\" : \"{{$randomDateFuture}}\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}");

        response= rs.when().post();

        vr = response.then().log().all().statusCode(200);

    }
}
