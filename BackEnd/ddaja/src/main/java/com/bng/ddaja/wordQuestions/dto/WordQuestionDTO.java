package com.bng.ddaja.wordQuestions.dto;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.words.dto.WordDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class WordQuestionDTO extends CommonDTO{

    @ApiModelProperty(
        name = "id"
        , example = "11"
    )
    private long id;

    @ApiModelProperty(
        name = "content"
        , example = "~~ 란 ?"
    )
    private String content;

    @ApiModelProperty(
        name = "answer"
        , example = "운영체제"
    )
    private String answer;

    @ApiModelProperty(
        name = "inUse"
        , example = "1"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "lID"
        , example = "11"
    )
    private long lID;

    @ApiModelProperty(
        name = "wID"
        , example = "11"
    )
    private long wID;

    @ApiModelProperty(
        name = "WordDTO"
        , example = "11"
    )
    private WordDTO wordDTO;


    public WordQuestionDTO( WordQuestion wordQuestion ){
        id      = wordQuestion.getId();
        wordDTO = new WordDTO(wordQuestion.getWord());
        inUse   = wordQuestion.isInUse();
        lID     = wordQuestion.getLID();
        content = wordQuestion.getContent();
        answer  = wordQuestion.getAnswer();
    }

    public WordQuestion toEntity(Word word){ 
        return WordQuestion.builder()
        .id(id)
        .word(word)
        .inUse(inUse)
        .lID(lID)
        .content(content)
        .answer(answer)
        .build();
    }

    public void checkoutValue(){
        log.info("====== WordQuestion ToString ====== ");
        log.info("ID         : " + this.id);
        log.info("LICENSE ID : " + this.lID);
        log.info("WORD ID    : " + this.wID);
        log.info("CONTENT    : " + this.content);
        log.info("ANSWER     : " + this.answer);
        log.info("===================================="); 
    }
}
