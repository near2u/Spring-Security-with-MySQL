package com.project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.app.entities.Topic; 
import com.project.app.service.TopicService;

@RestController
@RequestMapping(value="/user")
public class TicketBookingController {

	@Autowired
	TopicService topicService;
	
	@GetMapping(value="/topic/{id}")
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") Integer topicId) {
		Topic topic = topicService.getTopicById(topicId);
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}
	
	@GetMapping(value="/topic")
	public ResponseEntity<List<Topic>> getAllTopics() {
		List<Topic> list = topicService.getAllTopics();
		return new ResponseEntity<List<Topic>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/topic")
	public ResponseEntity<String> addTopic(@RequestBody Topic topic,UriComponentsBuilder builder) {
		boolean flag = topicService.addTopic(topic);
		if (!flag) {
			return new ResponseEntity("Topic already Exist", HttpStatus.CONFLICT);
			
		} else {
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(builder.path("/topic/{id}").buildAndExpand(topic.getTopicId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
	}
	
	@PutMapping(value="/topic")
	public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/topic/{id}")
	public ResponseEntity<Void> deleteTopicById(@PathVariable("id") Integer topicId) {
		topicService.deleteTopicById(topicId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
