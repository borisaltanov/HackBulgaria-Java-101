import java.io.*;

class FirstProblems {
    public static void main(String[] args) {
        System.out.println(isNumberOdd(8));
        System.out.println(isNumberPrime(97));
        System.out.println(factorialDigits(321));
        System.out.println(fibonacciSequence(8));
        System.out.println(reversed(123));
        System.out.println(isPalindrome(124421));
        System.out.println(reverseOddWords("This is the first lecture for Programming 101 with Java"));
        System.out.println(isSumPalindrome(123));
        System.out.println(sumOfDivisors(4,7));
        System.out.println(vowelsConsonantsDigits("It is 18th of Oct 2016"));
    }

    //task1
    public static boolean isNumberOdd(int number) {
        return number % 2 != 0;
    }

    //task2
    public static boolean isNumberPrime(int number) {
        for(int i = 2; i * i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //task3
    public static int factorial(int digit) {
        int result = 1;
        for (int i = 1; i <= digit; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorialDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += factorial(number % 10);
            number /= 10;
        }
        return sum;
    }

    //task4
    public static int fibonacciSequence(int number) {
        int fib1 = 1;
        int fib2 = 1;
        int result = 11;
        for (int i = 2; i < number; i++) {
            int next_fib = fib1 + fib2;
            if (next_fib > 10) {
                result = result * 100 + next_fib;
            } else {
                result = result * 10 + next_fib;
            }
            fib1 = fib2;
            fib2 = next_fib;
        }
        return result;
    }

    //task5
    public static int reversed(int number) {
        int reversed = 0;
        while (number > 0){
            reversed *= 10;
            reversed += number % 10;
            number /= 10;
        }
        return reversed;
    }

    public static boolean isPalindrome(int number) {
        int reversed = reversed(number);
        return number == reversed;
    }

    //task6
    public static String reverseWord(String word) {
        char [] reversed = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        char temp;
        while (start < end) {
            temp = reversed[start];
            reversed[start] = reversed[end];
            reversed[end] = temp;
            start++;
            end--;
        }
        return new String(reversed);
    }

    public static String reverseOddWords(String sentence) {
        String [] words = sentence.split(" ");
        for (int i = 1; i < words.length; i += 2) {
            words[i] = reverseWord(words[i]);
        }
        return String.join(" ", words);
    }

    //task7
    public static boolean isSumPalindrome(int number) {
        int reversed = reversed(number);
        int sum = number + reversed;
        return isPalindrome(sum);
    }

    //task8
    public static int divisors(int number) {
        int sum = 0;
        for (int i = 1; i < number + 1; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int sumOfDivisors(int numberA, int numberB) {
        int sum = 0;
        for (int i = numberA; i < numberB + 1; i++) {
            sum += divisors(i);
        }
        return sum;
    }

    //task9
    public static String [] vowelsConsonantsDigits(String sentence) {
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        String allVowels = "aoueiAOUEI";

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) >= '0' && sentence.charAt(i) <= '9') {
                digits++;
            }
            else if (sentence.charAt(i) != ' ') {
                if (allVowels.indexOf(sentence.charAt(i)) > 0) {
                    vowels++;
                } else {
                    consonants++;
                }
            }

        }
        System.out.println(vowels);
        System.out.println(consonants);
        System.out.println(digits);
        String [] result = new String [] {"Vowels :", "Consonants: ", "Digits: "};
        return result;
    }
}
