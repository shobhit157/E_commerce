package com.example.E_commerce.Interceptor;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.E_commerce.DTO.LoginRequest;
import com.example.E_commerce.decode_JWT.JwtUtil;

//import com.example.userService.Interceptor.LoginRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	JwtUtil jwtUtil;

	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) 
	{
		String authHeader=request.getHeader("Authorization");
		
		if(authHeader!=null && authHeader.startsWith("Bearer "))
		{
			String token =authHeader.substring(7);
			String username=jwtUtil.decodeJwt(token).getBody().getSubject();
			
			if(username!=null && isUserValid(username))
			{
				return true;
			}
			
		}
		
		 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        return false;
		
		
	}
	
	 private boolean isUserValid(String username) {
	        // Call userService to validate the user
	        return new RestTemplate().getForObject(
	            "http://userservice/api/v1/users/validate?username=" + username,
	            Boolean.class
	        );
	    }

}
