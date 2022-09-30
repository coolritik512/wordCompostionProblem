# wordCompositionProblem
Note : The code is in java so jdk will be required on your machine; 

Steps to Execute Code:
1. After downloading folder just open in any idle and run the j.java file.

Overview:
This program uses functions to do some moduler task and then produce a result.
It is similar to word break problem, which we can do by using variuous approaches by backtracking, DP, Trie data structure;
It is done by using Trie data structure for finding the compounded word quickly.

Approach
1. We insert all the words in trie data strucutre.
2. Then we iterate over all the words in file and check whether the word is compounded word or if yes we check for first and second longest word otherwise we move on to next word;
3. At last we print the word;

The Compounded Word function complexity is O(n^2);
For program it's complexity is O((m)*n^2);
where m = Number of words in list;
n=maximum length of a words;
