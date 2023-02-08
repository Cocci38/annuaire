package com.annuaire.phonebook;

import java.util.Scanner;

public class PhoneBook {

    public static Scanner scanner = null;
    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille : ");
        String userFirstName = getUserInput("Entrez un prénom : ");
        String userPhoneNumber = getUserInput("Entrez un numéro de téléphone : ");

        System.out.println(userLastName);
        System.out.println(userFirstName);
        System.out.println(userPhoneNumber);

        scanner.close();
    }

    public static String getUserInput(String userRequest) {
        System.out.println(userRequest);
        /** nextLine() : fait attendre au scanner une entrée  utilisateur
         * tant que l'utilsateur n'a pas entré l'info et le scanner attend
         */
        return scanner.nextLine();
    }
}
