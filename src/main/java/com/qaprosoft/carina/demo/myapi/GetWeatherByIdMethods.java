package com.qaprosoft.carina.demo.myapi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetWeatherByIdMethods extends AbstractApiMethodV2 {
    public GetWeatherByIdMethods() {
        super();
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
