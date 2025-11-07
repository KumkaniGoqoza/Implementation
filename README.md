I recognise that my current knowledge of Java and its testing ecosystem is still developing. While I implemented the required functionality and outlined the full set of unit tests below of my solution is designed to satisfy, I was not able to deliver a complete, runnable test suite within the time constraints. I’m actively learning more about Java 8 and JUnit, and I’m committed to expanding my skills to deliver comprehensive, production-quality tests going forward.

Here is the full list of unit test cases for the implementation

collect(String input)

Null or empty input → empty collection

null → []

"" or " " → []

Trims and parses integers

" 1 , 2 , 3 " → [1, 2, 3]

Skips invalid tokens (lenient parsing)

"1,a,2, ,b" → [1, 2] (no exception)

De-duplicates and sorts

"3,1,2,2,3" → [1, 2, 3]

Supports negatives and zero

"-2,-1,0,1" → [-2, -1, 0, 1]

summarizeCollection(Collection<Integer> input)

Null or empty collection → empty string

null → ""

[] → ""

Throws when collection contains null

[1, null, 2] → throws IllegalArgumentException

Collapses simple range

[1, 2, 3] → "1-3"

Mixed singletons and ranges

[1, 3, 4, 5, 7, 10, 11, 12] → "1, 3-5, 7, 10-12"

Handles negatives cleanly

[-3, -2, -1, 0, 1, 5] → "-3-1, 5"

Gaps of one create separate ranges

[1, 2, 4, 5, 7] → "1-2, 4-5, 7"

Singleton between ranges

[1, 2, 4, 5, 6, 8] → "1-2, 4-6, 8"

Unsorted/duplicated input still summarizes correctly

[3, 1, 2, 2] → "1-3"

Formatting includes comma + space

[1, 3, 4] → "1, 3-4" (note the space after the comma)

End-to-end (collect → summarize)

Spec example

Input string: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"

Output: "1, 3, 6-8, 12-15, 21-24, 31"
