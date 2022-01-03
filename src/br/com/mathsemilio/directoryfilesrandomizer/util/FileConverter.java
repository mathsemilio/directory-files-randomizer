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

package br.com.mathsemilio.directoryfilesrandomizer.util;

import br.com.mathsemilio.directoryfilesrandomizer.domain.model.DirectoryFile;

import java.io.File;
import java.util.ArrayList;

public class FileConverter {

    public static ArrayList<DirectoryFile> convertFilesToDirectoryFiles(File[] files) {
        ArrayList<DirectoryFile> directoryFiles = new ArrayList<>();

        for (File file : files) {
            if (file.isFile())
                directoryFiles.add(new DirectoryFile(file.getName(), file.getPath()));
        }

        return directoryFiles;
    }

    public static File convertDirectoryFileToFile(DirectoryFile file) {
        return new File(file.getPath());
    }
}
