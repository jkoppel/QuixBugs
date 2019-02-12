# QuixBugs Benchmark [![Build Status](https://travis-ci.org/jkoppel/QuixBugs.svg?branch=master)](https://travis-ci.org/jkoppel/QuixBugs) [![Coverage Status](https://coveralls.io/repos/github/jkoppel/QuixBugs/badge.svg?branch=master)](https://coveralls.io/repos/github/jkoppel/QuixBugs)

The QuixBugs benchmark consists of 40 programs from the Quixey Challenge translated into both Python and Java. Each contains a one-line defect, along with passing (when possible) and failing testcases. Defects fall into one of 14 defect classes. Corrected Python programs are also supplied. Quixbugs is intended for investigating cross-language performance by _multi-lingual_ program repair tools. 

For more details, see the ["QuixBugs: A Multi-Lingual Program Repair Benchmark Set Based on the Quixey Challenge"](quixbugs.pdf). Researchers at KTH have run 5 repair systems on the Java version of Quixbugs programs, see ["A Comprehensive Study of Automatic Program Repair on the QuixBugs Benchmark"](http://arxiv.org/pdf/1805.03454).

# Background: Quixey Challenge
From 2011 to 2013, mobile app search startup Quixey ran a challenge in which programmers were given an implementation of a classic algorithm with a bug on a single line, and had one minute to supply a fix. Success entailed $100 and a possible interview. These programs were developed as challenges for humans by people unaware of program repair.

# Installation & Usage
Simply clone the repo. 

    git clone https://github.com/jkoppel/QuixBugs
    
The Java programs are already compiled (see `*.class` files in `java_programs`). Note the all java programs are in the same package called `java_programs`. The utility class `JavaDeserialization.java` requires you to download the external library Gson.

All Python is written in Python3.

To run both defective versions of a program against their tests, as well as the corrected Python version, use the test driver:

> python3 tester.py _program\_name_

Output is printed for visual comparison.

# Structure & Details

The root folder holds the test driver. It deserializes the JSON testcases for a selected program, then runs them against the defective versions located in java\_programs/ and python\_programs/. The exception is graph-based programs, for which the testcases are located in the same folder as the corresponding program (they are still run with the test driver in the same manner).

For reference, corrected versions of the Python programs are in correct\_python\_programs/.

Programs include:
- bitcount
- breadth\_first\_search\*
- bucketsort
- depth\_first\_search\*
- detect\_cycle\*
- find\_first\_in\_sorted
- find\_in\_sorted
- flatten
- gcd
- get\_factors
- hanoi
- is\_valid\_parenthesization
- kheapsort
- knapsack
- kth
- lcs\_length
- levenshtein
- lis
- longest\_common\_subsequence
- max\_sublist\_sum
- mergesort
- minimum\_spanning\_tree\*
- next\_palindrome
- next\_permutation
- pascal
- possible\_change
- powerset
- quicksort
- reverse\_linked\_list\*
- rpn\_eval
- shortest\_path\_length\*
- shortest\_path\_lengths\*
- shortest\_paths\*
- shunting\_yard
- sieve
- sqrt
- subsequences
- to\_base
- topological\_ordering\*
- wrap

\* - graph-based algorithm

# To generate Junit test cases
- Run TestsGenerator and check the generated Junit test cases in the folder of java_testcases/junit folder

# Authors
Contact Derrick Lin @drrckln, Angela Chen @angchen, or James Koppel @jkoppel for questions.
