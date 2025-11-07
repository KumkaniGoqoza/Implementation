package main.java.numbersummarizer;

import java.util.Collection;
//This file is for my own manual testing of the methods. To test if they work and if they produce the required results
public class Main {

    public static void main(String[] args) {
        // 1. Instantiating implementation
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

        // 2. Define the sample input string
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        System.out.println("Input: " + input);

        // 3. Caling  the collect method
        Collection<Integer> numbers = summarizer.collect(input);

        // 4. Calling the summarizeCollection method and print the result
        String summary = summarizer.summarizeCollection(numbers);
        System.out.println("Result: " + summary);
        
    }
}