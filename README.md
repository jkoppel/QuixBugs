# QuixBugs Benchmark
The QuixBugs benchmark consists of 40 programs from the Quixey Challenge translated into both Python and Java. Each contains a one-line defect, along with passing (when possible) and failing testcases. Defects fall into one of 14 defect classes. Corrected Python programs are also supplied. Quixbugs is intended for investigating cross-language performance by _multilingual_ program repair tools. For more details, see the [paper](quixbugs.pdf).

# Background: Quixey Challenge
From 2011 to 2013, mobile app search startup Quixey ran a challenge in which programmers were given an implementation of a classic algorithm with a bug on a single line, and had one minute to supply a fix. Success entailed $100 and a possible interview. These programs were developed as challenges for humans by people unaware of program repair.

# Installation & Usage
Simply clone the repo. Note: You must compile the Java programs from the root directory. All Python is written in Python3.

To run both defective versions of a program against their tests, use the test driver:

> python3 tester.py _program\_name_

# Structure

The root folder holds the test driver. It deserializes the JSON testcases for a selected program, then runs them against the defective versions located in java_programs/ and python_programs/. The exception is graph-based programs, for which the testcases are located in the same folder as the corresponding program (they are still run with the test driver in the same manner). Output is printed for visual comparison.

For reference, corrected versions of the Python programs are in correct_python_programs/.

Programs include:
- bitcount
- breadth_first_search\*
- bucketsort
- depth_first_search\*
- detect_cycle\*
- find_first_in_sorted
- find_in_sorted
- flatten
- gcd
- get_factors
- hanoi
- is_valid_parenthesization
- kheapsort
- knapsack
- kth
- lcs_length
- levenshtein
- lis
- longest_common_subsequence
- max_sublist_sum
- mergesort
- minimum_spanning_tree\*
- next_palindrome
- next_permutation
- pascal
- possible_change
- powerset
- quicksort
- reverse_linked_list\*
- rpn_eval
- shortest_path_length\*
- shortest_path_lengths\*
- shortest_paths\*
- shunting_yard
- sieve
- sqrt
- subsequences
- to_base
- topological_ordering\*
- wrap

\* - graph-based algorithm

# Authors
Contact Derrick Lin @drrckln, Angela Chen @angchen, or James Koppel @jkoppel for questions.
