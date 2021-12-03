package com.kpi.hlavatskyi.informationsystem.util;

import com.kpi.hlavatskyi.informationsystem.entity.LocationEntity;
import com.kpi.hlavatskyi.informationsystem.entity.RoomEntity;
import com.kpi.hlavatskyi.informationsystem.entity.ProjectEntity;
import com.kpi.hlavatskyi.informationsystem.model.Location;
import com.kpi.hlavatskyi.informationsystem.model.Room;
import com.kpi.hlavatskyi.informationsystem.model.Project;
import com.kpi.hlavatskyi.informationsystem.model.dto.ManagerProjectDTO;

public final class ProjectEntityFactory {

    public ProjectEntityFactory() {}

    public static ProjectEntity create(ManagerProjectDTO managerProjectDTO) {
        ProjectEntity project = new ProjectEntity();
        project.setName(managerProjectDTO.getName());
        project.setPrice(managerProjectDTO.getPrice());
        project.setDate(managerProjectDTO.getDate());
        project.setStatus(managerProjectDTO.getStatus());
        project.setLocation(getLocationEntity(managerProjectDTO));
        project.setRoom(getRoomEntity(managerProjectDTO));
        return project;
    }

    private static LocationEntity getLocationEntity(ManagerProjectDTO managerProjectDTO) {
        LocationEntity location = new LocationEntity();
        location.setCountry(managerProjectDTO.getCounty());
        location.setCity(managerProjectDTO.getCity());
        location.setStreet(managerProjectDTO.getStreet());
        location.setBuild(managerProjectDTO.getBuild());
        return location;
    }

    private static RoomEntity getRoomEntity(ManagerProjectDTO managerProjectDTO) {
        RoomEntity room = new RoomEntity();
        room.setName(managerProjectDTO.getRoomName());
        room.setNumberRows(managerProjectDTO.getNumberRows());
        room.setNumberSeats(managerProjectDTO.getNumberSeats());
        return room;
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
        projectEntity.setRoom(getRoomEntity(project));
        return projectEntity;
    }

    private static RoomEntity getRoomEntity(Project project) {
        RoomEntity roomEntity = new RoomEntity();
        Room room = project.getRoom();
        roomEntity.setName(room.getName());
        roomEntity.setNumberRows(room.getNumberRows());
        roomEntity.setNumberSeats(room.getNumberSeats());
        return roomEntity;
    }

    private static LocationEntity getLocationEntity(Project project) {
        LocationEntity locationEntity = new LocationEntity();
        Location location = project.getLocation();
        locationEntity.setCountry(location.getCounty());
        locationEntity.setCity(location.getCity());
        locationEntity.setStreet(location.getStreet());
        locationEntity.setBuild(location.getBuild());
        return locationEntity;
    }

}
