package com.iflytek.vuedemo.config;

//import com.alibaba.druid.support.http.StatViewServlet;
//import com.iflytek.inteceptor.JwtInterceptor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截路径可自行配置多个 可用 ，分隔开
//        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/**");
//    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setBeanName("HiddenHttpMethodFilter");
        hiddenHttpMethodFilter.setMethodParam("_method");
        return hiddenHttpMethodFilter;
    }


//    //阿里数据源监控支持
//    @Bean
//    public ServletRegistrationBean createServlet(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        Map<String,String> params = new HashMap<String, String>();
//        params.put("loginUsername","admin");
//        params.put("loginPassword","123456");
//        params.put("allow","");
//        params.put("deny","192.168.1.121");
//
//        bean.setInitParameters(params);
//        return bean;
//    }
}