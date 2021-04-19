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

package br.com.mathsemilio.directoryfilesrandomizer.filemanagment;

import br.com.mathsemilio.directoryfilesrandomizer.messagesprinter.MessagesPrinter;
import br.com.mathsemilio.directoryfilesrandomizer.util.RandomNumberGenerator;
import br.com.mathsemilio.directoryfilesrandomizer.util.StringUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FilesRenamer {

    private Path currentPath;

    private RandomNumberGenerator randomNumberGenerator;

    public void setWorkingPath(String path) {
        currentPath = Paths.get(path);
        randomNumberGenerator = RandomNumberGenerator.withUpperBound(getNumberOfFilesInDir());
    }

    private int getNumberOfFilesInDir() {
        return Objects.requireNonNull(new File(String.valueOf(currentPath)).listFiles()).length;
    }

    private File[] getDirFiles() {
        return new File(String.valueOf(currentPath)).listFiles();
    }

    public void checkFilesNamesInDir() {
        for (File file : getDirFiles()) {
            if (file.isFile()) {
                String firstFileNameChars = StringUtil.getFirstCharactersFrom(file.getName());
                if (StringUtil.containsNumbers(firstFileNameChars))
                    renameFileThatStartWithNumbers(file, firstFileNameChars);
                else
                    renameFileThatDoesNotStartWithNumbers(file);
            }
        }
    }

    private void renameFileThatStartWithNumbers(File file, String firstFileChars) {
        final int randomNumber = randomNumberGenerator.getRandomNumber();

        final String randomNumberWithSlash = randomNumber + " -";

        String newFileName;
        File renamedFile;

        if (StringUtil.containsSlash(file.getName()))
            newFileName = randomNumberWithSlash.concat(StringUtil.chopFileName(file.getName()));
        else
            newFileName = file.getName().replaceFirst(firstFileChars, randomNumberWithSlash);

        renamedFile = new File(String.valueOf(currentPath.resolve(newFileName)));

        renameFile(file, renamedFile);
    }

    private void renameFileThatDoesNotStartWithNumbers(File file) {
        final int randomNumber = randomNumberGenerator.getRandomNumber();

        String newFileName = randomNumber + " - ".concat(file.getName());
        File renamedFile = new File(String.valueOf(currentPath.resolve(newFileName)));

        renameFile(file, renamedFile);
    }

    private void renameFile(File fileToBeRenamed, File renamedFile) {
        if (fileToBeRenamed.renameTo(renamedFile))
            MessagesPrinter.printFileRenamedSuccessfullyMessage(renamedFile.getName());
        else
            MessagesPrinter.printErrorRenamingFileMessage(fileToBeRenamed.getName());
    }
}