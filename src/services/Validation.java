package services;

import entities.User;
import exceptions.AlreadyExistedException;
import exceptions.InvalidLoginException;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Validation {
    private final List<User> userList = new ArrayList<>();

    public void signUp() {
        // recebe os dados
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("username: ");
            String user = sc.next();
            System.out.println("password: ");
            String password = sc.next();

            // verifica se o nome de usuário já existe na lista
            for (User x : userList) {
                if (x.getUsername().equals(user)) {
                    throw new InvalidLoginException();
                }
            }

            // adiciona o novo usuário à lista
            System.out.println("Usuário criado com sucesso.");
            User newUser = new User(user, password);
            userList.add(newUser);
        } catch (InvalidLoginException e) {
            System.out.println("Usuário já existe.");
        }
    }


    public void login() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("username: ");
            String userInput = sc.next();
            System.out.println("password: ");
            String passInput = sc.next();
            boolean encontrado = false;
            for (User x : userList) {
                if (x.getUsername().equals(userInput) && x.getPassword().equals(passInput)) {
                    System.out.println("Logado como " + x.getUsername());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                throw new InvalidLoginException();
            }
        } catch (InvalidLoginException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Somente caracteres normais e números são permitidos.");
        }
    }

    public void listUser() {
        int i = 0;
        for (User x : userList) {
            System.out.println("User #" + (i + 1) + ": " + x);
            i++;
        }
    }

}
