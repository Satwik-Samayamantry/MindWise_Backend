//package com.mindwise.backend.chat;
//
//import com.mindwise.backend.model.Patient;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class ChatController {
//
//    private ChatRoomService chatRoomService;
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//    @PostMapping("/getAllMessagesByPId")
//    public ResponseEntity<List<Message>> getAllMessagesByPId(@RequestParam("pid") Long p){
//        return ResponseEntity.ok(chatRoomService.getAllMessagesByPid(p));
//    }
//
//    @PostMapping("/acceptConsultation")
//    public ResponseEntity<ChatRoom> acceptConsultation(@RequestBody ChatRoom c){
//        return  ResponseEntity.ok(chatRoomService.setConsultationStatus(c.getChatRoomId()).orElseThrow(()->new IllegalStateException("Unable to set Consultation status")));
//    }
//
//    @MessageMapping("/chat")
//    public void processMessage(@Payload Message chatMessage) {
//        System.out.println("message : " + chatMessage);
//        Message m = chatRoomService.addMessageToConsultation(chatMessage.getChatRoomId(), chatMessage.getContent(), chatMessage.getSenderId(), chatMessage.getRecipientId()).orElseThrow(()-> new IllegalStateException("Could not add consultations"));
//
//        simpMessagingTemplate.convertAndSendToUser(
//                m.getChatRoomId().toString(),"/queue/messages",
//                m);
//    }
//
//    @GetMapping("/messages/{id}")
//    public ResponseEntity<?> findMessage ( @PathVariable Long id) {
//        return ResponseEntity
//                .ok(chatRoomService.getAllMessageForConsultationId(id));
//    }
//
//    @PostMapping("/isConsulting")
//    public ResponseEntity<List<ChatRoom>> isConsulting(@RequestBody Patient p) {
//        return ResponseEntity.ok(
//                chatRoomService.getAllConsultationPerUser(p.getPatientID())
//                        .orElseThrow(()-> new IllegalStateException("Could not find consultations"))
//        );
//    }
//
//    @PostMapping("/addConsultation")
//    public ResponseEntity<ChatRoom> addConsultation(@RequestBody ChatRoom cons) {
//        return ResponseEntity.ok(
//                chatRoomService.addConsultationBetweenUserId(cons.getDoctorId(), cons.getPatientId())
//                        .orElseThrow(()-> new IllegalStateException("Could not add consultations"))
//        );
//    }
//
//
//
//}
