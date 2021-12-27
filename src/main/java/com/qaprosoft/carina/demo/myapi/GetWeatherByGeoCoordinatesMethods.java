package com.qaprosoft.carina.demo.myapi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherByGeoCoordinatesMethods extends AbstractApiMethodV2 {
    public GetWeatherByGeoCoordinatesMethods() {
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
