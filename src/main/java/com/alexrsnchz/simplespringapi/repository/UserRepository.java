package com.alexrsnchz.simplespringapi.repository;

import com.alexrsnchz.simplespringapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
