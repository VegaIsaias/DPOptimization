# DPOptimization
Uses Dynamic programming technique to create the optimum problem list for the given number of problems and time-frames to maximize points received.

// -------------------------------------------------------------------------------------------------------------
// Reads from text file, first line contains an integer for the number of problems, the second line
// contains one integer for the max number of hours. Goal is to find the set of problems that yields
// to the most points and not exceeding the max number of hours. The following lines indicate the problems, one
// per line. For example: 2 6 (Problem costs 2 hours, and the problem is worth 6 points.
// Dynamic Programming solution, uses the knapsack algorithm.
// -------------------------------------------------------------------------------------------------------------
// To run: java DPOptimization problems.txt
// Example input file:
// 3
// 10
// 2 4
// 3 5
// 4 6
//
