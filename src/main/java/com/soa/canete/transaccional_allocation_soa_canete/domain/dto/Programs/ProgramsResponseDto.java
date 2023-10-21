package com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Programs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProgramsResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8735757125749188522L;

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
    private Integer duration;
    @Column
    private String condition;

    public ProgramsResponseDto() {

    }
}
