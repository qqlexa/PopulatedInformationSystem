package com.kpi.hlavatskyi.informationsystem.service;

import com.kpi.hlavatskyi.informationsystem.entity.ProjectEntity;
import com.kpi.hlavatskyi.informationsystem.model.Location;
import com.kpi.hlavatskyi.informationsystem.model.Room;
import com.kpi.hlavatskyi.informationsystem.model.Project;
import com.kpi.hlavatskyi.informationsystem.model.ProjectStatus;
import com.kpi.hlavatskyi.informationsystem.repository.ProjectRepository;
import com.kpi.hlavatskyi.informationsystem.util.ProjectEntityFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;

    @Test
    public void insertSuccessful() {
        Project project = new Project();
        project.setName("Test project");
        project.setPrice(150.0);
        Date date = new Date(System.currentTimeMillis());
        project.setDate(date);
        project.setLocation(new Location("Country", "City", "Street", "Build"));
        project.setRoom(new Room("First room",20, 30));
        project.setStatus(ProjectStatus.NOT_CONFIRMED.toString());

        ProjectEntity projectEntity = ProjectEntityFactory.create(project);

        boolean isProjectCreated = projectService.insert(projectEntity);

        assertTrue(isProjectCreated);

        Mockito.verify(projectRepository, Mockito.times(1)).save(projectEntity);
    }

}