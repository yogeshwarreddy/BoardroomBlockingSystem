package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.BoardRoom;

public interface BoardRoomService {
	List<BoardRoom> getAllRooms();
	BoardRoom getRoomById(int id);
	boolean saveRoom(BoardRoom room);
	boolean updateRoom(BoardRoom room);
	boolean deleteRoomById(int id);
	boolean deleteRoom(BoardRoom room);

}
