package com.lakshman.cutshot;

/**
 Created by Lakshman on 27-10-2017.

 TODO


 Background

 There is an elevator in a building with n floors. The elevator works like a conventional elevator.
 The elevator car will keep going in a direction to pick up passengers unless there is no one else going in that direction.
 The direction will then reverse to serve the calls from people going in the other direction.

 Problem
 Given the number of floors,
 your current position/direction of the elevator car and status of calls on different floors,
 your program should determine the sequence of floors the elevator will stop at to pick up passengers.

 You can ignore the stops the car makes to drop off passengers.

 Input Format
 The first line specifies n or the number of total floors in the building.
 The second line specifies the current location and direction of elevator car as a tuple of (currentfloor-currentdirection).
 The third line specifies the comma separated tuples of (floor number-call direction)
 on each floor where a call for elevator has been registered.

 Constraints
 1<=n<=10000000

 Output Format
 Your program should output the sequence of floors the elevator car will stop to pick up passengers in a comma separated format

 Sample Input 1
 5
 2-up
 1-down,2-up,3-down,4-up

 Sample Output 1
 2,4,3,1

 Sample Input 2
 3
 1-up
 2-up

 Sample Output 2
 2
 */
public class Elevator {

}
