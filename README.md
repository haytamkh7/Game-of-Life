# Conway's Game of Life in Java using Swing
The Game of Life is a cellular automaton inspired by the mathematician John Horton Conway.

### Rules
The universe of the Game of Life is a two-dimensional grid of square cells, each cell is in one of two
possible states, alive or dead. Every cell interacts with its eight neighbours and at each step in time,
the next state of each cell will be determined based on the standard rules of Conway's Life.

	  1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
	  2. Any live cell with two or three live neighbors lives on to the next generation.
	  3. Any live cell with more than three live neighbors dies, as if by overpopulation.
	  4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The initial grid is initialized by the computer with a random cells both alive and dead cells. Then the rules will continue
to apply, creating further generations.
