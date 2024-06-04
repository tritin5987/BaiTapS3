package com.java_tuan4.kiemtra.Repository;

import com.java_tuan4.kiemtra.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIsDeletedFalse();
}

