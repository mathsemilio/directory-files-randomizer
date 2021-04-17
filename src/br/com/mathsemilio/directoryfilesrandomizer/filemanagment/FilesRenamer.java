/*
   Copyright 2021 Matt Menezes

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
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