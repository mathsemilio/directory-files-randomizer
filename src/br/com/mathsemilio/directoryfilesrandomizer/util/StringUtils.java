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

public class StringUtils {

    public static String getFirstCharactersFrom(String string) {
        return string.split(" ")[0];
    }

    public static String getFirstStringAfterSlashFrom(String string) {
        return string.split(" - ")[1];
    }

    public static boolean containsNumbers(String string) {
        boolean containsNumbers = false;

        for (char character : string.toCharArray())
            containsNumbers = Character.isDigit(character);

        return containsNumbers;
    }

    public static boolean containsSlash(String string) {
        return string.contains("-");
    }
}