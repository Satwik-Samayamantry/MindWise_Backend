package com.mindwise.backend.chat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    ChatRoom getAllByChatRoomId(Long chatroomid);
    List<ChatRoom> getAllByDoctorId(Long did);

    ChatRoom getAllByDoctorIdAndPatientId(Long doctorid, Long patientid);
}
