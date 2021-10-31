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

public class UniqueRandomNumberGenerator {

    public static UniqueRandomNumberGenerator withUpperBound(int upperBound) {
        return new UniqueRandomNumberGenerator(upperBound);
    }

    private UniqueRandomNumberGenerator(int upperBound) {
        this.upperBound = upperBound;
        generateRandomNumbers();
    }

    private final ArrayList<Integer> numbers = new ArrayList<>();

    private final int upperBound;

    private int numbersIndex = 0;

    private void generateRandomNumbers() {
        for (int i = 0; i < upperBound; i++)
            numbers.add(i);

        Collections.shuffle(numbers);
    }

    public int getUniqueRandomNumber() {
        int randomNumber;

        randomNumber = numbers.get(numbersIndex);
        ++numbersIndex;

        return randomNumber;
    }
}