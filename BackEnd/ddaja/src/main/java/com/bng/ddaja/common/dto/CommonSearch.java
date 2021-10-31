package com.bng.ddaja.common.dto;

import com.bng.ddaja.common.domain.CommonEntity;
import com.bng.ddaja.common.spec.CommonSpec;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "공통 검색 모델")
@Getter
@Setter
@ToString
public class CommonSearch implements CommonSpec {

    @ApiModelProperty(example = "page=1")
    private int page = 0;

    @ApiModelProperty(example = "size=10")
    private int size = 10;

    @Override
    public Pageable toPageable() {
        return PageRequest.of(page == 0 ? page : page - 1, size);
    }

    @Override
    public Specification<? extends CommonEntity> toSpecification() {
        return null;
    }
}
