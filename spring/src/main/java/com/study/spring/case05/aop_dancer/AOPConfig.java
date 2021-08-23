package com.study.spring.case05.aop_dancer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//使用Java配置代替 aop-config.xml

@Configuration           //(配置檔)用於取代xml
@EnableAspectJAutoProxy  //相當於<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@ComponentScan           //掃描
public class AOPConfig {
    @Bean(name = "dancer")
	public Performance dancer() {
	  return new Dancer();
  }
}
