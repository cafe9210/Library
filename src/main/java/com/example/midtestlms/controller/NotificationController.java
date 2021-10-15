package com.example.midtestlms.controller;

import com.example.midtestlms.domain.*;
import com.example.midtestlms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationController {
    private final NotificationService notificationService;
    private final MemberService memberService;
    private final BookService bookService;
    
    @Autowired
    public NotificationController(NotificationService notificationService, MemberService memberService, BookService bookService) {
        this.notificationService = notificationService;
        this.memberService = memberService;
        this.bookService = bookService;
    }

    @GetMapping("/alarm")
    public String notification_btn() {
        return "alarm/alarm";
    }

    @GetMapping("/alarm/complete")
    public String register_notification(Notification notification, @AuthenticationPrincipal User user) {
    	Member member = memberService.findMember(user.getUsername());
    	Book book = bookService.findbookById(2);
    	BookSearchInfo bookInfo = bookService.findbookinfoById(book);
    	System.out.println(member);
    	System.out.println(book);
    	System.out.println(bookInfo);
    	notificationService.register_notification(book, member);
    	System.out.println("알람 신청 완료");
    	return "alarm/complete";
    }
    
    public String goNotificationEmail() {
    	return "alarm/email";
    }
}

