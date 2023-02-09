package com.annuaire.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {

    public static Scanner scanner = null;
    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille : ");
        String userFirstName = getUserInput("Entrez un prénom : ");
        String userPhoneNumber = getUserInput("Entrez un numéro de téléphone : ");

        Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);

        System.out.println(newContact.toString());

        File phoneBookFile = new File("C:\\Users\\cocci\\OneDrive\\Documents\\Cours_Tutos\\phonebook.txt");

        if (phoneBookFile.exists()) {
            System.out.println("Le fichier existe à cette emplacement");
        } else {
            System.out.println("Le fichier n'existe pas");
        }

        try {
            // TODO : use try with resources
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true));
            fileWriter.append(newContact.toString() + '\n');
            System.out.println("Contact ajouté");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
