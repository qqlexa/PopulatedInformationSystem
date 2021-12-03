package com.kpi.hlavatskyi.informationsystem.service;

import com.kpi.hlavatskyi.informationsystem.repository.ProjectRepository;
import com.kpi.hlavatskyi.informationsystem.entity.ProjectEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean insert(ProjectEntity project) {
        if (projectRepository.existsByNameAndDate(project.getName(), project.getDate())) {
            return false;
        }
        projectRepository.save(project);
        return true;
    }

}
