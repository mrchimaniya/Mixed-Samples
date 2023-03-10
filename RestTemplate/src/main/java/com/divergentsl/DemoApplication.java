package com.divergentsl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.divergentsl.bean.PostBean;

@SpringBootApplication
public class DemoApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		
		//Run as plain java application not in spring boot
		
		String url="https://jsonplaceholder.typicode.com";
		RestTemplate rt=new RestTemplate();
		
		//Get Plain JSON*************************************************************
//		ResponseEntity<String> re=rt.getForEntity(url+"/posts",String.class);
//		System.out.println(re);
//		System.out.println(re.getStatusCodeValue()); 
		
		//Retrieving POJO Instead of JSON********************************************
//		PostBean postBean=rt.getForObject(url+"/posts",PostBean.class);
//		System.out.println(postBean);
		
		// Use HEAD to Retrieve Headers*********************************************
//		HttpHeaders hh = rt.headForHeaders(url+"/posts");
//		System.out.println(hh.getContentLength());
//		System.out.println(hh.getContentType());
//		  hh.forEach((key, value) -> {
//		        System.out.println(key+"****"+value);
//		    });
		
		//Use POST to Create a Resource********************************************
		//In order to create a new Resource in the API, 
	    //We can make good use of the postForLocation(), postForObject() or postForEntity() APIs.
		PostBean pb=new PostBean();
		pb.setUserId("1");
		pb.setId("1");
		pb.setTitle("aaa");
		pb.setBody("aaaa");
		
		HttpEntity<PostBean> request = new HttpEntity<>(pb);
//		PostBean postBean = rt.postForObject(url+"/posts", request, PostBean.class);
//		System.out.println(postBean);
		
//	    URI uri = rt.postForLocation(url+"/posts", request);
//		System.out.println(uri);
		
//		ResponseEntity<?> re=rt.postForEntity(url+"/posts/1", request, PostBean.class);
//		System.out.println(re.getClass());
//		System.out.println(re.getStatusCode());
		

		ResponseEntity<PostBean> response = rt.exchange(url+"/posts", HttpMethod.POST, request, PostBean.class);
		PostBean pbr=response.getBody();
		System.out.println(pbr);
	}

}
