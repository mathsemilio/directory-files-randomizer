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

package br.com.mathsemilio.directoryfilesrandomizer.filesystem;

import br.com.mathsemilio.directoryfilesrandomizer.util.*;
import br.com.mathsemilio.directoryfilesrandomizer.domain.model.DirectoryFile;
import br.com.mathsemilio.directoryfilesrandomizer.filesystem.directoryfilesmanager.*;

import static br.com.mathsemilio.directoryfilesrandomizer.filesystem.directoryfilesmanager.RenameFileResult.*;

public class FilesRenamer {

    private DirectoryFile file;

    private final DirectoryFilesManager manager;
    private final UniqueRandomNumberGenerator numberGenerator;

    public static FilesRenamer forPath(String path) {
        return new FilesRenamer(path);
    }

    private FilesRenamer(String path) {
        manager = DirectoryFilesManager.forDirectoryAt(path);
        numberGenerator = UniqueRandomNumberGenerator.withUpperBound(manager.getNumberOfFiles());
    }

    public void start() {
        for (DirectoryFile file : manager.getFiles()) {
            this.file = file;
            inspectFileName();
        }
    }

    private void inspectFileName() {
        if (FilenameUtil.containsNumbers(file.getName())) {
            renameFileThatStartsWithNumbers();
        } else
            renameFile(FilenameUtil.buildPrefixWith(numberGenerator.getRandomNumber()).concat(file.getName()));
    }

    private void renameFileThatStartsWithNumbers() {
        String newFileName;

        if (!FilenameUtil.containsHyphen(file.getName()))
            newFileName = FilenameUtil.buildPrefixWith(numberGenerator.getRandomNumber()).concat(file.getName());
        else
            newFileName = file.getName().replaceFirst(
                    FilenameUtil.getPrefixBeforeBackspace(file.getName()),
                    String.valueOf(numberGenerator.getRandomNumber())
            );

        renameFile(newFileName);
    }

    private void renameFile(String newFileName) {
        handleRenameFileResult(manager.rename(file, newFileName));
    }

    private void handleRenameFileResult(RenameFileResult result) {
        if (result instanceof FileRenamedSuccessfully)
            MessagesPrinter.printRenameFileSuccessMessage(result.getFileName());
        else if (result instanceof RenameFileFailed)
            MessagesPrinter.printRenameFileErrorMessage(result.getFileName());
    }
}
