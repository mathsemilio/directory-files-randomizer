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
package br.com.mathsemilio.directoryfilesrandomizer.messagesprinter;

public class MessagesPrinter {

    public static void printProgramHeader() {
        System.out.println("//* -------------------------------------------------------------------------------- //*");
        System.out.println("//*                       Directory Files Randomizer                                 //*");
        System.out.println("//*                            by Matt Menezes                                       //*");
        System.out.println("//* -------------------------------------------------------------------------------- //*");
    }

    public static void printPromptUserMessage() {
        System.out.println("To start the program, please type the path that the program will be working on, or \"No\" to exit.");
    }

    public static void printFileRenamedSuccessfullyMessage(String newFileName) {
        System.out.println("File renamed to: " + newFileName + ".");
    }

    public static void printErrorRenamingFileMessage(String fileName) {
        System.out.println("Error renaming: " + fileName + ".");
    }
}