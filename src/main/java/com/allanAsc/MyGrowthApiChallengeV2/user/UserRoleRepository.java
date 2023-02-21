package com.allanAsc.MyGrowthApiChallengeV2.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query(value="select * from login.users_roles where user_id=?", nativeQuery = true)
    UserRole findByUserId(Integer userId);
}
