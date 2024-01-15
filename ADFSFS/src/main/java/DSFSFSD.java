@Test
    void naoDeveAdicionarPessoaInvalidaNaTurma() {
            // Arrange
            Pessoa pessoa = new Pessoa(1, "");

            // Act & Assert
            assertThrows(Exception.class, () -> turma.adicionarPessoas(pessoa), "Objeto pessoa inválido");
        assertTrue(turma.getPessoas().isEmpty());
        }

@Test
    void naoDeveAdicionarPessoaComIdDuplicadoNaTurma() throws Exception {
            // Arrange
            Pessoa pessoa1 = new Pessoa(1, "John Doe");
            Pessoa pessoa2 = new Pessoa(1, "Jane Doe");
            turma.adicionarPessoas(pessoa1);

            // Act & Assert
            Exception exception = assertThrows(Exception.class, () -> turma.adicionarPessoas(pessoa2));
        assertEquals("O objeto pessoas já está atribuído à turma", exception.getMessage());
        assertEquals(1, turma.getPessoas().size());
        }