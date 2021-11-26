package com.bng.ddaja.passRate.dto;

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
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class PassRateDTO extends CommonDTO{
    
    private String serviceKey;
    private String grdCd;
    private String baseYY;
    private String pageNo;
    private String numOfRows;

}
