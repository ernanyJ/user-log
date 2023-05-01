package main;

import services.Validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class program {

    static Validation val = new Validation();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != 4) {
            try {
                System.out.println("Insira a opção: ");
                System.out.println("1 - REGISTRAR | 2 - LOGAR | 3 - Listar Usuários | 4 - Sair");
                op = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Apenas números são permitidos.");
                sc.next();
            }
            switch (op) {
                case 1 -> val.signUp();
                case 2 -> val.login();
                case 3 -> val.listUser();
                case 4 -> System.out.println("finalizando execução...");
                default -> System.out.println("opção inválida.");
            }
        }
    }
}