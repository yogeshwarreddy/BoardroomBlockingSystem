package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.BoardRoom;
import com.accolite.au.project.boardroombooking.repository.BoardRoomDao;

@Service
@Transactional
public class BoardRoomServiceImpl implements BoardRoomService {

	@Autowired
	private BoardRoomDao boardRoomDao;
	
	@Override
	public List<BoardRoom> getAllRooms() {
		return boardRoomDao.getAllRooms();
	}

	@Override
	public BoardRoom getRoomById(int id) {
		return boardRoomDao.getRoomById(id);
	}

	@Override
	public boolean saveRoom(BoardRoom room) {
		return boardRoomDao.saveRoom(room);
	}

	@Override
	public boolean updateRoom(BoardRoom room) {
		return boardRoomDao.updateRoom(room);
	}

	@Override
	public boolean deleteRoomById(int id) {
		return boardRoomDao.deleteRoomById(id);
	}

	@Override
	public boolean deleteRoom(BoardRoom room) {
		return boardRoomDao.deleteRoom(room);
	}

}
