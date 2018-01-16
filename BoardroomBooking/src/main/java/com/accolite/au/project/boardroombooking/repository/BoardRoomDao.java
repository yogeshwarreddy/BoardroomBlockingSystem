package com.accolite.au.project.boardroombooking.repository;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.BoardRoom;

public interface BoardRoomDao {
	public List<BoardRoom> getAllRooms();
	public BoardRoom getRoomById(int id);
	public boolean saveRoom(BoardRoom room);
	public boolean updateRoom(BoardRoom room);
	public boolean deleteRoomById(int id);
	public boolean deleteRoom(BoardRoom room);
}
