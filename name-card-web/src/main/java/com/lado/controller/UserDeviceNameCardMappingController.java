package com.lado.controller;

import com.avaje.ebean.EbeanServer;
import com.lado.model.entity.UserDeviceNameCardMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mappings")
public class UserDeviceNameCardMappingController {
	private EbeanServer ebeanServer;

	@Inject
	public UserDeviceNameCardMappingController(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<UserDeviceNameCardMapping>> getAll() {
		return new ResponseEntity<>(ebeanServer.find(UserDeviceNameCardMapping.class).findList(), HttpStatus.OK);
	}
}
