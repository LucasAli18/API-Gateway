package com.example.apigateway.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class RouterValidator { //que endpoint o que servicios estan abiertos en la aplicacion

	public static final List<String> openEndpoints = List.of(
			"/auth"
			);
	
	public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> 
	openEndpoints.stream().noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
	
	
}
