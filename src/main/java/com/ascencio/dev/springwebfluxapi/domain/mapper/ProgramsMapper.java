package com.ascencio.dev.springwebfluxapi.domain.mapper;

import com.ascencio.dev.springwebfluxapi.domain.dto.ProgramsRequestDto;
import com.ascencio.dev.springwebfluxapi.domain.dto.ProgramsResponseDto;
import com.ascencio.dev.springwebfluxapi.domain.model.Programs;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProgramsMapper {

    public static Programs toModel(ProgramsRequestDto dto) {
        return new Programs(
                dto.getName(),
                dto.getType(),
                dto.getBeneficiary(),
                dto.getResponsible(),
                dto.getDescription(),
                dto.getDuration(),
                dto.getCondition()
        );
    }

    public static Programs toModel(Integer id_program, ProgramsRequestDto dto) {
        return new Programs(
                id_program,
                dto.getName(),
                dto.getType(),
                dto.getBeneficiary(),
                dto.getResponsible(),
                dto.getDescription(),
                dto.getCondition(),
                dto.getDuration()
        );
    }

    public static ProgramsResponseDto toDto(Programs model) {
        return new ProgramsResponseDto(
                model.getId_program(),
                model.getName(),
                model.getType(),
                model.getBeneficiary(),
                model.getResponsible(),
                model.getDescription(),
                model.getDuration(),
                model.getCondition()
        );
    }
}
