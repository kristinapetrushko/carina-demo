package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.myapi.GetCurrentWeatherMethods;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MyAPISampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "me")
    public void testGetCurrentWeather() {
        GetCurrentWeatherMethods getCurrentWeatherMethods = new GetCurrentWeatherMethods();
        getCurrentWeatherMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCurrentWeatherMethods.callAPI();
        getCurrentWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCurrentWeatherMethods.validateResponseAgainstSchema("myapi/_get/rs.schema");
    }
}
