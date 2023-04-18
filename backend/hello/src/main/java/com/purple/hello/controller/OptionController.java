package com.purple.hello.controller;

import com.purple.hello.dto.in.UpdateRoomNameInDTO;
import com.purple.hello.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController("/option")
public class OptionController {
    @Autowired
    private final AlarmService alarmService;
    @Autowired
    private final FeedService feedService;
    @Autowired
    private final QuestionService questionService;
    @Autowired
    private final RoomService roomService;
    @Autowired
    private final UserRoomService userRoomService;
    @Autowired
    private final UserService userService;
    OptionController(AlarmService alarmService, FeedService feedService, QuestionService questionService, RoomService roomService,
                      UserRoomService userRoomService, UserService userService){
        this.alarmService = alarmService;
        this.feedService = feedService;
        this.questionService = questionService;
        this.roomService = roomService;
        this.userRoomService = userRoomService;
        this.userService = userService;
    }

    @ApiOperation(
            value = "그룹 이름 변경 API (v)"
            , notes = "해당 그룹의 이름을 변경해주는 API. 모든 이용자가 변경 가능하다.")
    @PutMapping("/room/name")
    public ResponseEntity<String> updateRoomNameByRoomIdAndUserId(@RequestBody UpdateRoomNameInDTO updateRoomNameInDTO, HttpServletRequest request){
        long userId = Long.parseLong(request.getAttribute("userId").toString());
        String updatedRoomName = userRoomService.updateRoomNameByRoomIdAndUserId(userId, updateRoomNameInDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRoomName);
    }
}
