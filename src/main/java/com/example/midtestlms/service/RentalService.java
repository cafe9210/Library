package com.example.midtestlms.service;

import com.example.midtestlms.domain.*;
import com.example.midtestlms.mapper.RentalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    private final RentalMapper rentalMapper;
    // 의존성 주입
    @Autowired
    public RentalService(RentalMapper rentalMapper) {
        this.rentalMapper = rentalMapper;
    }

    // 책 대여정보 조회
    public List<Rental> findRental(Member member){
        return rentalMapper.findRental(member);
    }

    // 책 대여
    public Rental insertRental(Rental rental){
        return rentalMapper.insertRental(rental);
    }

}
