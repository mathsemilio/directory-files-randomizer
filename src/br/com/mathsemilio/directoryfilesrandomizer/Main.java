package br.com.mathsemilio.directoryfilesrandomizer;

import br.com.mathsemilio.directoryfilesrandomizer.filemanagment.FilesRenamer;
import br.com.mathsemilio.directoryfilesrandomizer.messagesprinter.MessagesPrinter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final FilesRenamer filesRenamer = new FilesRenamer();

        MessagesPrinter.printProgramHeader();
        MessagesPrinter.printPromptUserMessage();

        String userInput = getUserInput();

        if (userInput.equals("No"))
            System.exit(0);
        else
            filesRenamer.setWorkingPath(userInput);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        scanner.close();

        return userInput;
    }
}