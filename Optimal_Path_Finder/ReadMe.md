
## Project Overview
This project, implements a path planning system to find feasible paths through grid-based maps. The system converts text-based map data into graph structures to calculate paths from a starting coordinate to a goal coordinate while avoiding obstacles.

## Problem Definition
* **Objective**: Find a feasible path from a starting point to an end point in each map.
* **Map Representation**: Maps are $n \times n$ matrices where `0` represents unoccupied space and `1` (or `-1`) represents obstacles.
* **Optimal Path**: The shortest path is considered optimal and yields extra credit, though any feasible path is acceptable.



## Technical Architecture

### 1. Data Structures
* **CSE222Map**: Reads input text files to store the start point, end point, and the $n \times n$ matrix.
* **CSE222Graph**: Constructs a graph where nodes exist only for unoccupied (`0`) coordinates.
* **Inner Node Class**: Stores $(y, x)$ coordinates, adjacency lists (neighbors), and the path back to the origin.

### 2. Adjacency Logic
Nodes are connected if they are adjacent in any of the 8 directions:
* **Cardinal**: $(y-1, x), (y+1, x), (y, x-1), (y, x+1).
* **Diagonal**: $(y-1, x-1), (y-1, x+1), (y+1, x+1), (y+1, x-1).

### 3. Pathfinding Algorithms
* **Dijkstra’s Algorithm**: A weighted approach that finds a feasible path by exploring the smallest distance from the source.
* **Breadth-First Search (BFS)**: A queue-based approach that identifies nodes layer by layer to find a feasible path.

## Installation & Usage

### Compilation
Navigate to the source folder and compile the Java files:
```bash
cd ../src
javac *.java
