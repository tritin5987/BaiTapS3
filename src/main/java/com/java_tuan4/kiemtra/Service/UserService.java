package com.java_tuan4.kiemtra.Service;

import com.java_tuan4.kiemtra.Entity.User;
import com.java_tuan4.kiemtra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        // Lấy người dùng từ cơ sở dữ liệu bằng id
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Đặt trạng thái isDeleted thành true
            user.setDeleted(true);
            // Lưu người dùng đã thay đổi vào cơ sở dữ liệu
            userRepository.save(user);
        }
    }
    public List<User> findActiveUsers() {
        return userRepository.findByIsDeletedFalse();
    }
}

