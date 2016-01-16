package com.dunn.restful.client;

import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RESTfulClient {

	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseAddress());

		// Get XML
		System.out.println(service.path("staff-restful-service").path("xml/staff")
				.accept(MediaType.TEXT_XML).get(String.class));
		
		// Get JSON
		System.out.println(service.path("staff-restful-service").path("json/staff")
				.accept(MediaType.APPLICATION_JSON).get(String.class));
		
		//Get number Of Staff
		System.out.println(service.path("staff-restful-service").path("xml/staff/numOfStaff")
				.get(String.class));
		
		//GET Text
		System.out.println(service.path("staff-restful-service").path("text/staff")
				.accept(MediaType.TEXT_PLAIN).get(String.class));
		
	}

	private static URI getBaseAddress() {
		return UriBuilder.fromUri(
				"http://localhost:8888/").build();
	}

}
