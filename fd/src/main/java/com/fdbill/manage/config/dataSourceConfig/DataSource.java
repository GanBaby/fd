package com.fdbill.manage.config.dataSourceConfig;

import java.lang.annotation.*;

/**
 * Created with IDEA
 * author:甘银涛
 * Date:2018/12/11
 * Time:11:17
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.SYS;
}
