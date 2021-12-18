package com.bng.ddaja.debate.dto;

import java.util.Date;

import com.bng.ddaja.common.domain.Debate;
import com.bng.ddaja.common.domain.Question;
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
public class DebateDTO extends CommonDTO {
    
    @ApiModelProperty(
        name = "id"
        , example = "11"
    )
    private long id;

    @ApiModelProperty(
        name = "dpID"
        , example = "11"
    )
    private long dpID;

    @ApiModelProperty(
        name = "qID"
        , example = "11"
    )
    private long qID;

    @ApiModelProperty(
        name = "uID"
        , example = "11"
    )
    private long uID;

    @ApiModelProperty(
        name = "debate"
        , example = ""
    )
    private String debate;

    @ApiModelProperty(
        name = "likeCount"
        , example = "1"
    )
    private long likeCount;

    @ApiModelProperty(
        name = "dislikeCount"
        , example = "1"
    )
    private long dislikeCount;

    @ApiModelProperty(
        name = "inUse"
        , example = "1"
    )
    private String inUse;

    @ApiModelProperty(
        name = "createdDate"
        , example = "20200101"
    )
    private Date createdDate;

    public DebateDTO( Debate vo ){
        this.id           = vo.getId();
        this.dpID         = vo.getDpID();
        this.uID          = vo.getUser().getId();
        this.qID          = vo.getQuestion().getId();
        this.debate       = vo.getDebate();
        this.likeCount    = vo.getLikeCount();
        this.inUse        = vo.getInUse();
        this.dislikeCount = vo.getDislikeCount();
        this.createdDate  = vo.getCreatedDate();
    }

    public Debate toEntity(Question question, User user){
        return Debate.builder()
                        .id(id)
                        .dpID(dpID)
                        .user(user)
                        .question(question)
                        .debate(debate)
                        .likeCount(likeCount)
                        .dislikeCount(dislikeCount)
                        .inUse(inUse)
                        .build();
    }

    public void checkValue() {
        log.info("====== Debate ToString ====== ");
        log.info("ID             : " + this.id);
        log.info("QPID           : " + this.dpID);
        log.info("QID            : " + this.qID);
        log.info("UID            : " + this.uID);
        log.info("DEBATE         : " + this.debate );
        log.info("LIKE COUNT     : " + this.likeCount);
        log.info("DISLIKE COUNT  : " + this.dislikeCount);
        log.info("====================================");
    }
}
