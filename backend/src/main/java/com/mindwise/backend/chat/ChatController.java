package com.mindwise.backend.chat;

import com.mindwise.backend.model.Patient;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    private ChatRoomService chatRoomService;
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/getAllMessagesByPId")
    @CrossOrigin
    public ResponseEntity<List<Message>> getAllMessagesByPId(@RequestBody Patient p){
        return ResponseEntity.ok(chatRoomService.getAllMessagesByPid(p.getPatientID()));
    }

    @PostMapping("/acceptConsultation")
    @CrossOrigin
    public ResponseEntity<ChatRoom> acceptConsultation(@RequestBody ChatRoom c){
        return  ResponseEntity.ok(chatRoomService.setConsultationStatus(c.getChatRoomId()).orElseThrow(()->new IllegalStateException("Unable to set Consultation status")));
    }

    @MessageMapping("/chat")
//    @PreAuthorize("hasAnyAuthority('USER')")
    @CrossOrigin
    public void processMessage(@Payload Message chatMessage) {
        System.out.println("message : " + chatMessage);
        Message m = chatRoomService.addMessageToConsultation(chatMessage.getChatRoomId(), chatMessage.getContent(), chatMessage.getSenderId(), chatMessage.getRecipientId()).orElseThrow(()-> new IllegalStateException("Could not add consultations"));
//        userService.getUserById(chatMessage.getSenderId()).ifPresent((d)->{
//            notificationService.sendNotificationToPatient(chatMessage.getRecipientId(), "New message from Dr. "+ d.getName() + chatMessage.getContent());
//        });

        simpMessagingTemplate.convertAndSendToUser(
                m.getChatRoomId().toString(),"/queue/messages",
                m);
    }

    @GetMapping("/messages/{id}")
//    @PreAuthorize("hasAnyAuthority('USER')")
    @CrossOrigin
    public ResponseEntity<?> findMessage ( @PathVariable Long id) {
        return ResponseEntity
                .ok(chatRoomService.getAllMessageForConsultationId(id));
    }

}
