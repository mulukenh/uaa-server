package com.wcs.legalization.uaaserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.legalization.uaaserver.entity.UserDao;

@Repository
public interface UserRepository extends JpaRepository<UserDao, String> {
	UserDao findByUsername(String username);
}
