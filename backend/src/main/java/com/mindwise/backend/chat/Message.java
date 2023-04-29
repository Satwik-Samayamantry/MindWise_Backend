package com.mindwise.backend.chat;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long messageId;
    private Long chatRoomId;
    private Long senderId;
    private Long recipientId;
    private String content;
    private Date timestamp;
    private Boolean readReceipt;
}