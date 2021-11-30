package com.bng.ddaja.round.dto;

import java.util.Date;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Round;
import com.bng.ddaja.common.dto.CommonDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class RoundDTO extends CommonDTO {
    
    @ApiModelProperty(
        name = "id"
        , example = "11"
    )
    private long id;
    
    @ApiModelProperty(
        name = "examDate"
        , example = ""
    )
    private String examDate;
    
    @ApiModelProperty(
        name = "examYear"
        , example = ""
    )
    private String examYear;
    
    @ApiModelProperty(
        name = "round"
        , example = "0"
    )
    private int round;

    @ApiModelProperty(
        name = "inUse"
        , example = "true"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "lID"
        , example = "11"
    )
    private long lID;

    public RoundDTO (Round vo){
        id       = vo.getId();
        examDate = vo.getExamDate();
        examYear = vo.getExamYear();
        round    = vo.getRound();
        lID      = vo.getLicense().getId();
    }
    
    public Round toEntity(License license){
        return Round.builder()
        .id(this.id)
        .examDate(this.examDate)
        .examYear(this.examYear)
        .round(this.round)
        .inUse(this.inUse)
        .license(license)
        .build();

    }
}