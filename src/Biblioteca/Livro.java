package Biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private boolean emprestado;

    public Livro(String titulo, String autor, int ano) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAno(ano);
        this.emprestado = false; // começa disponível
    }

    public void setTitulo(String titulo) {
        if (titulo != null && titulo.matches("^[\\p{L} '\\-]+$")) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("Titulo inválido");
        }
    }

    public void setAutor(String autor) {
        if (autor != null && autor.matches("^[\\p{L} '\\-]+$")) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("Autor inválido");
        }
    }

    public void setAno(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        if (ano >= 1808 && ano <= anoAtual) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Ano inválido");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    // 🔎 Métodos para controlar empréstimo
    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        this.emprestado = true;
    }

    public void devolver() {
        this.emprestado = false;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Ano: %d | Status: %s",
                getTitulo(), getAutor(), getAno(),
                emprestado ? "Emprestado" : "Disponível");
    }
}
