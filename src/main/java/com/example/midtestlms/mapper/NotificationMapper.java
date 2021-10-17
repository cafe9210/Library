package com.example.midtestlms.mapper;

import com.example.midtestlms.domain.Member;
import com.example.midtestlms.domain.Notification;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotificationMapper {
	@Select("SELECT book_info.b_title, notification.n_id, notification.resp_date, notification.isbn \n" +
            "FROM notification, book_info where m_id = #{member.m_id} and book_info.isbn = notification.isbn ")
    List<Notification> findNotification(@Param("member") final Member member);
}
