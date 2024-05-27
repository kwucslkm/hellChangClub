package com.hellChang.hellChangClub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandGroupDTO {
    private Long id;
    private String groupName;
    private String groupLocal;
    private String groupInterest;
    private String createMemberNickname;
    private String createMemberId;
    private LocalDateTime groupCreateAt;
    private List<MultipartFile> groupProfileFile;
    private List<String> groupOriginalFileName;
    private List<String> groupStoredFileName;

}
