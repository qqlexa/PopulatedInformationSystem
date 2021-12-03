package com.kpi.hlavatskyi.informationsystem.service;

import com.kpi.hlavatskyi.informationsystem.repository.ManagerProjectRepository;
import com.kpi.hlavatskyi.informationsystem.model.dto.ManagerProjectDTO;
import com.kpi.hlavatskyi.informationsystem.entity.ManagerProjectEntity;
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
public class ManagerProjectService {

    private final ManagerProjectRepository managerProjectsRepository;

    private final UserService userService;

    public ManagerProjectService(ManagerProjectRepository managerProjectsRepository, UserService userService) {
        this.managerProjectsRepository = managerProjectsRepository;
        this.userService = userService;
    }

    public boolean insert(ManagerProjectEntity managerProject) {
        if (managerProjectsRepository.existsByProject(managerProject.getProject())) {
            return false;
        }
        managerProjectsRepository.save(managerProject);
        return true;
    }

    public ResponseEntity<Map<String, Object>> addProject(ManagerProjectDTO managerProject) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (insert(getManagerProjectsEntity(managerProject))) {
                map.put("Status", "added");
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
            map.put("Status", "existed");
        } catch (NotFoundException e) {
            log.error("Can not to add new project for manager with id: {}", managerProject.getManagerId());
            map.put("Status", "error");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ManagerProjectEntity getManagerProjectsEntity(ManagerProjectDTO managerProject) throws NotFoundException {
        ManagerProjectEntity managerProjects = new ManagerProjectEntity();
        managerProjects.setManager(userService.get(managerProject.getManagerId()));
        managerProjects.setProject(ProjectEntityFactory.create(managerProject));
        return managerProjects;
    }

}
