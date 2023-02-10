package com.annuaire.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {

    public static final String PHONE_BOOK_FILE_PATH = "C:\\Users\\cocci\\OneDrive\\Documents\\Cours_Tutos\\phonebook.txt";
    public static Scanner scanner = null;
    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille : ");
        String userFirstName = getUserInput("Entrez un prénom : ");
        String userPhoneNumber = getUserInput("Entrez un numéro de téléphone : ");

        Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);

        System.out.println(newContact.toString());

        File phoneBookFile = getOrCreatePhoneBookFile(PHONE_BOOK_FILE_PATH);

        appendContactToPhoneBook(phoneBookFile,newContact);

        scanner.close();
    }

    /**
     *
     * @param userRequest
     * @return
     */
    public static String getUserInput(String userRequest) {
        System.out.println(userRequest);
        /** nextLine() : fait attendre au scanner une entrée  utilisateur
         * tant que l'utilsateur n'a pas entré l'info et le scanner attend
         */
        return scanner.nextLine();
    }

    /**
     *
     * @param phoneBookFilePath
     * @return
     */

    public static File getOrCreatePhoneBookFile(String phoneBookFilePath) {
        // On prend un fichier
        File phoneBookFile = new File(phoneBookFilePath);
        // Si le fichier existe, on retourne le fichier
        if (phoneBookFile.exists()) {
            return phoneBookFile;
        }
        // S'il n'existe pas, on le crée
        try {
            phoneBookFile.createNewFile();
            System.out.println("Le fichier a été créé (" + phoneBookFilePath + ")");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param phoneBookFile
     * @param newContact
     * @return
     */

    public static Void appendContactToPhoneBook(File phoneBookFile, Contact newContact) {
        // try with ressources
        // Quand on met le bufferedWriter dans le try Java le clos automatique quand c'est fini
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true))){
            fileWriter.append(newContact.toString());
            fileWriter.append(System.lineSeparator());
            System.out.println("Contact ajouté");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
