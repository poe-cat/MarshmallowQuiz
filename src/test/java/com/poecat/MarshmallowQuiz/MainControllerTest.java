package com.poecat.MarshmallowQuiz;

import com.poecat.MarshmallowQuiz.repo.QuestionRepo;
import com.poecat.MarshmallowQuiz.repo.ResultRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionRepo questionRepo;

    @MockBean
    private ResultRepo resultRepo;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(
                        containsString("Hi there! Life is difficult, isn't it?")));
    }
}
