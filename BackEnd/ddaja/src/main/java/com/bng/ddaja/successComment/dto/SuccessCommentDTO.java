package com.bng.ddaja.successComment.dto;

import com.bng.ddaja.common.domain.SuccessComment;
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
        name = "comment"
        , example = ""
    )
    private String comment;

    @ApiModelProperty(
        name = "title"
        , example = ""
    )
    private String title;

    @ApiModelProperty(
        name = "like"
        , example = "1"
    )
    private int like;

    @ApiModelProperty(
        name = "like"
        , example = "1"
    )
    private int successScore;

    public SuccessCommentDTO( SuccessComment vo ){
        this.id            = vo.getId();
        this.lID           = vo.getLicense().getId();
        this.uID           = vo.getUser().getId();
        this.comment       = vo.getComment();
        this.title         = vo.getTitle();
        this.like          = vo.getLike();
        this.inUse         = vo.isInUse();
        this.successScore  = vo.getSuccessScore();
        super.createdDate  = vo.getCreatedDate();
    }
}