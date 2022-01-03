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

public class FilenameUtil {

    public static String buildPrefixWith(int fileNumber) {
        return fileNumber + " - ";
    }

    public static String getPrefixBeforeBackspace(String fileName) {
        return fileName.split(" ")[0];
    }

    public static boolean containsHyphen(String fileName) {
        return fileName.contains("-");
    }

    public static boolean containsNumbers(String fileName) {
        boolean containsNumbers = false;

        for (char character : fileName.toCharArray()) {
            if (Character.isDigit(character)) {
                containsNumbers = true;
                break;
            }
        }

        return containsNumbers;
    }
}
