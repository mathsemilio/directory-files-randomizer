package br.com.mathsemilio.directoryfilesrandomizer.filemanagment;

public class FileNameUtil {

    public static String getFirstCharactersDelimitedByWhitespace(String s) {
        return s.split(" ")[0];
    }

    public static boolean containsNumbers(String s) {
        boolean containsNumbers = false;

        for (Character c : s.toCharArray()) {
            containsNumbers = Character.isDigit(c);
        }

        return containsNumbers;
    }
}