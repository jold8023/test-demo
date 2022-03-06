package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by 10765 on 2022/2/25
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query(value = "select * from user where name like %?1%",nativeQuery = true)
    Page<User> findLikeName(String name, PageRequest pageRequest);
}
