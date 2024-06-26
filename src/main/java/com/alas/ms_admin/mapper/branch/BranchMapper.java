package com.alas.ms_admin.mapper.branch;

import com.alas.ms_admin.dto.branch.request.CreateBranchRequestDto;
import com.alas.ms_admin.dto.branch.request.UpdateBranchRequestDto;
import com.alas.ms_admin.dto.branch.response.CreateBranchResponseDto;
import com.alas.ms_admin.dto.branch.response.UpdateBranchResponseDto;
import com.alas.ms_admin.model.branch.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchMapper {
    Branch mapCreateBranchRequestDtoToEntity(CreateBranchRequestDto createBranchRequestDto);
    CreateBranchResponseDto mapEntityToCreateBranchResponsetDto(Branch branch);

//    Branch mapUpdateBranchRequestDtoToEntity(UpdateBranchRequestDto updateBranchRequestDto);
    Branch mapUpdateBranchRequestDtoToEntity
    (UpdateBranchRequestDto updateBranchRequestDto, @MappingTarget Branch branch);

    UpdateBranchResponseDto mapEntityToUpdateBranchResponsetDto(Branch branch);

}
