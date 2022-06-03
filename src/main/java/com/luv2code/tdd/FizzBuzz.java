package com.luv2code.tdd;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    public String compute(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return FIZZBUZZ;
        }
        else if (number % 3 == 0) {
            return FIZZ;
        }
        else if (number % 5 == 0) {
            return BUZZ;
        }
        return String.valueOf(number);
    }

}
