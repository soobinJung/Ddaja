package com.bng.ddaja.words.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.test.dto.LicenseDTO;
import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;

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
public class WordDTO extends CommonDTO { 

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
        name = "title"
        , example = "리눅스 용어 외우기"
    )
    private String title;

    @ApiModelProperty(
        name = "inUse"
        , example = "1"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "License"
    )
    private LicenseDTO license;

    @ApiModelProperty(
        name = "WordQuestion Entity"
    ) 
    private List<WordQuestionDTO> wordQuestions = new ArrayList<WordQuestionDTO>();

    @ApiModelProperty(
        name = "wordQuestionCount"
    )
    private int wordQuestionsCount;

    public WordDTO( Word word ){
        id                 = word.getId();
        title              = word.getTitle();
        inUse              = word.isInUse();
        createdDate        = word.getCreatedDate();
        modifiedDate       = word.getModifiedDate();
        license            = new LicenseDTO(word.getLicense());

        Optional<List<WordQuestion>> op = Optional.ofNullable(word.getWordQuestions());
        if(op.isPresent()){
            op.get().forEach( x -> {
                if(x.isInUse()){
                    wordQuestionsCount++;
                }
            });
        }else{
            wordQuestionsCount = 0;
        }
    }

    public Word toEntity( License license ){
        return Word.builder()
            .id(id)
            .inUse(inUse)
            .title(title)
            .license(license)
            .build();
    }

    public void checkValue() {
        log.info("====== WordDTO ToString ====== ");
        log.info("ID        : " + this.id);
        log.info("lID       : " + this.lID);
        log.info("TITLE     : " + this.title);
        log.info("IN USE    : " + this.inUse);
        log.info("====================================");
    }
}
