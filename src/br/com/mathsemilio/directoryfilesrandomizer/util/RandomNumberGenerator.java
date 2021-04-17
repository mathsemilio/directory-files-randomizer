package br.com.mathsemilio.directoryfilesrandomizer.util;

import java.util.ArrayList;
import java.util.Collections;

public class RandomNumberGenerator {

    private final ArrayList<Integer> mUniqueNumbers = new ArrayList<>();

    private int currentIndex = 0;

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
            randomNumber = mUniqueNumbers.get(currentIndex);
            ++currentIndex;
        }

        return randomNumber;
    }
}