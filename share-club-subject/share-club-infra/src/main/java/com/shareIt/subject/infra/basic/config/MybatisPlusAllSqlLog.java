package com.shareIt.subject.infra.basic.config;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

public class MybatisPlusAllSqlLog implements InnerInterceptor {
    public static final Logger log = LoggerFactory.getLogger("sys-sql");

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        logInfo(boundSql, ms, parameter);
    }

    @Override
    public void beforeUpdate(Executor executor, MappedStatement ms, Object parameter) throws SQLException {
        BoundSql boundSql = ms.getBoundSql(parameter);
        logInfo(boundSql, ms, parameter);
    }

    private static void logInfo(BoundSql boundSql, MappedStatement ms, Object parameter) {
        try {
            log.info("parameter = " + parameter);
            // Get the node ID, which is the ID of the SQL statement
            String sqlId = ms.getId();
            log.info("sqlId = " + sqlId);
            // Get the configuration of the node
            Configuration configuration = ms.getConfiguration();
            // Get the final SQL statement
            String sql = getSql(configuration, boundSql, sqlId);
            log.info("Complete SQL: {}", sql);
        } catch (Exception e) {
            log.error("Exception: {}", e.getLocalizedMessage(), e);
        }
    }


    // Encapsulates the SQL query to return the full XML path, including the SQL statement node ID and the SQL query
    public static String getSql(Configuration configuration, BoundSql boundSql, String sqlId) {
        return sqlId + ":" + showSql(configuration, boundSql);
    }

    // Replaces the placeholders "?" in the SQL query
    public static String showSql(Configuration configuration, BoundSql boundSql) {
        // Get parameters
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        // Replace multiple spaces in the SQL query with a single space
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");

        if (!CollectionUtils.isEmpty(parameterMappings) && parameterObject != null) {
            // Get the type handler registry, which handles the conversion between Java types and database types
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();

            // If the type can be found using parameterObject.getClass(), replace the placeholder "?"
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?",
                        Matcher.quoteReplacement(getParameterValue(parameterObject)));
            } else {
                // MetaObject is used to wrap the originalObject and provides methods for getting and setting properties
                MetaObject metaObject = configuration.newMetaObject(parameterObject);

                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();

                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?",
                                Matcher.quoteReplacement(getParameterValue(obj)));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        // This branch handles dynamic SQL
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?",
                                Matcher.quoteReplacement(getParameterValue(obj)));
                    } else {
                        // Print a message indicating that the parameter is missing, preventing mismatched replacements
                        sql = sql.replaceFirst("\\?", "missing");
                    }
                }
            }
        }
        return sql;
    }


    // If the parameter is a String, add single quotes around it; if it is a Date, convert it to a formatted string and add single quotes; handle both null and non-null parameter cases.
    private static String getParameterValue(Object obj) {
        String value;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
                    DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(new Date()) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }
        }
        return value;
    }


}