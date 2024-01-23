package com.uusudnd.api.repository;

import com.uusudnd.api.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
