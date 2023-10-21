package com.soa.canete.transaccional_allocation_soa_canete.service.impl;

import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.DataProgramsOperationalUnitTransaccional;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.OperationalUnit.OperationalUnitResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Programs.ProgramsResponseDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.dto.Transaccional.TransaccionalAllocationRequestDto;
import com.soa.canete.transaccional_allocation_soa_canete.domain.model.TransaccionalAllocation;
import com.soa.canete.transaccional_allocation_soa_canete.repository.TransaccionalAllocationRepository;
import com.soa.canete.transaccional_allocation_soa_canete.service.TransaccionalAllocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.soa.canete.transaccional_allocation_soa_canete.domain.mapper.TransaccionalAllocationMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransaccionalAllocationImpl implements TransaccionalAllocationService {

    @Autowired private WebClient.Builder webClientBuilder;

    final TransaccionalAllocationRepository transaccionalAllocationRepository;

    @Override
    public Mono<DataProgramsOperationalUnitTransaccional> findById(Integer id_funcionaryteend) {
        Mono<TransaccionalAllocation> family = transaccionalAllocationRepository.findById(id_funcionaryteend);
        return family.flatMap(dataFamily -> {
            Mono<OperationalUnitResponseDto> funcionaryResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/ms-soa/" + dataFamily.getId())
                    .retrieve()
                    .bodyToMono(OperationalUnitResponseDto.class);
            Mono<ProgramsResponseDto> teenResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8089/v1/programs/find/" + dataFamily.getId_program())
                    .retrieve()
                    .bodyToMono(ProgramsResponseDto.class);
            return funcionaryResponseDtoMono.zipWith(teenResponseDtoMono).map(dataGeneral -> {
                OperationalUnitResponseDto legalGuardianResponseDtoData = dataGeneral.getT1();
                ProgramsResponseDto adolescentResponseDtoData = dataGeneral.getT2();
                DataProgramsOperationalUnitTransaccional dataProgramsOperationalUnitTransaccional = new DataProgramsOperationalUnitTransaccional();
                dataProgramsOperationalUnitTransaccional.setTransaccionalAllocation(dataFamily);
                dataProgramsOperationalUnitTransaccional.setTeenResponseDto(adolescentResponseDtoData);
                dataProgramsOperationalUnitTransaccional.setOperationalUnitResponseDto(legalGuardianResponseDtoData);
                return dataProgramsOperationalUnitTransaccional;
            });
        });
    }

    @Override
    public Flux<DataProgramsOperationalUnitTransaccional> findAll() {
        Flux<TransaccionalAllocation> family = transaccionalAllocationRepository.findAll();
        return family.flatMap(dataFamily -> {
            Mono<OperationalUnitResponseDto> funcionaryResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/ms-soa/" + dataFamily.getId())
                    .retrieve()
                    .bodyToMono(OperationalUnitResponseDto.class);
            Mono<ProgramsResponseDto> teenResponseDtoMono = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8089/v1/programs/find/" + dataFamily.getId_program())
                    .retrieve()
                    .bodyToMono(ProgramsResponseDto.class);
            return funcionaryResponseDtoMono.zipWith(teenResponseDtoMono).map(dataGeneral -> {
                OperationalUnitResponseDto legalGuardianResponseDtoData = dataGeneral.getT1();
                ProgramsResponseDto adolescentResponseDtoData = dataGeneral.getT2();
                DataProgramsOperationalUnitTransaccional dataProgramsOperationalUnitTransaccional = new DataProgramsOperationalUnitTransaccional();
                dataProgramsOperationalUnitTransaccional.setTransaccionalAllocation(dataFamily);
                dataProgramsOperationalUnitTransaccional.setTeenResponseDto(adolescentResponseDtoData);
                dataProgramsOperationalUnitTransaccional.setOperationalUnitResponseDto(legalGuardianResponseDtoData);
                return dataProgramsOperationalUnitTransaccional;
            });
        });
    }

    @Override
    public Mono<TransaccionalAllocation> saveNewDataTransaccional(TransaccionalAllocationRequestDto request) {
        return this.transaccionalAllocationRepository.save(toModel(request));
    }
}
