//package com.mindwise.backend.chat;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class MessageService {
//
//    @Autowired
//    private MessageRepository repository;
//    @Autowired
//    private ChatRoomService chatRoomService;
//
//    public Message save(Message chatMessage) {
//        chatMessage.setStatus(MessageStatus.RECEIVED);
//        repository.save(chatMessage);
//        return chatMessage;
//    }
//
//    public long countNewMessages(String senderId, String recipientId) {
//        return repository.countBySenderIdAndRecipientIdAndStatus(
//                senderId, recipientId, MessageStatus.RECEIVED);
//    }
//
//    public List<Message> findChatMessages(String senderId, String recipientId) {
//        var chatId = chatRoomService.getChatId(senderId, recipientId, false);
//
//        var messages =
//                chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());
//
////        if(messages.size() > 0) {
////            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
////        }
//
//        return messages;
//    }
//
//    public Message findById(String id) {
//        return repository
//                .findById(id)
//                .map(chatMessage -> {
//                    chatMessage.setStatus(MessageStatus.DELIVERED);
//                    return repository.save(chatMessage);
//                })
//                .orElseThrow(() ->
//                        new Error("can't find message (" + id + ")"));
//    }
//
////    public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
////        Query query = new Query(
////                Criteria
////                        .where("senderId").is(senderId)
////                        .and("recipientId").is(recipientId));
////        Update update = Update.update("status", status);
////        mongoOperations.updateMulti(query, update, ChatMessage.class);
////    }
//
//
//
//}
