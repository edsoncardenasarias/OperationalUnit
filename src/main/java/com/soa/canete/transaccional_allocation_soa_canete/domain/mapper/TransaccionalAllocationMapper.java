package com.soa.canete.transaccional_allocation_soa_canete.domain.mapper;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationRequestDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**Clase utilitaria para mapear entre objetos DTO y modelos de TransaccionalAllocation.*/


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransaccionalAllocationMapper {

    public static TransaccionalAllocation toModel(TransaccionalAllocationRequestDto dto, Integer id_funcionaryteend) {
        return new TransaccionalAllocation(
                id_funcionaryteend,
                dto.getDescription(),
                dto.getEstado(),
                dto.getId(),
                dto.getId_program()
        );
    }

    public static TransaccionalAllocationResponseDto dto(TransaccionalAllocation model) {
        return new TransaccionalAllocationResponseDto(
                model.getId_funcionaryteend(),
                model.getDescription(),
                model.getEstado(),
                model.getId(),
                model.getId_program()
        );
    }

}
