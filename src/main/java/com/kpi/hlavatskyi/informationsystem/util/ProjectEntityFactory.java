package com.kpi.hlavatskyi.informationsystem.util;

import com.kpi.hlavatskyi.informationsystem.entity.LocationEntity;
import com.kpi.hlavatskyi.informationsystem.entity.ProjectEntity;
import com.kpi.hlavatskyi.informationsystem.model.Location;
import com.kpi.hlavatskyi.informationsystem.model.Project;
import com.kpi.hlavatskyi.informationsystem.model.dto.CreatorProjectDTO;

public final class ProjectEntityFactory {

    public ProjectEntityFactory() {}

    public static ProjectEntity create(CreatorProjectDTO creatorProjectDTO) {
        ProjectEntity project = new ProjectEntity();
        project.setName(creatorProjectDTO.getName());
        project.setPrice(creatorProjectDTO.getPrice());
        project.setDate(creatorProjectDTO.getDate());
        project.setStatus(creatorProjectDTO.getStatus());
        project.setLocation(getLocationEntity(creatorProjectDTO));
        return project;
    }

    private static LocationEntity getLocationEntity(CreatorProjectDTO creatorProjectDTO) {
        LocationEntity location = new LocationEntity();
        location.setCountry(creatorProjectDTO.getCountry());
        location.setCity(creatorProjectDTO.getCity());
        location.setStreet(creatorProjectDTO.getStreet());
        location.setBuild(creatorProjectDTO.getBuild());
        return location;
    }

    public static ProjectEntity create(Project project) {
        return getProjectEntity(project);
    }

    private static ProjectEntity getProjectEntity(Project project) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(project.getName());
        projectEntity.setDate(project.getDate());
        projectEntity.setLocation(getLocationEntity(project));
        projectEntity.setStatus(project.getStatus());
        projectEntity.setPrice(project.getPrice());
        return projectEntity;
    }

    private static LocationEntity getLocationEntity(Project project) {
        LocationEntity locationEntity = new LocationEntity();
        Location location = project.getLocation();
        locationEntity.setCountry(location.getCountry());
        locationEntity.setCity(location.getCity());
        locationEntity.setStreet(location.getStreet());
        locationEntity.setBuild(location.getBuild());
        return locationEntity;
    }

}
