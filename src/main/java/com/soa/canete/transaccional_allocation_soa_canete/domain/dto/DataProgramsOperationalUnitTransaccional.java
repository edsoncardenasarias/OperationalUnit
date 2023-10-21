package com.soa.canete.transaccional_allocation_soa_canete.domain.dto;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.OperationalUnit.OperationalUnitResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Programs.ProgramsResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataProgramsOperationalUnitTransaccional {

    private OperationalUnitResponseDto operationalUnitResponseDto;
    private ProgramsResponseDto teenResponseDto;
    private TransaccionalAllocation transaccionalAllocation;

}
