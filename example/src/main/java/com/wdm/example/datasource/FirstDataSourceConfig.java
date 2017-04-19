package com.wdm.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ds1.datasource")
public class FirstDataSourceConfig extends BaseDataSourceConfig {

}
