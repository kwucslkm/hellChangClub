package com.hellChang.hellChangClub.repository;

import com.hellChang.hellChangClub.entity.BandMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BandMemberRepository extends JpaRepository<BandMemberEntity, Long> {

    Optional<BandMemberEntity> findByMemberEmail(String memberEmail);
}
