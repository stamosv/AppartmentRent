package com.blue.ground.InterviewApp.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="usersRepository")
public interface UsersRepositoryImpl extends JpaRepository<User, Long>{
}
