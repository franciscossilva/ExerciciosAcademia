package ModelTest;

import Model.Exercicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExercicioTest {

    private Exercicio exercicio;

    @BeforeEach
    public void setUp() {
        exercicio = new Exercicio();
    }

    @Test
    public void testGetAndSetId() {
        // Arrange (preparação)
        Long id = 1L;

        // Act (Ação)
        exercicio.setId(id);
        Long result = exercicio.getId();

        // Assert (validação)
        assertNotNull(result, "O resultado não deve ser nulo");
        assertEquals(id, result, "Os IDs devem ser iguais");
    }

    @Test
    public void testGetAndSetNome() {
        // Arrange (preparação)
        String nome = "Teste";

        // Act (Ação)
        exercicio.setNome(nome);
        String result = exercicio.getNome();

        // Assert (validação)
        assertNotNull(result, "O resultado não deve ser nulo");
        assertEquals(nome, result, "Os nomes devem ser iguais");
    }

    @Test
    public void testGetAndSetDescricao() {
        // Arrange
        String descricao = "Descrição do teste";

        // Act
        exercicio.setDescricao(descricao);
        String result = exercicio.getDescricao();

        // Assert
        assertNotNull(result, "O resultado não deve ser nulo");
        assertEquals(descricao, result, "As descrições devem ser iguais");
    }

    @Test
    public void testGetAndSetDiaDaSemana() {
        // Arrange
        String diaDaSemana = "Segunda-feira";

        // Act
        exercicio.setDiaDaSemana(diaDaSemana);
        String result = exercicio.getDiaDaSemana();

        // Assert
        assertNotNull(result, "O resultado não pode ser nulo");
        assertEquals(diaDaSemana, result, "Os dias da semana devem ser iguais");
    }
}
