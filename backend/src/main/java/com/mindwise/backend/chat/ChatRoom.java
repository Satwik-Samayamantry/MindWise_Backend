package com.mindwise.backend.chat;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue
    private Long chatRoomId;
    private Long patientId;
    private Long doctorId;

    @ElementCollection
    private List<Long> messageIdHistory;


}
