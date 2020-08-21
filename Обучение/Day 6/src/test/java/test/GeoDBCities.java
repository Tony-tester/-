package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GeoDBCities {

    static String rapidApiHost = "wft-geo-db.p.rapidapi.com";
    static String rapidApiKey = "c890e1c822msh80e39b93f28ce43p1f7e69jsnf1c7e24955c6";

    @Before
    public void setup() {
        RestAssured.baseURI = "https://wft-geo-db.p.rapidapi.com";
        RestAssured.port = 443;
    }

    @Test
    public void localesTest() {
        Response response =
        given()
                .contentType(ContentType.JSON)
                .header("x-rapidapi-host", rapidApiHost)
                .header("x-rapidapi-key", rapidApiKey)
                .param("hateoasMode", true)
                .param("limit", 1)
                .param("offset", 1)
        .when()
                .get("/v1/locale/locales");

        int offsetResult = response.path("metadata.currentOffset");
        Assert.assertEquals(offsetResult, 1);
        
    }

    @Test
    public void currenciesTest() {
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("x-rapidapi-host", rapidApiHost)
                        .header("x-rapidapi-key", rapidApiKey)
                        .param("hateoasMode", false)
                        .param("limit", 1)
                        .param("offset", 50)
                .when()
                        .get("/v1/locale/currencies");

        String dataCode = response.path("data.code").toString();
        Assert.assertTrue(dataCode.equals("[DZD]"));
    }

    @Test
    public void citiesTest() {
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("x-rapidapi-host", rapidApiHost)
                        .header("x-rapidapi-key", rapidApiKey)
                        .param("languageCode", "RU")
                        .param("limit", 1)
                .when()
                        .get("/v1/geo/cities");

        String cityName = response.path("data.name").toString();
        Assert.assertTrue(cityName.equals("[Андорра-ла-Велья]"));
    }

    @Test
    public void countriesTest() {
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("x-rapidapi-host", rapidApiHost)
                        .header("x-rapidapi-key", rapidApiKey)
                        .param("currencyCode", "EUR")
                        .param("limit", 1)
                        .when()
                        .get("/v1/geo/countries");

        String countriesName = response.path("data.name").toString();
        Assert.assertTrue(countriesName.equals("[Vatican City]"));
    }

    @Test
    public void timezonesTest() {
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("x-rapidapi-host", rapidApiHost)
                        .header("x-rapidapi-key", rapidApiKey)
                        .param("offset", 90)
                        .param("limit", 1)
                        .when()
                        .get("/v1/locale/timezones");

        String timezoneName = response.path("data.name").toString();
        String timezoneUtcHours = response.path("data.rawUtcOffsetHours").toString();
        Assert.assertTrue(timezoneName.equals("[Eastern European Standard Time]"));
        Assert.assertTrue(timezoneUtcHours.equals("[2]"));
    }

}
