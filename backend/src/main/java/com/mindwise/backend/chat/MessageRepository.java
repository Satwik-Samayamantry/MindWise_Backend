package com.mindwise.backend.chat;

import com.mindwise.backend.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Message getAllByMessageId(Long messageid);
}
