package com.example.justgo.repository;

import com.example.justgo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @auth chejiahui
 * @date 2019/9/18 18:04
 */
@Repository
public interface MemberDao extends JpaRepository<Member,Long> {

    Member getByMid(String mid);

}
