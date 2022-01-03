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

package br.com.mathsemilio.directoryfilesrandomizer.filesystem.directoryfilesmanager;

import br.com.mathsemilio.directoryfilesrandomizer.util.FileConverter;
import br.com.mathsemilio.directoryfilesrandomizer.domain.model.DirectoryFile;

import java.util.*;
import java.io.File;
import java.nio.file.*;

public class DirectoryFilesManager {

    private final Path path;
    private final String parsedPath;

    public static DirectoryFilesManager forDirectoryAt(String path) {
        return new DirectoryFilesManager(path);
    }

    private DirectoryFilesManager(String directoryPath) {
        path = Paths.get(directoryPath);
        parsedPath = String.valueOf(Paths.get(directoryPath));
    }

    public ArrayList<DirectoryFile> getFiles() {
        return FileConverter.convertFilesToDirectoryFiles(
                Objects.requireNonNull(new File(parsedPath).listFiles())
        );
    }

    public int getNumberOfFiles() {
        return getFiles().size();
    }

    public RenameFileResult rename(DirectoryFile file, String newFileName) {
        File fileToBeRenamed = FileConverter.convertDirectoryFileToFile(file);
        File renamedFile = new File(String.valueOf(path.resolve(newFileName)));

        boolean wasFileRenamed = fileToBeRenamed.renameTo(renamedFile);

        if (wasFileRenamed) {
            return new RenameFileResult.FileRenamedSuccessfully(renamedFile.getName());
        } else {
            return new RenameFileResult.RenameFileFailed(fileToBeRenamed.getName());
        }
    }
}
