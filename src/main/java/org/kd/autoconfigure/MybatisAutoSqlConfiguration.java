package org.kd.autoconfigure;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.kd.intercepts.MybatisAutoSql;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 自定注入mybatis sql 打印插件
 */
@Configuration
@ConditionalOnBean(SqlSessionFactory.class)
@AutoConfigureAfter(MybatisAutoConfiguration.class)
@ConditionalOnProperty(value = "mybatisAutoSql.show",matchIfMissing = true)
public class MybatisAutoSqlConfiguration {
	@Bean 
	public Interceptor getInterceptor(){ 
		return new MybatisAutoSql();
	} 
    
}