# Assessed Exercise
The purpose of the exercise is to write, in Java, programs to investigate word ladders composed of five letter words. A word ladder is a sequence of words, each member of the sequence differing from its predecessor in exactly one position. For example, the following ladder, of length 6, 'transforms' the word _flour_ into the word _bread_:

```
flour -> floor -> flood -> blood -> brood -> broad -> bread
```

A dictionary file `words5.txt` will be provided, which contains a set of nearly 2000 five-letter words that should be used to construct ladders.

## Program 1
The first program should read in a dictionary file, together with two more five letter words, i.e. the program should take 3 command-line arguments:

1. a dictionary file;
2. a start word;
3. an end word.

The program should produce on the standard output channel the length of the shortest path and a path/ladder of shortest length that transforms the start word into the end word, or should report that no ladder is possible. The final line of output should report the execution time of the program in seconds.

## Program 2
The second program considers a weighted version of the word ladder problem where the weight of a transformation (i.e. edge of the corresponding graph) is the absolute difference in the positions of the alphabet of the non-matching letter. For example, the weight of the edge between _angel_ and _anger_ equals the position of _r_ minus the position of _l_ which is 6.

This second program should implement Dijkstra's algorithm for finding the shortest paths. Similarly to the first case, the program should read in a dictionary file, together with two more five letter words the program and report on the standard output channel the minimum distance between the words together with a corresponding path, or should report that no ladder is possible.