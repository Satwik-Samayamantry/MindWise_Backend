package com.mindwise.backend.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin(origins = "*")
public class ChatRoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/createchat")
    Long createChatRoom(@RequestBody Map<String,Long> data)
    {
        Long pid = data.get("patientid");
        Long did = data.get("doctorid");

//        System.out.println(pid);
//        System.out.println(did);

        ChatRoom temp = new ChatRoom();
        temp.setPatientId(pid);
        temp.setDoctorId(did);
        ChatRoom saved =chatRoomRepository.save(temp);
        return saved.getChatRoomId();
    }

    @GetMapping("getallmessages")
    List<Message> getallmessagesbyid(@RequestParam("chatroomid") Long chatroomid)
    {
        ChatRoom temp = chatRoomRepository.getAllByChatRoomId(chatroomid);
        List<Message> ans = new ArrayList<>();
        List<Long> msgs = temp.getMessageIdHistory();
        for(int i = 0; i<msgs.size(); i++)
        {
            Message m = messageRepository.getAllByMessageId(msgs.get(i));
            ans.add(m);
        }
        return ans;
    }

    @PostMapping("/getchatsbydoctorid")
    List<ChatRoom> getallchatsbydoctorid(@RequestParam("doctorid") Long did)
    {
        return chatRoomRepository.getAllByDoctorId(did);
    }

    @PostMapping("/getidbydocandpatid")
    Long getidbydocandpatid(@RequestBody Map<String,Long> data)
    {
        Long did = data.get("doctorid");
            Long pid = data.get("patientid");

        return chatRoomRepository.getAllByDoctorIdAndPatientId(did,pid).getChatRoomId();
    }

    @PostMapping("/addmessage")
//    void addmessage(@RequestParam("chatroomid") Long cid, @RequestParam("senderid") Long sid, @RequestParam("recipientid") Long rid, @RequestParam("content") String content, @RequestParam("readreceipt") Boolean readreceipt)
    void addmessage(@RequestBody Map<String,String> data)
    {
//        SimpleDateFormat formatDate = new SimpleDateFormat(
//                "dd/MM/yyyy  HH:mm:ss z");
//
//        Date date = new Date();
//        formatDate.setTimeZone(TimeZone.getTimeZone("IST"));
        Long cid = Long.parseLong(data.get("chatroomid"));
        Long sid = Long.parseLong(data.get("senderid"));
        Long rid = Long.parseLong(data.get("recipientid"));
        String content = data.get("content");
        Boolean readreceipt = Boolean.parseBoolean(data.get("readreceipt"));


        Message m = new Message();
        m.setChatRoomId(cid);
        m.setSenderId(sid);
        m.setRecipientId(rid);
        m.setContent(content);
        m.setTimestamp(new Date());
        m.setReadReceipt(readreceipt);
        Message saved = messageRepository.save(m);
        ChatRoom temp = chatRoomRepository.getAllByChatRoomId(cid);

        List<Long> currenthistory = temp.getMessageIdHistory();
        currenthistory.add(saved.getMessageId());
        temp.setMessageIdHistory(currenthistory);
        chatRoomRepository.save(temp);
    }

}
