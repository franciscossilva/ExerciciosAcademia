import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    @Test
    public void pessoaDeveSerValidaComIdENomeValidos() {
        // Arrange
        int id = 1;
        String nome = "John Doe";

        // Act
        Pessoa pessoa = new Pessoa(id, nome);
        boolean resultado = pessoa.valido();

        // Assert
        assertTrue(resultado, "A pessoa deve ser válida com ID positivo e nome não vazio.");
    }

    @Test
    public void pessoaNaoDeveSerValidaComIdNegativo() {
        // Arrange
        int id = -1;
        String nome = "Jane Doe";

        // Act
        Pessoa pessoa = new Pessoa(id, nome);
        boolean resultado = pessoa.valido();

        // Assert
        assertFalse(resultado, "A pessoa não deve ser válida com ID negativo.");
    }

    @Test
    public void pessoaNaoDeveSerValidaComNomeVazio() {
        // Arrange
        int id = 2;
        String nome = "";

        // Act
        Pessoa pessoa = new Pessoa(id, nome);
        boolean resultado = pessoa.valido();

        // Assert
        assertFalse(resultado, "A pessoa não deve ser válida com nome vazio.");
    }

    @Test
    public void pessoaNaoDeveSerValidaComIdENomeVazios() {
        // Arrange
        int id = 0;
        String nome = "";

        // Act
        Pessoa pessoa = new Pessoa(id, nome);
        boolean resultado = pessoa.valido();

        // Assert
        assertFalse(resultado, "A pessoa não deve ser válida com ID zero e nome vazio.");
    }
}
