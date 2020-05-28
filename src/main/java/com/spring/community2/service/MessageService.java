package com.spring.community2.service;

import com.spring.community2.dao.MessageMapper;
import com.spring.community2.entity.Message;
import com.spring.community2.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MessageService
 * @Author ruizhou
 * @Date 2020/5/28 15:48
 **/
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;


    public List<Message> findConversations(int userId, int offset, int limit) {
        return messageMapper.selectConversations(userId, offset, limit);
    }

    public int findConversationCount(int userId) {
        return messageMapper.selectConversationCount(userId);
    }

    public List<Message> findLetters(String conversationId, int offset, int limit) {
        return messageMapper.selectLetters(conversationId, offset, limit);
    }

    public int findLetterCount(String conversationId) {
        return messageMapper.selectLetterCount(conversationId);
    }

    public int findLetterUnreadCount(int userId, String conversationId) {
        return messageMapper.selectLetterUnreadCount(userId, conversationId);
    }

    public int addMessage(Message message) {
        message.setContent(HtmlUtils.htmlEscape(message.getContent()));
        message.setContent(sensitiveFilter.filter(message.getContent()));
        return messageMapper.insertMessage(message);
    }

    public int readMessage(List<Integer> ids) {
        return messageMapper.updateStatus(ids, 1);
    }

    public int deleteMessage(int id) {
        return messageMapper.updateStatus(Arrays.asList(new Integer[]{id}), 2);
    }
}
