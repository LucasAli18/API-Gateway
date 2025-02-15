package com.example.apigateway.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtUtils {
 private final String secretKey = "asgdweutwudyhweidhwsutwgeyudhwsydgwetydwegduywgydfsytdgstyfgdsytfgsdyfgsdyufhwuihdfsuidfhwei";

 public Claims getClaims(String token) {
	 return Jwts.parserBuilder()
			 .setSigningKey(secretKey)
			 .build()
			 .parseClaimsJws(token)
			 .getBody();
 }
 
 public boolean isExpired(String token) {
	 try {
		 return getClaims(token).getExpiration().before(new Date());
	 }catch(Exception e) {
		 return true;
	 }
 }
 
public Integer extractUserId(String token) {
	try {
		 return Integer.parseInt(getClaims(token).getSubject());
	 }catch(Exception e) {
		 return null;
	 }
}
}
