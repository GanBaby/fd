package com.fdbill.manage.utils.shiro;

import com.fdbill.manage.utils.util.DigestUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * shiro密码加密配置
 * Created by 陈伟强 on 2017-8-3.
 */
public class PasswordHash implements InitializingBean {
    private String algorithmName;
    private int hashIterations;

    public String getAlgorithmName() {
        return algorithmName;
    }
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public int getHashIterations() {
        return hashIterations;
    }
    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasLength(algorithmName, "algorithmName mast be MD5、SHA-1、SHA-256、SHA-384、SHA-512");
    }

    public String toHex(Object source, Object salt) {
        return DigestUtils.hashByShiro(algorithmName, source, salt, hashIterations);
    }
}
