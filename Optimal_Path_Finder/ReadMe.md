
## Project Overview
This project, implements a path planning system to find feasible paths through grid-based maps[cite: 5]. The system converts text-based map data into graph structures to calculate paths from a starting coordinate to a goal coordinate while avoiding obstacles[cite: 7, 21].

## Problem Definition
* **Objective**: Find a feasible path from a starting point to an end point in each map[cite: 7, 9].
* **Map Representation**: Maps are $n \times n$ matrices where `0` represents unoccupied space and `1` (or `-1`) represents obstacles[cite: 17, 18, 20, 21].
* **Optimal Path**: The shortest path is considered optimal and yields extra credit, though any feasible path is acceptable[cite: 8, 10, 39].



## Technical Architecture

### 1. Data Structures
* **CSE222Map**: Reads input text files to store the start point, end point, and the $n \times n$ matrix[cite: 21, 123].
* **CSE222Graph**: Constructs a graph where nodes exist only for unoccupied (`0`) coordinates[cite: 50, 51, 124].
* **Inner Node Class**: Stores $(y, x)$ coordinates, adjacency lists (neighbors), and the path back to the origin[cite: 176, 177, 178].

### 2. Adjacency Logic
Nodes are connected if they are adjacent in any of the 8 directions[cite: 61]:
* **Cardinal**: $(y-1, x), (y+1, x), (y, x-1), (y, x+1)$[cite: 54, 55].
* **Diagonal**: $(y-1, x-1), (y-1, x+1), (y+1, x+1), (y+1, x-1)$[cite: 56, 57, 58].

### 3. Pathfinding Algorithms
* **Dijkstra’s Algorithm**: A weighted approach that finds a feasible path by exploring the smallest distance from the source[cite: 66, 125, 126].
* **Breadth-First Search (BFS)**: A queue-based approach that identifies nodes layer by layer to find a feasible path[cite: 95, 127, 128].

## Installation & Usage

### Compilation
Navigate to the source folder and compile the Java files[cite: 166]:
```bash
cd ../src
javac *.java
