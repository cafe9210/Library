package com.example.midtestlms.controller;

import com.example.midtestlms.domain.*;
import com.example.midtestlms.dto.BookDto;
import com.example.midtestlms.mapper.RentalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentalController {
    RentalMapper rentalMapper;
    @Autowired
    public RentalController(RentalMapper rentalMapper) {
        this.rentalMapper = rentalMapper;
    }

    @GetMapping("/member/rental")
    public String addRental(@RequestParam(""), @AuthenticationPrincipal User user){
        rentalMapper.insertRental(bookDto.getB_id(), user.getUsername(), bookDto.getIsbn());
        return "redirect:/";
    }
}
