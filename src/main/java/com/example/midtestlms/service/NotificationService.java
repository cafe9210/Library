package com.example.midtestlms.service;

import com.example.midtestlms.domain.*;
import com.example.midtestlms.dto.NotificationDto;
import com.example.midtestlms.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class NotificationService {
    NotificationMapper notificationMapper;
    // 의존성 주입
    @Autowired
    public NotificationService(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    public List<Notification> findNotification(Member member){
        return notificationMapper.findNotification(member);
    }
    
    // 알람 신청하기
    @Transactional
    public Long register_notification(Book book, Member member) {
        return notificationMapper.save(book, member);
    } 
}
