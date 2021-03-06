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

package br.com.mathsemilio.directoryfilesrandomizer;

import br.com.mathsemilio.directoryfilesrandomizer.util.MessagesPrinter;
import br.com.mathsemilio.directoryfilesrandomizer.filesystem.FilesRenamer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MessagesPrinter.printProgramHeader();
        MessagesPrinter.printPromptUserMessage();

        String userInput = getUserInput();

        if (userInput.equals("No")) {
            System.exit(1);
        } else {
            FilesRenamer filesRenamer = FilesRenamer.forPath(userInput);
            filesRenamer.start();
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }
}
