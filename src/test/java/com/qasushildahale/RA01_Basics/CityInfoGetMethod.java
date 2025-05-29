package com.qasushildahale.RA01_Basics;

import io.restassured.RestAssured;

public class CityInfoGetMethod {

    public static void main(String[] args) {


        RestAssured
                .given()
                .baseUri("http://api.zippopotam.us")
                .basePath("/IN/140301")
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
