package com.hellChang.hellChangClub.entity;

import com.hellChang.hellChangClub.dto.BandMemberDTO;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "band_member_table")
public class BandMemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;
    @Column(length = 40, nullable = false, unique = true)
    private String memberEmail;
    @Column(length = 20, nullable = true)
    private String memberPassword;
    @Column(length = 30, nullable = true, unique = true)
    private String memberName;
    @Column(length = 30, nullable = true, unique = true)
    private String memberNickName;
    @Column(length = 20, nullable = true, unique = true)
    private String phone;
    @Column(length = 30, nullable = true)
    private String memberLocal;
    @Column(length = 40, nullable = true)
    private String memberInterest;
    @Column(length = 40, nullable = true)
    private String memberBirth;
    @Column(length = 40, nullable = true)
    private String memberCreateAt;
    @Column(length = 40, nullable = true)
    private String memberProfileFile;
    @Column(length = 40, nullable = true)
    private String memberOriginalFileName;
    @Column(length = 40, nullable = true)
    private String memberStoredFileName;

    public static BandMemberEntity toBandMemberEntity(BandMemberDTO bandMemberDTO) {
        BandMemberEntity bandMemberEntity = new BandMemberEntity();
        bandMemberEntity.setMemberEmail(bandMemberDTO.getMemberEmail());
        bandMemberEntity.setMemberPassword(bandMemberDTO.getMemberPassword());
        bandMemberEntity.setMemberName(bandMemberDTO.getMemberName());
        bandMemberEntity.setPhone(bandMemberDTO.getPhone());
//        bandMemberEntity.setMemberBirth(bandMemberDTO.getMemberBirth());
//        bandMemberEntity.setMemberCreateAt(bandMemberDTO.getMemberCreateAt());
//        bandMemberEntity.setMemberNickName(bandMemberDTO.getMemberNickName());
//        bandMemberEntity.setMemberLocal(bandMemberDTO.getMemberLocal());
//        bandMemberEntity.setMemberMobile(bandMemberDTO.getMemberMobile());
//        bandMemberEntity.setMemberInterest(bandMemberDTO.getMemberInterest());
//        bandMemberEntity.setMemberProfileFile(bandMemberDTO.getMemberProfileFile());
//        bandMemberEntity.setMemberOriginalFileName(bandMemberDTO.getMemberOriginalFileName());
//        bandMemberEntity.setMemberStoredFileName(bandMemberDTO.getMemberStoredFileName());

        return bandMemberEntity;
    }
    public static BandMemberEntity toBandMemberEntityWithId(BandMemberDTO bandMemberDTO) {
        BandMemberEntity bandMemberEntity = new BandMemberEntity();
        bandMemberEntity.setId(bandMemberDTO.getId());
        bandMemberEntity.setMemberEmail(bandMemberDTO.getMemberEmail());
        bandMemberEntity.setMemberPassword(bandMemberDTO.getMemberPassword());
        bandMemberEntity.setMemberName(bandMemberDTO.getMemberName());
        bandMemberEntity.setPhone(bandMemberDTO.getPhone());

//        bandMemberEntity.setMemberBirth(bandMemberDTO.getMemberBirth());
//        bandMemberEntity.setMemberCreateAt(bandMemberDTO.getMemberCreateAt());
//        bandMemberEntity.setMemberNickName(bandMemberDTO.getMemberNickName());
//        bandMemberEntity.setMemberLocal(bandMemberDTO.getMemberLocal());
//        bandMemberEntity.setMemberMobile(bandMemberDTO.getMemberMobile());
//        bandMemberEntity.setMemberInterest(bandMemberDTO.getMemberInterest());
//        bandMemberEntity.setMemberProfileFile(bandMemberDTO.getMemberProfileFile());
//        bandMemberEntity.setMemberOriginalFileName(bandMemberDTO.getMemberOriginalFileName());
//        bandMemberEntity.setMemberStoredFileName(bandMemberDTO.getMemberStoredFileName());

        return bandMemberEntity;
    }

    public static BandMemberEntity toMemberEntity(BandMemberDTO bandMemberDTO) {
        BandMemberEntity memberEntity = new BandMemberEntity();
        memberEntity.setMemberEmail(bandMemberDTO.getMemberEmail());
        memberEntity.setMemberPassword(bandMemberDTO.getMemberPassword());

        return memberEntity;
    }
}