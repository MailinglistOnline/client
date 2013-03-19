package com.redhat.mailinglistOnline.client.rest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class RestClient {
	
	
	public void method() {
		try {
			 
			ClientRequest request = new ClientRequest(
					"http://localhost:8080/RESTfulExample/json/product/get");
			request.accept("application/xml");
			ClientResponse<RestEmailCollection> response = request.get(RestEmailCollection.class);
	 
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}
			
			RestEmailCollection col =response.getEntity();
//	 
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//				new ByteArrayInputStream(response.getEntity().getBytes())));
//	 
//			String output;
//			System.out.println("Output from Server .... \n");
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}
			
	 
		  } catch (ClientProtocolException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
	 
		}
	}

