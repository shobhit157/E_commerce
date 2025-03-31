package com.example.E_commerce.UserServiceClient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.E_commerce.DTO.UserDTO;
import com.example.E_commerce.entity.User;

@Service
public class UserServiceClient {
	
	private final RestTemplate restTemplate;
	
	public UserServiceClient(RestTemplate restTemplate)
	{
		this.restTemplate=restTemplate;
	}
	

	
	public UserDTO getUserDetails(Long userId,String JwtToken)
	{
		String url="http://userservice/users/" + userId;
		
		HttpHeaders headers =new HttpHeaders();
		headers.set("Authorixation","bearer"+JwtToken);
		HttpEntity<Void> requestEntity=new HttpEntity<>(headers);
		
		
		ResponseEntity<UserDTO> response=restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserDTO.class);
		if(response.getStatusCode().is2xxSuccessful() && response.getBody()!=null)
		{
			return response.getBody();
		}else
		{
			 throw new RuntimeException("Failed to fetch user details");
		}
	}



}
	
