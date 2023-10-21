package com.soa.canete.transaccional_allocation_soa_canete.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "unidadoperativa_programas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionalAllocation {

    @Id
    private Integer id_funcionaryteend;
    @Column
    private String description;
    @Column
    private String estado;
    @Column("id")
    private Integer id;
    @Column("id_program")
    private Integer id_program;

    public TransaccionalAllocation(String description, String estado, Integer id_adolescente, Integer id_funcionary) {
        this.description = description;
        this.estado = estado;
        this.id = id_adolescente;
        this.id_program = id_funcionary;
    }

}
