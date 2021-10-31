package com.bng.ddaja.test.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Query Parameter")
@Getter
@Setter
@ToString
public class TestParameter {
    
    @ApiModelProperty(example = "q=inuse=true,name=정처기")
    private String[] q;

    @ApiModelProperty(example = "fields=inuse,name,time")
    private String[] fields;

    @NotNull(message = "page는 필수 값입니다.")
    @ApiModelProperty(example = "page=1")
    private int page;

    @Max(value = 100, message = "최대 데이터 제한은 100 입니다.")
    @ApiModelProperty(example = "limit=10")
    private int limit = 10;
}
