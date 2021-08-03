package com.mingdev.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控 web.xml  ervletRegistrationBean
    //因为Spring boot内置了Servlet容器，所以没有web。xml 替代方法：ServletregistrationBean
    @Bean
    public ServletRegistrationBean bean(){
        ServletRegistrationBean<StatViewServlet> bean= new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),"/druid/*");

        //后台登陆需要有人登录，账号密码配置
        HashMap<String,String> initParameters = new HashMap<>();

        //增加配置
        initParameters.put("loginUsername","admin"); //登录key 是固定的，loginUsername，loginPassword
        initParameters.put("loginPassword","123456");

        //允许谁能访问
        initParameters.put("allow","");//参数为空，所有人都能访问

        //禁止谁能访问  initParameters.put("mingdev","192.168.2.155");

        bean.setInitParameters(initParameters);
        return bean;
    }

    //filter
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //可以过滤那些请求
        Map<String, String> initParameters = new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*,css,/druid/*");

        bean.setInitParameters(initParameters);//public void setInitParameters(Map<String, String> initParameters) {
                                                    //Assert.notNull(initParameters, "InitParameters must not be null");
                                                    //this.initParameters = new LinkedHashMap<>(initParameters);
   //                                               }
        return bean;
    }
}
