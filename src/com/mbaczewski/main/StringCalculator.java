package com.mbaczewski.main;

/*
    opis zadania z podejściem TDD:
    http://osherove.com/tdd-kata-1/
*/

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        char delimiter;

        numbers = setDelimiter(numbers);
        numbers = numbers.replace("\n", ",");
        String[] arguments = numbers.split(",");
        int numbersCount = arguments.length;
        String negativeNumbers = containsNegativeNumbers(arguments, numbersCount);
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(negativeNumbers);
        }
        Integer result = 0;
        for (int index = 0; index < numbersCount; index++) {
            result += Integer.parseInt(arguments[index]);
        }
        return result;
    }

    private String containsNegativeNumbers(String[] arguments, int numbersCount) {
        String negativeNumbers = "";
        for (int index = 0; index < numbersCount; index++) {
            if (arguments[index].charAt(0) == '-'){
                negativeNumbers += arguments[index];
            }
        }
        return negativeNumbers;
    }

    private String setDelimiter(String numbers) {
        char delimiter;
        if (numbers.startsWith("//")){
            delimiter = numbers.charAt(2);
            numbers = numbers.substring(4);
            numbers = numbers.replace(delimiter, ',');
        }
        return numbers;
    }
}
