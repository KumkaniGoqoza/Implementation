package main.java.numbersummarizer;

import java.util.Collection;
//This file is my own manual testing of the methods. To test if they work and if they produce the required results
//I have no extensive experience with Java so I am using this file as a form of unit testing
//Writing up Maven based test units proved to be challenging and I wanted to implement it with my own knowledge
//Intead of AI, which at the moment is not sufficient enough. The rources I consulted would need me to spend more than just 7 days
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
        System.out.println("Expected: 1, 3, 6-8, 12-15, 21-24, 31");
        
    }
}
