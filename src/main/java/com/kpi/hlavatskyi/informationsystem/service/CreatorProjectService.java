package com.kpi.hlavatskyi.informationsystem.service;

import com.kpi.hlavatskyi.informationsystem.repository.CreatorProjectRepository;
import com.kpi.hlavatskyi.informationsystem.model.dto.CreatorProjectDTO;
import com.kpi.hlavatskyi.informationsystem.entity.CreatorProjectEntity;
import com.kpi.hlavatskyi.informationsystem.util.ProjectEntityFactory;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CreatorProjectService {

    private final CreatorProjectRepository creatorProjectRepository;

    private final UserService userService;

    public CreatorProjectService(CreatorProjectRepository creatorProjectRepository, UserService userService) {
        this.creatorProjectRepository = creatorProjectRepository;
        this.userService = userService;
    }

    public boolean insert(CreatorProjectEntity managerProject) {
        if (creatorProjectRepository.existsByProject(managerProject.getProject())) {
            return false;
        }
        creatorProjectRepository.save(managerProject);
        return true;
    }

    public ResponseEntity<Map<String, Object>> addProject(CreatorProjectDTO managerProject) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (insert(getManagerProjectsEntity(managerProject))) {
                map.put("Status", "added");
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
            map.put("Status", "existed");
        } catch (NotFoundException e) {
            log.error("Can not to add new project for manager with id: {}", managerProject.getMayorId());
            map.put("Status", "error");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public CreatorProjectEntity getManagerProjectsEntity(CreatorProjectDTO managerProject) throws NotFoundException {
        CreatorProjectEntity creatorProjects = new CreatorProjectEntity();
        creatorProjects.setMayor(userService.get(managerProject.getMayorId()));
        creatorProjects.setProject(ProjectEntityFactory.create(managerProject));
        return creatorProjects;
    }

}
