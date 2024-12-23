package com.gadget.tech.repo;
import com.gadget.tech.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositry extends JpaRepository<UserModel, Long> {
 Optional<UserModel> findByEmail(String email);
 Optional<UserModel> findByPhoneNumber(String phoneNumber);

}
