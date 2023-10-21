package com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Programs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProgramsRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;
    @Column
    private Integer id_program;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String beneficiary;
    @Column
    private String responsible;
    @Column
    private String description;
    @Column
    private String condition;
    @Column
    private Integer duration;

}
