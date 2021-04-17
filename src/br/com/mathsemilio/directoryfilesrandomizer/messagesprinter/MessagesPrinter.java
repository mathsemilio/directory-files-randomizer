package br.com.mathsemilio.directoryfilesrandomizer.messagesprinter;

public class MessagesPrinter {

    public static void printProgramHeader() {
        System.out.println("//* -------------------------------------------------------------------------------- //*");
        System.out.println("//*                       Directory Files Randomizer                                 //*");
        System.out.println("//*                            by Matt Menezes                                       //*");
        System.out.println("//* -------------------------------------------------------------------------------- //*");
    }

    public static void printPromptUserMessage() {
        System.out.println("To start the program, please type the path that the program will be working on, or \"No\" to exit.");
    }

    public static void printFileRenamedSuccessfullyMessage(String newFileName) {
        System.out.println("File renamed to: " + newFileName + ".");
    }

    public static void printErrorRenamingFileMessage(String fileName) {
        System.out.println("Error renaming: " + fileName + ".");
    }
}