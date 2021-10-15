package com.example.midtestlms.mapper;

import com.example.midtestlms.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface RentalMapper {

    // 대여정보 조회 return_status = 1 현재 대여중 상태
    @Select("select a.r_id, a.b_id, a.m_id, a.isbn, b.b_title, b.b_author, b.b_publisher , " +
            "a.rent_date, a.due_return_date, a.return_status \n" +
            "from lms.rental_manage a\n" +
            "join lms.book_info b on a.isbn = b.isbn\n" +
            "where m_id = #{member.m_id}")
    List<Rental> findRental(@Param("member") Member member);

    // 책 대여
    @Insert("insert into lms.rental_manage(b_id,m_id,isbn,due_return_date) values(#{bid},#{mid},#{isbn}, date_add(now(), INTERVAL 14 DAY))")
    Rental insertRental(@Param("bid") int bid, @Param("mid") int mid, @Param("isbn") String isbn);
}
