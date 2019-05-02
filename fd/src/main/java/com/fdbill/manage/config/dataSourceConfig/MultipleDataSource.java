package com.fdbill.manage.config.dataSourceConfig;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * Created with IDEA
 * author:甘银道
 * Date:2018/12/11
 * Time:11:16
 */
public class MultipleDataSource extends AbstractRoutingDataSource{

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
