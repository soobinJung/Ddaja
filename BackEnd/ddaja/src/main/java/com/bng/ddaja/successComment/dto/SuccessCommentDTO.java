package com.bng.ddaja.successComment.dto;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.SuccessComment;
import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.dto.CommonDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class SuccessCommentDTO extends CommonDTO {

    @ApiModelProperty(
        name = "id"
        , example = "11"
    )
    private long id;

    @ApiModelProperty(
        name = "lID"
        , example = "11"
    )
    private long lID;

    @ApiModelProperty(
        name = "uID"
        , example = "11"
    )
    private long uID;

    @ApiModelProperty(
        name = "inUse"
        , example = "true"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "successComment"
        , example = ""
    )
    private String successComment;

    @ApiModelProperty(
        name = "successTitle"
        , example = ""
    )
    private String successTitle;

    @ApiModelProperty(
        name = "likeCount"
        , example = "1"
    )
    private int likeCount;

    @ApiModelProperty(
        name = "like"
        , example = "1"
    )
    private int successScore;

    public SuccessCommentDTO( SuccessComment vo ){
        this.id             = vo.getId();
        this.lID            = vo.getLicense().getId();
        this.uID            = vo.getUser().getId();
        this.successTitle   = vo.getSuccessTitle();
        this.successComment = vo.getSuccessComment();
        this.likeCount      = vo.getLikeCount();
        this.inUse          = vo.isInUse();
        this.successScore   = vo.getSuccessScore();
        super.createdDate   = vo.getCreatedDate();
    }

    public SuccessComment toEntity(License license, User user){
        return SuccessComment.builder()
        .id(this.id)
        .license(license)
        .user(user)
        .successTitle(this.successTitle)
        .successComment(this.successComment)
        .likeCount(this.likeCount)
        .inUse(this.inUse)
        .successScore(this.successScore)
        .build();
    }

    public void checkValue() {
        log.info("====== SuccessCommentDTO ToString ====== ");
        log.info("ID             : " + this.id);
        log.info("lID            : " + this.lID);
        log.info("uID            : " + this.uID);
        log.info("IN USE         : " + this.inUse);
        log.info("TITLE          : " + this.successTitle);
        log.info("COMMENT        : " + this.successComment);
        log.info("SUCCESS SCORE  : " + this.successScore);
        log.info("LIKE           : " + this.likeCount);
        log.info("====================================");
    }
}