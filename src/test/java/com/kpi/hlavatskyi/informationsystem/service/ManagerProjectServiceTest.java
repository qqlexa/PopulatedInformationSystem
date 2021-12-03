package com.kpi.hlavatskyi.informationsystem.service;

import com.kpi.hlavatskyi.informationsystem.model.dto.ManagerProjectDTO;
import com.kpi.hlavatskyi.informationsystem.repository.ManagerProjectRepository;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerProjectServiceTest {

    @Autowired
    private ManagerProjectService managerProjectsService;

    @MockBean
    private ManagerProjectRepository managerProjectsRepository;

    @MockBean
    private UserService userService;

    @Test
    public void addProject_ManagerProjectsEntity_CallAddProjectMethodWithManagerProjectsEntity() throws NotFoundException {
        ManagerProjectDTO managerProjectDTO = new ManagerProjectDTO();
        managerProjectDTO.setManagerId(1L);

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("Status", "added");

        ResponseEntity<Map<String, Object>> expectedResponseEntity =
                new ResponseEntity<>(expectedMap, HttpStatus.OK);

        ResponseEntity<Map<String, Object>> actualResponseEntity = managerProjectsService.addProject(managerProjectDTO);

        assertEquals(expectedResponseEntity, actualResponseEntity);

        verify(managerProjectsRepository, times(1)).save(ArgumentMatchers.any());
        verify(userService,  times(1)).get(1L);
    }

    @Test
    public void addProject_ManagerProjectsEntity_CallAddProjectMethodWithException() throws NotFoundException {
        ManagerProjectDTO managerProjectDTO = new ManagerProjectDTO();
        managerProjectDTO.setManagerId(1L);

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("Status", "error");

        ResponseEntity<Map<String, Object>> expectedResponseEntity =
                new ResponseEntity<>(expectedMap, HttpStatus.OK);

        when(userService.get(anyLong())).thenThrow(new NotFoundException(anyString()));

        ResponseEntity<Map<String, Object>> actualResponseEntity = managerProjectsService.addProject(managerProjectDTO);

        assertEquals(expectedResponseEntity, actualResponseEntity);

        verify(userService,  times(1)).get(1L);
        verify(managerProjectsRepository, times(0)).existsByProject(any());
    }

    @Test
    public void addProject_ManagerProjectsEntity_CallAddProjectMethodWithManagerProjectsEntityExisted()
            throws NotFoundException {
        ManagerProjectDTO managerProjectDTO = new ManagerProjectDTO();
        managerProjectDTO.setManagerId(1L);

        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("Status", "existed");

        ResponseEntity<Map<String, Object>> expectedResponseEntity =
                new ResponseEntity<>(expectedMap, HttpStatus.OK);

        when(managerProjectsRepository.existsByProject(any())).thenReturn(true);

        ResponseEntity<Map<String, Object>> actualResponseEntity = managerProjectsService.addProject(managerProjectDTO);

        assertEquals(expectedResponseEntity, actualResponseEntity);

        verify(userService,  times(1)).get(1L);
        verify(managerProjectsRepository, times(1)).existsByProject(any());
    }

}