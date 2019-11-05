package com.wcs.legalization.uaaserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.legalization.uaaserver.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String>{
	AppUser findByUsername(String username);
}
