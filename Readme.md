
**Design  Steps  to Generate Trigrams :
**

Validate the input whether input is minimum 3 words.

Convert to lower case to compare each word and make sure input dont have numbers.

Split  the input with Empty space and iterate the data until the last value and store the data in Hashmap with key value where key is 2 words and value is 3rd word in an array in whole input.

Example : 

String input = "I wish I may I wish I might I try to crack program";

Output : 
i wish:[I, I]
i may:[I]
i might:[I]
to crack:[program]
wish i:[may, might]
might i:[try]
try to:[crack]
may i:[wish]
i try:[to]
