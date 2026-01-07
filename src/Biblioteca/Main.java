package  Biblioteca;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Integer, Usuario> usuario = new HashMap<>();
        Map<String, Livro> livros = new HashMap<>();

        List<Emprestimo> emprestimos = new ArrayList<>();

        while (true) {
            System.out.print("\n--- Biblioteca Java ---\n");
            System.out.println("1- Adicionar um novo livro. ");
            System.out.println("2- Listar todos os livros cadastrados. ");
            System.out.println("3- Adicionar um novo usuário. ");
            System.out.println("4- Listar todos os usuarios cadastrados. ");
            System.out.println("5- Emprestar um livro para um usuario. ");
            System.out.println("6- Delvolver um livro. ");
            System.out.println("7- Sair dp programa. ");
            System.out.print("->");
            int opcao = input.nextInt();
            input.nextLine();
            if (opcao == 7) {
                System.out.print("Finalizando Biblioteca Java. ");
                break;
            }

            switch (opcao) {
                case 1:
                    while (true) {
                        try {
                            System.out.print("Digite o nome do livro: ");
                            String nomeLivro = input.nextLine();

                            System.out.print("Digite o autor do livro: ");
                            String autorLivro = input.nextLine();

                            System.out.print("Digite o ano do livro: ");
                            int anoLivro = input.nextInt();
                            input.nextLine();

                            Livro l = new Livro(nomeLivro, autorLivro, anoLivro);
                            livros.put(l.getTitulo(), l);

                            System.out.println("Livro adicionado com sucesso!");

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas números para o ano. ");
                            input.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro " + e.getMessage());
                        }
                    }
                    break;

                case 2:
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro foi adicionado ao sistema!");
                    } else {
                        System.out.println("--- Lista de Livros ---");
                        for (Livro l : livros.values()) {
                            System.out.println(l);
                        }
                    }
                    break;

                case 3:
                    int id = 0;
                    String nome = "";
                    while (true) {
                        try {
                            System.out.print("Digite um id para o usuario: ");
                            id = input.nextInt();
                            input.nextLine();

                            System.out.print("Digite o nome do usuario: ");
                            nome = input.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas números para no ID! ");
                            input.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro " + e.getMessage());
                        }
                    }
                    if (!usuario.containsKey(id)) {
                        Usuario p = new Usuario(nome, id);
                        usuario.put(p.getId(), p);
                    }

                    System.out.printf("Usuario %s adicionado com sucesso!\n", nome);
                    break;

                case 4:
                    if (usuario.isEmpty()) {
                        System.out.println("Nenhum usuário foi adicionado ao sistema!");
                    } else {
                        System.out.println("--- Lista de Usuários ---");
                        for (Usuario u : usuario.values()) {
                            System.out.println(u);
                        }
                    }
                    break;
                case 5:

                    if (usuario.isEmpty()) {
                        System.out.println("Nenhum usuario foi adicionado ao sistema!");
                        break;
                    }
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro foi adicionado ao sistema!");
                        break;
                    }

                    while (true) {
                        try{
                            System.out.println("Digite o ID do usuario: ");
                            int idUsuario = input.nextInt();
                            input.nextLine();

                            System.out.println("Digite o título do livro: ");
                            String tituloLivro = input.nextLine();

                            Usuario u = usuario.get(idUsuario);
                            Livro l = livros.get(tituloLivro);

                            if (u == null) {
                                System.out.println("Usuario não encontrado! ");
                            } else if (l == null) {
                                System.out.println("Livro não encontrado no sistema! ");
                            } else if (l.isEmprestado()) {
                                System.out.println("Livro já está emprestado! ");
                            } else {
                                Emprestimo e = new Emprestimo(u, l);
                                emprestimos.add(e);
                                l.emprestar();
                                System.out.printf("Livro %s Emprestado com sucesso! \n", l.getTitulo());
                                break;
                            }
                            }catch (InputMismatchException e) {
                            System.out.println("Erro digite apenas números para o ID! ");
                            input.nextLine();
                        }
                    }
                    break;
                case 6:
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro foi adicionado ao sistema! ");
                        break;
                    }

                    while (true) {
                        System.out.println("Digite o título do livro: ");
                        String tituloLivrod = input.nextLine();

                        Livro li = livros.get(tituloLivrod);

                        if (li == null) {
                            System.out.println("Livro não encontrado no sistema! Tente novamente.");
                        } else if (!li.isEmprestado()) {
                            System.out.println("Esse livro não está emprestado! Tente novamente.");
                        } else {
                            for (Emprestimo e : emprestimos) {
                                if (e.isAtivo() && e.getLivro().equals(li)) {
                                    e.devolver();
                                    li.devolver();
                                    System.out.printf("Livro '%s' devolvido com sucesso!\n", li.getTitulo());
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Digite um número entre 1 e 7. ");
                    break;

        }
    }
}
}

