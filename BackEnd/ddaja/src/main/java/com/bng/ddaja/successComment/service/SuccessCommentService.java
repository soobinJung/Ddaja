package com.bng.ddaja.successComment.service;

import com.bng.ddaja.successComment.dto.SuccessCommentDTO;
import com.bng.ddaja.successComment.dto.SuccessCommentSearch;
import com.bng.ddaja.successComment.repository.SuccessCommentRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service; 

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SuccessCommentService {
    
    private SuccessCommentRepository successCommentRepository;

    public Page<SuccessCommentDTO> getAllSuccessCommentBySuccessCommentSearch(SuccessCommentSearch successCommentSearch) {
        return successCommentRepository.findAll(
            successCommentSearch.toSpecification()
            , successCommentSearch.toPageable()
        ).map(vo -> new SuccessCommentDTO(vo));
    }
}
