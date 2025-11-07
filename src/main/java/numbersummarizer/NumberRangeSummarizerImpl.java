package main.java.numbersummarizer;

import java.util.*;

//region Class Definition
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    /**
     * Collects numbers from a comma-delimited string, parses them into integers,
     * sorts them, and removes duplicates.
     *
     * @param input A comma-delimited string of numbers.
     * @return A sorted Collection of unique Integers. Returns an empty collection for null/empty input.
     */
    //region collect Method
    @Override
    public Collection<Integer> collect(String input) {
        //adding a check for null input
        if (input == null || input.trim().isEmpty()) {
            return new TreeSet<>(); // Returns an empty TreeSet in case input is null, 
        }
        // TreeSet chosen as the data structure because it does not allow duplicates
        Set<Integer> numbers = new TreeSet<>(); 
        String[] numberParts = input.split(","); //splitting with delimited comma
        for (String part : numberParts) {
            String trimmedPart = part.trim();// trimming out any whitespaces
            if (!trimmedPart.isEmpty()) {
                try {                       
                    numbers.add(Integer.parseInt(trimmedPart));
                } catch (NumberFormatException e) { 
                    
                    System.err.println("Warning: Skipping invalid number format: '" + trimmedPart + "'");
                }
            }
        }
        return numbers;
    }
    //endregion

    //region summarizeCollection Method
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        // Validation: Ensure no null elements are present in the collection
        if (input.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Input collection for summarization cannot contain null elements.");
        }

        // Using a List for indexed access. A TreeSet ensures numbers are sorted and unique.
        List<Integer> numbers = new ArrayList<>(new TreeSet<>(input));

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < numbers.size()) {
            //region Range Summarization Logic
            // The start of a potential range
            int rangeStart = numbers.get(i);

            // Find the end of the current sequential range
            int j = i;
            while (j + 1 < numbers.size() && numbers.get(j + 1) == numbers.get(j) + 1) {
                j++;
            }

            // The end of the range
            int rangeEnd = numbers.get(j);

            // Append comma and space if this is not the first element
            if (result.length() > 0) {
                result.append(", ");
            }

            // If rangeStart and rangeEnd are the same, it's a single number
            if (rangeStart == rangeEnd) {
                result.append(rangeStart);
            } else { // Otherwise, it's a range
                result.append(rangeStart).append("-").append(rangeEnd);
            }
            //endregion

            // Move the main index to the number after the processed range
            i = j + 1;
        }

        return result.toString();
    }
    //endregion
}
//endregion
