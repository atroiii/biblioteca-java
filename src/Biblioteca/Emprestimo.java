package Biblioteca;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
        this.ativo = false;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Livro getLivro() {
        return livro;
    }

    @Override
    public String toString() {
        return "Usuario: " + this.usuario.getNome() +
                " | Livro: " + this.livro.getTitulo()+
                " | Data de Emprestimo: " + this.dataEmprestimo+
                (ativo ?" | Status: Ativo":" | Devolvido em: " + this.dataDevolucao);
    }
}


