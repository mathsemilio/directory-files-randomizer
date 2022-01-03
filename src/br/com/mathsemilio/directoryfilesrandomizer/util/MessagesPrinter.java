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

public class MessagesPrinter {

    public static void printProgramHeader() {
        System.out.println("//* -------------------------------------------------------------------------------- //*");
        System.out.println("//*                            Directory Files Randomizer                            //*");
        System.out.println("//*                                 by Matt Menezes                                  //*");
        System.out.println("//* -------------------------------------------------------------------------------- //*");
    }

    public static void printPromptUserMessage() {
        System.out.println("Please type the working path or \"No\" to exit.");
    }

    public static void printRenameFileSuccessMessage(String fileName) {
        System.out.println("File renamed to: " + fileName);
    }

    public static void printRenameFileErrorMessage(String fileName) {
        System.out.println("Error renaming: " + fileName);
    }
}
