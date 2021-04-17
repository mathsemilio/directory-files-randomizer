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
package br.com.mathsemilio.directoryfilesrandomizer.util;

import java.util.ArrayList;
import java.util.Collections;

public class RandomNumberGenerator {

    private final ArrayList<Integer> mUniqueNumbers = new ArrayList<>();

    private int mCurrentIndex = 0;

    public RandomNumberGenerator(int upperBound) {
        generateRandomNumbers(upperBound);
    }

    private void generateRandomNumbers(int upperBound) {
        for (int i = 0; i < upperBound; i++) {
            mUniqueNumbers.add(i);
        }
        Collections.shuffle(mUniqueNumbers);
    }

    public int getRandomNumber() {
        int randomNumber = 0;

        if (!mUniqueNumbers.isEmpty()) {
            randomNumber = mUniqueNumbers.get(mCurrentIndex);
            ++mCurrentIndex;
        }

        return randomNumber;
    }
}