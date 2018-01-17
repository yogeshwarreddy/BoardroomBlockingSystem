package com.accolite.au.project.boardroombooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.project.boardroombooking.model.BoardRoom;
import com.accolite.au.project.boardroombooking.service.BoardRoomService;

@RestController
public class BoardRoomController {
	
	@Autowired
	private BoardRoomService boardRoomService;
	
	@PostMapping("/room")
	public ResponseEntity<String> save(@RequestBody BoardRoom room) {
		boardRoomService.saveRoom(room);
		return ResponseEntity.ok().body("New Board Room Added");
	}


	@GetMapping("/room/{id}")
	public ResponseEntity<BoardRoom> get(@PathVariable("id") int id) {
		BoardRoom room = boardRoomService.getRoomById(id);
		return ResponseEntity.ok().body(room);
	}

	
	@GetMapping("/rooms")
	public ResponseEntity<List<BoardRoom>> list() {
		List<BoardRoom> rooms = boardRoomService.getAllRooms();
		return ResponseEntity.ok().body(rooms);
	}


	@PutMapping("/room/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody BoardRoom room) {
		boardRoomService.updateRoom(room);
		return ResponseEntity.ok().body("Board Room has been updated successfully.");
	}


	@DeleteMapping("/room/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		boardRoomService.deleteRoomById(id);
		return ResponseEntity.ok().body("room has been deleted successfully.");
	}

}
