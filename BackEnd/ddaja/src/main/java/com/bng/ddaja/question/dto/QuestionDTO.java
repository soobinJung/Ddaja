package com.bng.ddaja.question.dto;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Question;
import com.bng.ddaja.common.domain.Round;
import com.bng.ddaja.common.domain.Subject;
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
public class QuestionDTO extends CommonDTO {
    
    @ApiModelProperty(
        name = "id"
        , example = "11"
    )
    private long id;

    @ApiModelProperty(
        name = "rID"
        , example = "11"
    )
    private long rID;

    @ApiModelProperty(
        name = "lID"
        , example = "11"
    )
    private long lID;

    @ApiModelProperty(
        name = "sID"
        , example = "11"
    )
    private long sID;

    @ApiModelProperty(
        name = "no"
        , example = "11"
    )
    private int no;

    @ApiModelProperty(
        name = "inUse"
        , example = "true"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "title"
        , example = ""
    )
    private String title;

    @ApiModelProperty(
        name = "content"
        , example = ""
    )
    private String content;

    @ApiModelProperty(
        name = "answer"
        , example = "1"
    )
    private int answer;

    @ApiModelProperty(
        name = "answerOne"
        , example = ""
    )
    private String answerOne;

    @ApiModelProperty(
        name = "answerTwo"
        , example = ""
    )
    private String answerTwo;

    @ApiModelProperty(
        name = "answerThr"
        , example = ""
    )
    private String answerThr;

    @ApiModelProperty(
        name = "answerFour"
        , example = ""
    )
    private String answerFour;

    @ApiModelProperty(
        name = "answerFive"
        , example = ""
    )
    private String answerFive;

    @ApiModelProperty(
        name = "score"
        , example = "1"
    )
    private int score;

    public QuestionDTO( Question vo ){
        this.id             = vo.getId();
        this.rID            = vo.getRound().getId();
        this.lID            = vo.getLicense().getId();
        this.sID            = vo.getSubject().getId();
        this.no             = vo.getNo();
        this.title          = vo.getTitle();
        this.content        = vo.getContent();
        this.answer         = vo.getAnswer();
        this.answerOne      = vo.getAnswerOne();
        this.answerTwo      = vo.getAnswerTwo();
        this.answerThr      = vo.getAnswerThr();
        this.answerFour     = vo.getAnswerFour();
        this.answerFive     = vo.getAnswerFive();
        this.score          = vo.getScore();
        this.inUse          = vo.isInUse();
        super.createdDate   = vo.getCreatedDate();
    }

    public Question toEntity(Round round, License license, Subject subject){

        return Question.builder()
                        .id(id)
                        .round(round)
                        .license(license)
                        .subject(subject)
                        .no(no)
                        .inUse(inUse)
                        .title(title)
                        .content(content)
                        .answer(answer)
                        .answerOne(answerOne)
                        .answerTwo(answerTwo)
                        .answerThr(answerThr)
                        .answerFour(answerFour)
                        .answerFive(answerFive)
                        .score(score)
                        .build();
    }

    public void checkValue() {
        log.info("====== Question ToString ====== ");
        log.info("ID             : " + this.id);
        log.info("RID            : " + this.rID);
        log.info("lID            : " + this.lID);
        log.info("SID            : " + this.sID);
        log.info("NO             : " + this.no );
        log.info("TITLE          : " + this.title);
        log.info("CONTENT        : " + this.content);
        log.info("ANSWER 1       : " + this.answerOne);
        log.info("ANSWER 1       : " + this.answerTwo);
        log.info("ANSWER 1       : " + this.answerThr);
        log.info("ANSWER 1       : " + this.answerFour);
        log.info("ANSWER 1       : " + this.answerFive);
        log.info("QUSETION SCORE : " + this.score);
        log.info("====================================");
    }
}
