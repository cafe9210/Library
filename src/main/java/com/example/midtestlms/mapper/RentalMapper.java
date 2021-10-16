package com.example.midtestlms.mapper;

import com.example.midtestlms.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface RentalMapper {

    // 대여정보 조회 return_status = 1 현재 대여중 상태
    @Select("select a.r_id, a.b_id, a.m_id, a.isbn, b.b_title, b.b_author, b.b_publisher , " +
            "a.rent_date, a.due_return_date, a.return_status, a.ext_num \n" +
            "from lms.rental_manage a\n" +
            "join lms.book_info b on a.isbn = b.isbn\n" +
            "where m_id = #{member.m_id}")
    List<Rental> findRental(@Param("member") Member member);

    // 책 대여
    @Insert("insert into lms.rental_manage(b_id,m_id,isbn,due_return_date) values(#{bid},#{mid},#{isbn}, date_add(now(), INTERVAL 14 DAY))")
    void insertRental(@Param("bid") int bid, @Param("mid") Long mid, @Param("isbn") String isbn);

    // 책 대여 연장하기
    @Update("update rental_manage set ext_num = ext_num + 1 , due_return_date = date_add(due_return_date,Interval 7 Day)\n" +
            "where r_id = ${r_id}")
    int updateDueReturnDate(@Param("r_id") int r_id);
}
