    import Controller.ExercicioController;
    import Model.Exercicio;
    import Service.ExercicioService;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.boot.test.mock.mockito.MockBean;
    import org.springframework.http.MediaType;
    import org.springframework.test.context.junit4.SpringRunner;
    import org.springframework.test.web.servlet.MockMvc;

    import java.util.Arrays;
    import java.util.List;

    import static org.hamcrest.Matchers.hasSize;
    import static org.hamcrest.Matchers.is;
    import static org.mockito.ArgumentMatchers.any;
    import static org.mockito.Mockito.*;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

    @RunWith(SpringRunner.class)
    @WebMvcTest(ExercicioController.class)
    public class ExercicioControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ExercicioService exercicioService;

        @Test
        public void getAllExercicios_ReturnsListOfExercicios() throws Exception {
            List<Exercicio> exercicios = Arrays.asList(new Exercicio(1L, "Exercicio1"), new Exercicio(2L, "Exercicio2"));

            when(exercicioService.getAllExercicios()).thenReturn(exercicios);

            mockMvc.perform(get("/exercicios"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].nome", is("Exercicio1")))
                    .andExpect(jsonPath("$[1].nome", is("Exercicio2")));

            verify(exercicioService, times(1)).getAllExercicios();
            verifyNoMoreInteractions(exercicioService);
        }

        @Test
        public void getExercicioById_ReturnsExercicio() throws Exception {
            Exercicio exercicio = new Exercicio(1L, "Exercicio1");

            when(exercicioService.getExercicioById(1L)).thenReturn(exercicio);

            mockMvc.perform(get("/exercicios/1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.nome", is("Exercicio1")));

            verify(exercicioService, times(1)).getExercicioById(1L);
            verifyNoMoreInteractions(exercicioService);
        }

        @Test
        public void createExercicio_ReturnsCreatedExercicio() throws Exception {
            Exercicio exercicio = new Exercicio(1L, "Exercicio1");
            String jsonRequest = new ObjectMapper().writeValueAsString(exercicio);

            when(exercicioService.createExercicio(any(Exercicio.class))).thenReturn(exercicio);

            mockMvc.perform(post("/exercicios")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonRequest))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.nome", is("Exercicio1")));

            verify(exercicioService, times(1)).createExercicio(any(Exercicio.class));
            verifyNoMoreInteractions(exercicioService);
        }

        @Test
        public void deleteExercicio_ReturnsNoContent() throws Exception {
            mockMvc.perform(delete("/exercicios/1"))
                    .andExpect(status().isNoContent());

            verify(exercicioService, times(1)).deleteExercicio(1L);
            verifyNoMoreInteractions(exercicioService);
        }
    }
