//package com.mindwise.backend.chat;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//@RequiredArgsConstructor
//public class ChatRoomService {
//    private ChatRoomRepository chatRoomRepository;
//    private MessageRepository messageRepository;
//
//    public Optional<List<ChatRoom>> getAllConsultationPerUser(Long userId){
//        List<ChatRoom> temp=chatRoomRepository.findAll();
//        List<ChatRoom> ret=new ArrayList<ChatRoom>();
//        for(ChatRoom c: temp){
//            if(c.getDoctorId() == userId || c.getPatientId() == userId){
//                ret.add(c);
//            }
//        }
//        return Optional.of(ret);
//    }
//    public Optional<List<Message>> getAllMessageForConsultationId(Long cId){
//        Optional<ChatRoom> c=chatRoomRepository.findById(cId);
//        List<Message> ret = new ArrayList<Message>();
//        if(c.isPresent()){
//            for(Long mId: c.get().getMessageIdHistory()){
//                Optional<Message> m = messageRepository.findById(mId);
//                m.ifPresent(ret::add);
//            }
//            return Optional.of(ret);
//        }
//        return  Optional.of(ret);
//
//    }
//    public Optional<ChatRoom> addConsultationBetweenUserId(Long id1,Long id2){
//        ChatRoom c = new ChatRoom();
//        c.setPatientId(id2);
//        c.setDoctorId(id1);
//        return Optional.of(chatRoomRepository.save(c));
//    }
//
//    public Optional<ChatRoom> setConsultationStatus(Long cid){
//        Optional<ChatRoom> c = chatRoomRepository.findById(cid);
//        if(c.isPresent()){
////            c.get().setStatus(status);
//            return Optional.of(chatRoomRepository.save(c.get()));
//        }
//        return  Optional.of(null);
//    }
//    @Transactional
//    public Optional<Message> addMessageToConsultation(Long cid,String message, Long senderId, Long recipientId){
//        Message m = new Message();
//        m.setChatRoomId(cid);
//        m.setContent(message);
//        m.setTimestamp(new Date());
//        m.setReadReceipt(false);
//        m.setSenderId(senderId);
//        m.setRecipientId(recipientId);
//        Message ret = messageRepository.save(m);
//        Optional<ChatRoom> c = chatRoomRepository.findById(cid);
//        if(c.isPresent()){
//            ChatRoom consultation = c.get();
//            List<Long> messageIdHistory = consultation.getMessageIdHistory();
//            messageIdHistory.add(ret.getMessageId());
//            consultation.setMessageIdHistory(messageIdHistory);
//            chatRoomRepository.save(consultation);
//            return Optional.of(ret);
//        }
//        else return Optional.of(new Message());
//    }
//
//    public List<Message> getAllMessagesByPid(Long pid){
//        List<Message> ret = new ArrayList<Message>();
//        List<ChatRoom> cl = chatRoomRepository.findAll();
//        for(ChatRoom c : cl){
//            if(Objects.equals(c.getPatientId(), pid) || Objects.equals(c.getDoctorId(), pid)){
//                Optional<List<Message>> temp = getAllMessageForConsultationId(c.getChatRoomId());
//                if(temp.isPresent()){
//                    for(Message m: temp.get()){
//                        ret.add(m);
//                    }
//                }
//            }
//        }
//        return ret;
//
//    }
//
////    public Optional<String> getChatId(
////            String senderId, String recipientId, boolean createIfNotExist) {
////
////        return chatRoomRepository
////                .findBySenderIdAndRecipientId(senderId, recipientId)
////                .map(ChatRoom::getChatId)
////                .or(() -> {
////                    if(!createIfNotExist) {
////                        return  Optional.empty();
////                    }
////                    var chatId =
////                            String.format("%s_%s", senderId, recipientId);
////
////                    ChatRoom senderRecipient = ChatRoom
////                            .builder()
////                            .chatId(chatId)
////                            .senderId(senderId)
////                            .recipientId(recipientId)
////                            .build();
////
////                    ChatRoom recipientSender = ChatRoom
////                            .builder()
////                            .chatId(chatId)
////                            .senderId(recipientId)
////                            .recipientId(senderId)
////                            .build();
////                    chatRoomRepository.save(senderRecipient);
////                    chatRoomRepository.save(recipientSender);
////
////                    return Optional.of(chatId);
////                });
////    }
//
//}
