package com.sj.mylibrary.user;

import com.sj.mylibrary.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
