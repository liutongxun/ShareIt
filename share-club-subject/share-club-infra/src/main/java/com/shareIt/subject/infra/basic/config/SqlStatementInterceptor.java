package com.shareIt.subject.infra.basic.config;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
                Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class,
                Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})})
public class SqlStatementInterceptor implements Interceptor {

    public static final Logger log = LoggerFactory.getLogger("sys-sql");

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            long timeConsuming = System.currentTimeMillis() - startTime;
            log.info("SQL executed in: {}ms", timeConsuming);
            if (timeConsuming > 999 && timeConsuming < 5000) {
                log.info("SQL executed in more than 1 second: {}ms", timeConsuming);
            } else if (timeConsuming >= 5000 && timeConsuming < 10000) {
                log.info("SQL execut ed in more than 5 seconds: {}ms", timeConsuming);
            } else if (timeConsuming >= 10000) {
                log.info("SQL executed in more than 10 seconds: {}ms", timeConsuming);
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
