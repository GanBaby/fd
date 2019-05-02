package com.fdbill.manage.config.dataSourceConfig;

/**
 * Created with IDEA
 * author:甘银涛
 * Date:2018/12/11
 * Time:11:17
 */
public enum  DataSourceEnum {

    SYS("sys"),FD("fd");

    private String value;

    DataSourceEnum(String value){this.value=value;}

    public String getValue() {
        return value;
    }
}
