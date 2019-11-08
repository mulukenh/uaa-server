package com.wcs.legalization.uaaserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wcs.legalization.uaaserver.entity.Verification;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, String> {
	Verification findByUsername(String username);
}
