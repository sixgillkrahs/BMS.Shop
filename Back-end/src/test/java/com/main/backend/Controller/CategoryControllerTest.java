package com.main.backend.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.backend.Domain.Dto.Categories.CategoryDto;
import com.main.backend.Domain.Dto.Categories.CreateUpdateCategoryDto;
import com.main.backend.Service.Service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;


@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private CreateUpdateCategoryDto createUpdateCategoryDto;
    private CategoryDto categoryDto;

    private static final Logger log = LoggerFactory.getLogger(CategoryControllerTest.class);

    @BeforeEach
    public void initData(){
        createUpdateCategoryDto = new CreateUpdateCategoryDto("Electronics", null, '1');
        categoryDto = new CategoryDto(UUID.fromString("bbc46efb-996f-4f54-86b1-8e818e958048"),"Electronics", null);
    }

    @Test
    void saveCategory() throws Exception {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(createUpdateCategoryDto);

        Mockito.when(categoryService.saveCategory(ArgumentMatchers.any())).thenReturn(categoryDto);

        //when
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/category/save")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result.id").value("bbc46efb-996f-4f54-86b1-8e818e958048"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result.name").value("Electronics"));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.result.parentId").value("null"))
    }

    @Test
    void getAll() throws Exception{
        //given
        Mockito.when(categoryService.getAllCategory()).thenReturn(List.of(categoryDto));

        //when
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/category/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result[0].id").value("bbc46efb-996f-4f54-86b1-8e818e958048"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result[0].name").value("Electronics"));
    }

    @Test
    void getCategoryById() throws Exception{
        //given
        Mockito.when(categoryService.getCategoryById(UUID.fromString("bbc46efb-996f-4f54-86b1-8e818e958048"))).thenReturn(categoryDto);

        //when
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/category/get/bbc46efb-996f-4f54-86b1-8e818e958048"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result.id").value("bbc46efb-996f-4f54-86b1-8e818e958048"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result.name").value("Electronics"));
    }

}
