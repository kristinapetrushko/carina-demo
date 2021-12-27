package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.myapi.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MyAPISampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "kpetrushko")
    public void testGetCurrentWeather() {
        GetCurrentWeatherMethods getCurrentWeatherMethods = new GetCurrentWeatherMethods();
        getCurrentWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCurrentWeatherMethods.callAPI();
        getCurrentWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCurrentWeatherMethods.validateResponseAgainstSchema("myapi/_get/currentWeather/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "kpetrushko")
    public void testGetWeatherById() {
        GetWeatherByIdMethods getWeatherById = new GetWeatherByIdMethods();
        getWeatherById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherById.callAPI();
        getWeatherById.validateResponseAgainstSchema("myapi/_get/byId/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "kpetrushko")
    public void testGetWeatherByGeoCoordinates() {
        GetWeatherByGeoCoordinatesMethods getWeatherByGeoCoordinates = new GetWeatherByGeoCoordinatesMethods();
        getWeatherByGeoCoordinates.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByGeoCoordinates.callAPI();
        getWeatherByGeoCoordinates.validateResponseAgainstSchema("myapi/_get/byGeoCoordinates/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "kpetrushko")
    public void testGetWeatherByZipCode() {
        GetWeatherByZipCodeMethods getWeatherByZipCode = new GetWeatherByZipCodeMethods();
        getWeatherByZipCode.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByZipCode.callAPI();
        getWeatherByZipCode.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherByZipCode.validateResponseAgainstSchema("myapi/_get/byZipCode/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "kpetrushko")
    public void testGetForecastFiveDays() {
        GetForecastFiveDaysMethods getForecastFiveDays = new GetForecastFiveDaysMethods();
        getForecastFiveDays.expectResponseStatus(HttpResponseStatusType.OK_200);
        getForecastFiveDays.callAPI();
        getForecastFiveDays.validateResponseAgainstSchema("myapi/_get/forecastFiveDays/rs.schema");
    }
}
