# Path Planning via Dijkstra and BFS - CSE 222/505

## Project Overview
[cite_start]This project, implements a path planning system to find feasible paths through grid-based maps[cite: 5]. [cite_start]The system converts text-based map data into graph structures to calculate paths from a starting coordinate to a goal coordinate while avoiding obstacles[cite: 7, 21].

## Problem Definition
* [cite_start]**Objective**: Find a feasible path from a starting point to an end point in each map[cite: 7, 9].
* [cite_start]**Map Representation**: Maps are $n \times n$ matrices where `0` represents unoccupied space and `1` (or `-1`) represents obstacles[cite: 17, 18, 20, 21].
* [cite_start]**Optimal Path**: The shortest path is considered optimal and yields extra credit, though any feasible path is acceptable[cite: 8, 10, 39].



## Technical Architecture

### 1. Data Structures
* [cite_start]**CSE222Map**: Reads input text files to store the start point, end point, and the $n \times n$ matrix[cite: 21, 123].
* [cite_start]**CSE222Graph**: Constructs a graph where nodes exist only for unoccupied (`0`) coordinates[cite: 50, 51, 124].
* [cite_start]**Inner Node Class**: Stores $(y, x)$ coordinates, adjacency lists (neighbors), and the path back to the origin[cite: 176, 177, 178].

### 2. Adjacency Logic
[cite_start]Nodes are connected if they are adjacent in any of the 8 directions[cite: 61]:
* [cite_start]**Cardinal**: $(y-1, x), (y+1, x), (y, x-1), (y, x+1)$[cite: 54, 55].
* [cite_start]**Diagonal**: $(y-1, x-1), (y-1, x+1), (y+1, x+1), (y+1, x-1)$[cite: 56, 57, 58].

### 3. Pathfinding Algorithms
* [cite_start]**Dijkstra’s Algorithm**: A weighted approach that finds a feasible path by exploring the smallest distance from the source[cite: 66, 125, 126].
* [cite_start]**Breadth-First Search (BFS)**: A queue-based approach that identifies nodes layer by layer to find a feasible path[cite: 95, 127, 128].

## Installation & Usage

### Compilation
[cite_start]Navigate to the source folder and compile the Java files[cite: 166]:
```bash
cd stdNO_hw8/homework8
javac *.java
