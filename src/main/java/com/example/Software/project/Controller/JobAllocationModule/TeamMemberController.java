

package com.example.Software.project.Controller.JobAllocationModule;


import com.example.Software.project.Dto.JobAllocationModule.TeamMemberDTO;
import com.example.Software.project.Entity.JobAllocationModule.TeamMemberEntity;
//import com.example.Software.project.Service.JobAllocationModule.CustomerServise;
import com.example.Software.project.Service.JobAllocationModule.JobsService;
import com.example.Software.project.Service.JobAllocationModule.TeamMemberServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class TeamMemberController {


    private final TeamMemberServise teamMemberServise = new TeamMemberServise();

    @Autowired
    public TeamMemberController(JobsService jobsService) {



    }
    @PostMapping("/addMember")
    public String createMember(@RequestBody TeamMemberDTO memberDTO) {
        TeamMemberServise.saveMember(memberDTO);
        return "Member saved successfully!";
    }
    @GetMapping("/getmember/{id}")
    public List<TeamMemberEntity> getAllMembersById() {

        return TeamMemberServise.getAllMembersById();

    }
}