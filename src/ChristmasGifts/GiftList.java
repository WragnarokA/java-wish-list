package ChristmasGifts;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GiftList {
    public static void main(String[] args) {
        ArrayList<Gift> wishList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        loadWishList(wishList);

        boolean continueAdding = true;

        while (continueAdding) {
            System.out.print("Inserisci la descrizione del regalo: ");
            String description = scanner.nextLine();
            System.out.print("Chi è il destinatario? (mamma, sorella, amico, ...): ");
            String recipient = scanner.nextLine();

            Gift gift = new Gift(description, recipient);
            wishList.add(gift);

            System.out.print("Regalo aggiunto alla lista.");

            System.out.print("Vuoi continuare ad aggiungere nuovi regali? (sì/no): ");
            String input = scanner.nextLine();
            continueAdding = input.equalsIgnoreCase("sì");
        }

        // Mostra la lista dei desideri
        System.out.print("Lista dei desideri:");
        for (Gift gift : wishList) {
            System.out.print("Destinatario: " + gift.getRecipient() + ", Descrizione: " + gift.getDescription());
        }

        saveWishList(wishList);
    }

    private static void loadWishList(ArrayList<Gift> wishList) {
        try {
            FileInputStream fis = new FileInputStream("giftList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            wishList.addAll((ArrayList<Gift>) ois.readObject());
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Il file non esiste o si è verificato un errore durante il caricamento");
        }
    }

    private static void saveWishList(ArrayList<Gift> wishList) {
        try {
            FileOutputStream fos = new FileOutputStream("giftList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wishList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


