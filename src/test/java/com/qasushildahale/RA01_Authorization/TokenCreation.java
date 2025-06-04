package com.qasushildahale.RA01_Authorization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class TokenCreation {
    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;


    @Test
    @Description("Case1 : To create the token using Post request")
public void create_Token()
{
    rs = RestAssured.given();
    rs.baseUri("https://restful-booker.herokuapp.com");
    rs.basePath("/auth");
    rs.contentType(ContentType.JSON);
    rs.body("{\n" +
            "    \"username\": \"admin\",\n" +
            "    \"password\": \"password123\"\n" +
            "}");

    response = rs.when().log().all().post();

    vr = response.then().log().all().statusCode(200);


}

}
