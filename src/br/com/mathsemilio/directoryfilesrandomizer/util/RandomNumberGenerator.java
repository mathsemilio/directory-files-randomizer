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

import java.util.ArrayList;
import java.util.Collections;

public class RandomNumberGenerator {

    public static RandomNumberGenerator withUpperBound(int upperBound) {
        return new RandomNumberGenerator(upperBound);
    }

    private RandomNumberGenerator(int upperBound) {
        generateRandomNumbers(upperBound);
    }

    private final ArrayList<Integer> uniqueNumbers = new ArrayList<>();

    private int currentUniqueNumbersIndex = 0;

    private void generateRandomNumbers(int upperBound) {
        for (int i = 0; i < upperBound; i++) {
            uniqueNumbers.add(i);
        }
        Collections.shuffle(uniqueNumbers);
    }

    public int getRandomNumber() {
        int randomNumber = 0;

        if (!uniqueNumbers.isEmpty()) {
            randomNumber = uniqueNumbers.get(currentUniqueNumbersIndex);
            ++currentUniqueNumbersIndex;
        }

        return randomNumber;
    }
}