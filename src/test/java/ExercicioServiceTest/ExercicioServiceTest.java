
package ExercicioServiceTest;

import Model.Exercicio;
import Repository.ExercicioRepository;
import Service.ExercicioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class ExercicioServiceTest {

    @Mock
    private ExercicioRepository exercicioRepository;

    @InjectMocks
    private ExercicioService exercicioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllExercises_ShouldReturnListOfExercises() {
        // Arrange
        when(exercicioRepository.findAll()).thenReturn(Collections.singletonList(new Exercicio()));

        // Act
        List<Exercicio> result = exercicioService.getAllExercicios();

        // Assert
        assertEquals(1, result.size());
        verify(exercicioRepository, times(1)).findAll();
    }

    @Test
    void getExerciseById_ExistingId_ShouldReturnExercise() {
        // Arrange
        long id = 1L;
        Exercicio exercise = new Exercicio();
        when(exercicioRepository.findById(id)).thenReturn(Optional.of(exercise));

        // Act
        Exercicio result = exercicioService.getExercicioById(id);

        // Assert
        assertEquals(exercise, result);
        verify(exercicioRepository, times(1)).findById(id);
    }

    @Test
    void getExerciseById_NonExistingId_ShouldReturnNull() {
        // Arrange
        long id = 1L;
        when(exercicioRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Exercicio result = exercicioService.getExercicioById(id);

        // Assert
        assertNull(result);
        verify(exercicioRepository, times(1)).findById(id);
    }

}
