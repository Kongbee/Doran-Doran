package com.purple.hello.dao;

import com.purple.hello.dto.out.ReadRoomOutDTO;

import java.util.List;

public interface RoomDAO {
    List<ReadRoomOutDTO> readRoomByUserId(long userId);
}
