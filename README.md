# Schedule Optimization using Dynamic Programming


## 1. The Problem

### 1.1 Context

The rules for a new type of programming contest provides a list of problems, their respective
score in integer points, and a statistically valid estimate of the time it takes to solve the
problem. This duration or time is expressed in integer hours. To help with a solution
strategy the contest organizers reveal there is a dynamic programming solution enabling all
the contestants to maximize their score - and stay within the time limits for the contest.

### 1.2 Considerations
One of the rules’ drawback is that the duration of the contest and the problem data is not
announced until just before the contest start. Another drawback is that once a problem has
been started it must be finished within the timeframe, otherwise there is no score credit for
the problem being attempted.There is no penalty for finishing early and there is no benefit
either, as the time gained cannot be applied to another problem. It is, however, acceptable
to continue on to the next problem in the solution list generated from the dynamic program.

### 1.3 Objective
The goal of the program is to use the DP technique to schedule a problem list for a given number of problems and timeframe to complete them. 

## 2. Dynamic Programming from the Bottom Up

The following animation builds the table from the bottom up

![](https://gabrielghe.github.io/assets/themes/images/2016-01-04-longest-common-subsequence3.gif)



## 3. Input and Output

### 3.1 Input File Format

```
4       # of problems
10      # of max hours
2  4    # of hours to complete and # of points respectively
3  5
4  6
6  7
```

### 3.2 Expected Output

```
contestA.in has 4 problems over 10 hours
Pr#	Time	Points
1	2	4
2	3	5
3	4	6
4	6	7

The selected  problems for the highest contest score are: 
	Problem	Points
	1	4
	2	5
	3	6

Target problem list yields 15 points
```

## 4. Execution

```
java DPOptimization inputFile.txt
```



