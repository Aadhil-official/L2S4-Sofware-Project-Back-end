package com.example.Software.project.Service;

import com.example.Software.project.Dto.AgreementServiceDto;
import com.example.Software.project.Entity.ServiceAgreement.AgreementService;
import com.example.Software.project.Repo.ServiceAgreement.AgreementServiceRepo;
import com.example.Software.project.Util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class AgreementServiceSer {

    private final AgreementServiceRepo agreementServiceRepo;
    private final ModelMapper modelMapper;

    public AgreementServiceSer(AgreementServiceRepo agreementServiceRepo, ModelMapper modelMapper) {
        this.agreementServiceRepo = agreementServiceRepo;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public String saveAgreementService(AgreementServiceDto agreementServiceDto){
        if (agreementServiceRepo.existsById(agreementServiceDto.getId())){
            return VarList.RSP_DUPLICATED;
        }
        else{
            agreementServiceRepo.save(modelMapper.map(agreementServiceDto, AgreementService.class));
            return VarList.RSP_SUCCESS;
        }
    }
}

