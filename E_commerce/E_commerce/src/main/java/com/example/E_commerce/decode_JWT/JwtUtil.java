package com.example.E_commerce.decode_JWT;

import java.security.SignatureException;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;


@Service
public class JwtUtil {
	
	  private static final String SECRET_KEY = "yourSecretKey"; // Should match the key in userService

	    public Jws<Claims> decodeJwt(String token) {
	    	  try {
	              // Parse the JWT and return the claims
	              return Jwts.parserBuilder()
	                      .setSigningKey(SECRET_KEY) // Set the signing key
	                      .build()
	                      .parseClaimsJws(token); // Parse the JWT token
	          } catch (SignatureException e) {
	              // Signature validation failed
	              throw new RuntimeException("Invalid token signature", e);
	          } catch (Exception e) {
	              // Catch any other exceptions
	              throw new RuntimeException("An error occurred while processing the token", e);
	          }
	    }
	    
	  

	
}
