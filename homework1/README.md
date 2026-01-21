# CSC480 - Artificial Intelligence I, Assignment 1

William Berthouex <br>
CSC480 - Artificial Intelligence I <br>
Section 810 <br>
Fall 2026 <br>
Assignment 1 <br>
Due January 28, 2026

---

## Run

This project was built using Gradle v8.14

To run, enter the following in the terminal from the directory homework1:

>./gradlew run

---

## Assignment Questions

#### Problem 1. 20 Points: Question 3.21 Prove each of the following statements, or give a counterexample:
   1. Breadth-first search is a special case of uniform-cost search.
   2. Depth-first search is a special case of best-first tree search.
   3. Uniform-cost search is a special case of A* search.

#### Problem 2. 20 Points: Iterative Deepening Depth First Search

#### Problem 3. 20 Points: A* Search

#### Problem 4. 20 Points: Adversial search heuristics functions

#### Problem 5. 20 Points: Adversial search heuristics

Return E<sub>v</sub> = 53 to A<sub>v</sub> = 53
then A<sub>b</sub> = 53 because there is no other data.

F<sub>v</sub> = 56. F<sub>v</sub> > E<sub>v</sub> so A is not updated because it is a min function.

return A<sub>v</sub> to Root<sub>v</sub>, then Root<sub>v</sub> = 53

B<sub>a</sub> = 53 from Root<sub>v</sub>;
B<sub>v</sub> = 47 from G<sub>v</sub>

Since this is a min function, B<sub>v</sub> will be <= to 47 so B<sub>v</sub> will not update.

Since B<sub>a</sub> > B<sub>v</sub> (Root is a max function) then the branch can be pruned<br>
Root is not updated

C<sub>a</sub> = 53 from Root<sub>v</sub>;
C<sub>v</sub> = 45 from I<sub>v</sub>

Since C<sub>a</sub> > C<sub>v</sub> then the branch can be pruned.

D<sub>a</sub> = 53 from Root<sub>v</sub>;
D<sub>v</sub> = 45 from K<sub>v</sub>

Since C<sub>a</sub> > C<sub>v</sub> then the branch can be pruned.
 
Finally, Root<sub>v</sub> = 53.


## Links

Complete code on GitHub [here](https://github.com/StateControlled/CSC480-AI/tree/main/homework1)

This project uses Google's **Gson** library to parse Json files: [Gson GitHub Repository](https://github.com/google/gson)

