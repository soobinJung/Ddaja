package com.bng.ddaja.test.dto;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDTO {

    @ApiModelProperty(
        name = "id"
        , example = "1"
    )
    private long id;

    @ApiModelProperty(
        name = "lCode"
        , example = "NONE"
    )
    private LicenseCode lCode;

    @ApiModelProperty(
        name = "name"
        , example = "정보처리기사"
    )
    private String name;

    @ApiModelProperty(
        name = "inUse"
        , example = "1"
    )
    private boolean inUse;

    @ApiModelProperty(
        name = "agency"
        , example = "Q-net"
    )
    private String agency;

    @ApiModelProperty(
        name = "passScore"
        , example = "60"
    )
    private int passScore; 
    
    @ApiModelProperty(
        name = "type"
        , example = "WRITING"
    )
    private LicenseType type;

    public LicenseDTO ( long id, String name ) {
        this.id = id;
        this.name = name;
    }
    
    public LicenseDTO ( License license ){
        this.id = license.getId();
        this.lCode = license.getLCode();
        this.passScore = license.getPassScore();
        this.name = license.getName();
        this.agency = license.getAgency();
        this.type = license.getType();
    }

    public License toEntity (){
        return License.builder()
                        .id(id)
                        .lCode(lCode)
                        .name(name)
                        .inUse(inUse)
                        .passScore(passScore)
                        .agency(agency)
                        .type(type)
                        .build();
    }
}
