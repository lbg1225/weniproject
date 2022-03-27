package com.sample.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;    

@ExtendWith(MockitoExtension.class)

public class TestControllerTest {
    @InjectMocks    
    private TestController testController;

    private MockMvc mockMvc;
  
    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    

}
    