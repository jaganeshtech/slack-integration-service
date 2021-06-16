/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas;


import com.eloqua.rs.eas.model.OAuthCredential;
import com.google.gson.Gson;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class AppService {


	public AppService() {
	}

	@GetMapping(path = "status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> statusApp() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}


	@GetMapping(path = "/configure", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity configureApp() {

		InputStream resource = null;
		try {
			resource = getClass().getClassLoader().getResourceAsStream("static/app/configure.html");
		} catch (Exception e) {
		e.printStackTrace();
		}
		InputStreamResource inputStreamResource = new InputStreamResource(resource);
	

		return new ResponseEntity<>(inputStreamResource, HttpStatus.OK);
	}


	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveAction(@RequestBody OAuthCredential credential) {
		String id = null;
		

		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
