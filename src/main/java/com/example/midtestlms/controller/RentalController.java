package com.example.midtestlms.controller;

import com.example.midtestlms.domain.Member;
import com.example.midtestlms.mapper.RentalMapper;
import com.example.midtestlms.service.MemberService;
import com.example.midtestlms.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RentalController {
    RentalService rentalService;
    MemberService memberService;

    @Autowired
    public RentalController(MemberService memberService, RentalService rentalService) {
        this.memberService = memberService;
        this.rentalService = rentalService;
    }

    @RequestMapping(value = "/member/rental",method = {RequestMethod.GET, RequestMethod.POST})
    public String rental_btn(@AuthenticationPrincipal User user, @RequestParam("bid") String bid, @RequestParam("isbn") String isbn){  //@RequestParam(value = "isbn", required = false) String isbn
        Member member = memberService.findMember(user.getUsername());
        System.out.println("bid:"+ bid);
        System.out.println("isbn:"+ isbn);
        System.out.println("mid:"+member.getM_id());
        System.out.println("접속중인 유저 email " + user.getUsername());
        rentalService.insertRental(Integer.parseInt(isbn), member.getM_id(), isbn);
        return "redirect:/";
    }

//    @GetMapping("/book/rental")
//    public String rental(){
//        System.out.println("====book/rental=====");
//        return "member/info";
//    }

    @PostMapping("/book/rental/extension")
    public String rentalExtension(@AuthenticationPrincipal User user, @RequestParam("r_id") int r_id){
        //r_id 를 이용하여 책 대여 연장
        Member member = memberService.findMember(user.getUsername());
        System.out.println("extension" + r_id);
        int result = rentalService.updateDueReturnDate(37);
        if (result < 0){
            System.out.println("책 대여 연장 실패 로직 추가 구현 해야함");
            return "";
        }
        return "redirect:/member/info";
    }

    @GetMapping("/book/rental/extension")
    public String rentalExtension(){
        //r_id 를 이용하여 책 대여 연장
        System.out.println("extension post");
//        int result = rentalService.updateDueReturnDate(Integer.parseInt(rid));
//        if (result < 0){
//            System.out.println("책 대여 연장 실패 로직 추가 구현 해야함");
//            return "";
//        }
        return "redirect:/member/info";
    }

}
