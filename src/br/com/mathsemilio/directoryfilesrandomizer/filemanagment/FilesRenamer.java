package br.com.mathsemilio.directoryfilesrandomizer.filemanagment;

import br.com.mathsemilio.directoryfilesrandomizer.messagesprinter.MessagesPrinter;
import br.com.mathsemilio.directoryfilesrandomizer.util.RandomNumberGenerator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FilesRenamer {

    private Path mPath;

    private RandomNumberGenerator mRandomNumberGenerator;

    public void setWorkingPath(String path) {
        mPath = Paths.get(path);
        mRandomNumberGenerator = new RandomNumberGenerator(getNumberOfFilesInDir());
        checkFilesNamesInDir();
    }

    private int getNumberOfFilesInDir() {
        return Objects.requireNonNull(new File(String.valueOf(mPath)).listFiles()).length;
    }

    private File[] getDirFiles() {
        return new File(String.valueOf(mPath)).listFiles();
    }

    private void checkFilesNamesInDir() {
        for (File file : getDirFiles()) {
            if (file.isFile()) {
                String firstFileNameChars = FileNameUtil.getFirstCharactersDelimitedByWhitespace(file.getName());
                if (FileNameUtil.containsNumbers(firstFileNameChars)) {
                    renameFilesThatStartsWithNumbers(file, firstFileNameChars);
                } else {
                    renameFilesThatDoesNotStartWithNumbers(file);
                }
            }
        }
    }

    private void renameFilesThatStartsWithNumbers(File file, String firstFileNameChars) {
        int randomNumber = mRandomNumberGenerator.getRandomNumber();

        String randomNumberWithSpacer = randomNumber + " -";
        String newFileName = file.getName().replaceFirst(firstFileNameChars, randomNumberWithSpacer);

        File renamedFile = new File(String.valueOf(mPath.resolve(newFileName)));

        if (file.renameTo(renamedFile))
            MessagesPrinter.printFileRenamedSuccessfullyMessage(newFileName);
        else
            MessagesPrinter.printErrorRenamingFileMessage(file.getName());
    }

    private void renameFilesThatDoesNotStartWithNumbers(File file) {
        int randomNumber = mRandomNumberGenerator.getRandomNumber();

        String newFileName = randomNumber + " - ".concat(file.getName());
        File renamedFile = new File(String.valueOf(mPath.resolve(newFileName)));

        if (file.renameTo(renamedFile))
            MessagesPrinter.printFileRenamedSuccessfullyMessage(newFileName);
        else
            MessagesPrinter.printErrorRenamingFileMessage(file.getName());
    }
}