package com.spring.boot.jpa.rest.template.call;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.jpa.model.Topic;

@Component
public class RestTemplateCall  implements CommandLineRunner
{
    @Autowired
	RestTemplate restTemplate ;
	String url = "http://localhost:8081/";
	
   public void addTopic()
   {
	   HttpHeaders headers = new HttpHeaders();
	   headers.setContentType(MediaType.APPLICATION_JSON);
	   headers.add("LL", "LL");
	   headers.set("setting", "settttt");
	   String body = "{\r\n"
	   		+ "        \"id\": \"java11\",\r\n"
	   		+ "        \"name\": \"Core Java Description11\",\r\n"
	   		+ "        \"description\": \"core Java1222\"\r\n"
	   		+ "    }";
	   
	   Topic topic = new Topic("java44", "Core Java Description55", "core Java131212");
	   
//	   HttpEntity<String> httpEntity = new HttpEntity<String>(body,headers);
	   HttpEntity<Topic> httpEntity = new HttpEntity<>(topic,headers);
	   ResponseEntity<Topic> exchange = restTemplate.exchange(url+"topics/"+"java", HttpMethod.GET,httpEntity,Topic.class);
	   System.out.println("before body");
	   System.out.println(exchange.getBody());
	   System.out.println(exchange.getStatusCodeValue());
	   System.out.println(exchange.getHeaders().toString());
	   System.out.println(exchange.getStatusCode());
	   
   }
   
   public void getAllTopics()
   {
//	   /*
//	   ResponseEntity<Topic[]> forEntity = restTemplate.getForEntity(url, Topic[].class);
	   ResponseEntity<Topic[]> forEntity = restTemplate.exchange(url+"topics",HttpMethod.GET,null, Topic[].class);
	   Topic[] body = forEntity.getBody();
	   List<Topic> asList = Arrays.asList(body);
	   asList.stream().forEach(x -> System.out.println(x));
//	   System.out.println(asList);
//	 */
   }

   @Override
   public void run(String... args) throws Exception
   {
//      	getAllTopics();
//      	addTopic();
   }
}
