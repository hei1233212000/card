package com.lado.controller;

import com.lado.model.entity.NameCard;
import com.lado.model.pojo.BoNameCard;
import com.lado.service.NameCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/v1/name-cards")
public class NameCardController {
	private NameCardService nameCardService;

	@Inject
	public NameCardController(NameCardService nameCardService) {
		this.nameCardService = nameCardService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<NameCard>> getAll() {
		return new ResponseEntity<>(nameCardService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id:\\d*}", method = RequestMethod.GET)
	public ResponseEntity<NameCard> get(@PathVariable Long id) {
		NameCard nameCard = nameCardService.find(id);
		if (nameCard == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(nameCard, HttpStatus.OK);
	}

	/**
	 * Publish the NameCard to the server which is either create the NameCard or update the NameCard
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<NameCard> publish(@RequestBody BoNameCard boNameCard) {
		NameCard nameCard = nameCardService.createOrUpdate(boNameCard);
		return new ResponseEntity<>(nameCard, HttpStatus.OK);
	}
}
