/*
Copyright 2021 Matheus Menezes

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

package br.com.mathsemilio.directoryfilesrandomizer.filesrenamer;

import br.com.mathsemilio.directoryfilesrandomizer.messagesprinter.MessagesPrinter;
import br.com.mathsemilio.directoryfilesrandomizer.util.StringUtils;
import br.com.mathsemilio.directoryfilesrandomizer.util.UniqueRandomNumberGenerator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FilesRenamer {

    private File file;
    private final Path path;
    private final UniqueRandomNumberGenerator uniqueRandomNumberGenerator;

    public static FilesRenamer forPath(String path) {
        return new FilesRenamer(Paths.get(path));
    }

    private FilesRenamer(Path path) {
        this.path = path;
        uniqueRandomNumberGenerator = UniqueRandomNumberGenerator.withUpperBound(getNumberOfFilesInDirectory());
    }

    private int getNumberOfFilesInDirectory() {
        return Objects.requireNonNull(new File(String.valueOf(path)).listFiles()).length;
    }

    public void inspectFileNamesInDirectory() {
        for (File file : getFilesInDirectory()) {
            if (file.isFile()) {
                this.file = file;

                if (StringUtils.containsNumbers(file.getName()))
                    handleFilesThatStartsWithNumbers();
                else
                    handleFilesThatDoesNotStartWithNumbers();
            }
        }
    }

    private File[] getFilesInDirectory() {
        return new File(String.valueOf(path)).listFiles();
    }

    private void handleFilesThatStartsWithNumbers() {
        final int randomNumber = uniqueRandomNumberGenerator.getUniqueRandomNumber();
        final String firstCharactersFromFilename = StringUtils.getFirstCharactersFrom(file.getName());

        String randomNumberWithSlash = randomNumber + " - ";

        String newFileName;
        File renamedFile;

        if (StringUtils.containsSlash(file.getName()))
            newFileName = randomNumberWithSlash.concat(StringUtils.getFirstStringAfterSlashFrom(file.getName()));
        else
            newFileName = file.getName().replaceFirst(firstCharactersFromFilename, randomNumberWithSlash);

        renamedFile = new File(String.valueOf(path.resolve(newFileName)));
        renameFile(file, renamedFile);
    }

    private void renameFile(File fileToBeRenamed, File renamedFile) {
        boolean wasFileRenamedSuccessfully = fileToBeRenamed.renameTo(renamedFile);

        if (wasFileRenamedSuccessfully)
            MessagesPrinter.printFileRenamedSuccessfullyMessage(renamedFile.getName());
        else
            MessagesPrinter.printErrorRenamingFileMessage(fileToBeRenamed.getName());
    }

    private void handleFilesThatDoesNotStartWithNumbers() {
        final int randomNumber = uniqueRandomNumberGenerator.getUniqueRandomNumber();

        String fileName = randomNumber + " - ".concat(file.getName());
        File renamedFile = new File(String.valueOf(path.resolve(fileName)));

        renameFile(file, renamedFile);
    }
}