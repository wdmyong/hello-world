package com.wdm.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class MasterDataSourceConfig extends BaseDataSourceConfig {

}
