package com.example.backendArctic.Service;

import com.example.backendArctic.Entity.Dto.AgreementServiceDto;
import com.example.backendArctic.Entity.AgreementService;
import com.example.backendArctic.Repo.AgreementServiceRepo;
import com.example.backendArctic.Util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class AgreementServiceSer {

    @Autowired
    private AgreementServiceRepo agreementServiceRepo;
    @Autowired
    private ModelMapper modelMapper;
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

