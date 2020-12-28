# Laboratory Exercise

### Requirements
The setup files provide:

* the Java classes `AdjListNode`, `Vertex` and `Graph`;
* a Java class `Main` containing a skeleton main method that includes some file handling statements;
* a test input file (`input.txt`).

### Input
A text file where:

* line 1 contains the number (_n_) of vertices in the graph;
* line _j_ for _j_ = 2, ..., _n_+1 contains row _j_ of the adjacency matrix (space-separated 0's and 1's).

### Output
A text file containing, for each _i_ (0 <= _i_ <= _n_-1), the parent of vertex _i_ in the breadth-first spanning forst found (if vertex _i_ is the root of a tree in this forest, then the parent of vertex _i_ should be vertex _i_ itself).

### Example

#### Input
```
8
0 0 0 0 0 1 0 1
0 0 0 0 0 0 0 1
0 0 0 0 0 0 1 0
0 0 0 0 1 0 1 0
0 0 0 1 0 0 1 0
1 0 0 0 0 0 0 1
0 0 1 1 1 0 0 0
1 1 0 0 0 1 0 0
```

#### Output
```
0 7 2 6 6 0 2 0
```