package com.java.boot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.java.boot3.Interceptor.AdminInterceptor;
import com.java.boot3.Interceptor.BoardInterceptor;
import com.java.boot3.Interceptor.SellerInterceptor;
import com.java.boot3.Interceptor.WriterCheckIntercptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private SellerInterceptor sellerInterceptor;
	@Autowired
	private AdminInterceptor adminInterceptor;
	@Autowired
	private BoardInterceptor boardInterceptor;
	@Autowired
	private WriterCheckIntercptor writerCheckIntercptor;
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// 적용할 Interceptor를 등록
		registry.addInterceptor(sellerInterceptor)
		// Interceptor를 사용할 URL
				.addPathPatterns("/product/manage");
		// 제외할 URL
//				.excludePathPatterns("")
		
		//추가로 다른 Interceptor 등록
		registry.addInterceptor(adminInterceptor)
				.addPathPatterns("/admin/manage");
		
		registry.addInterceptor(boardInterceptor)
				.addPathPatterns("/board/*")
				.excludePathPatterns("/board/list");	
		
		registry.addInterceptor(writerCheckIntercptor)
				.addPathPatterns("/board/update")
				.addPathPatterns("/board/delete");
		
		registry.addInterceptor(localeChangeInterceptor)
				.addPathPatterns("/**");
		
//		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
