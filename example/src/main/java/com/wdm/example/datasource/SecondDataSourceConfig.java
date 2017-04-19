package com.wdm.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ds2.datasource")
public class SecondDataSourceConfig extends BaseDataSourceConfig {

}
