package Biblioteca;

public class Usuario {
    private String nome;
    private int id;

    public  Usuario(String nome, int id) {
        this.setNome(nome);
        this.setId(id);
    }

    public void setNome(String nome) {
        if (nome != null && nome.matches("^[a-zA-Z\\p{L} ]+$")) {
            this.nome = nome;
        }else {
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    public void setId(int id) {
        if (id >= 0 ) {
            this.id = id;
        }
        else {
            throw new IllegalArgumentException("ID inválido");
        }
    }
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Id: %d%n", this.getNome(), this.getId());
    }

}
