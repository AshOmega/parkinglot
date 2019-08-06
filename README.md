Problem Statement
I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one. I want to create an automated ticketing system that allows my customers to use my parking lot without human intervention.
When a car enters my parking lot, I want to have a ticket issued to the driver. The ticket issuing process includes us documenting the registration number (number plate) and the colour of the car and allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are nice enough to always park in the slots allocated to them). The customer should be allocated a parking slot which is nearest to the entry. At the exit the customer returns the ticket which then marks the slot they were using as being available.
The system should provide me with the ability to find
 out:
● Registration numbers of all cars of a particular colour.
● Slot number in which a car with a given registration number is parked.
● Slot numbers of all slots where a car of a particular colour is parked.
We interact with the system via a simple set of commands which produce a specific output. Please take a look at the example below, which includes all the commands you need to support - they're self explanatory. The system should allow input in two ways. Just to clarify, the same codebase should support both modes of input - we don't want two distinct submissions.
1) It should provide us with an interactive command prompt based shell where commands can be typed in
2) It should accept a filename as a parameter at the command prompt and read the commands from that file
Input (contents of file):
create_parking_lot 6
park KAHH-1234 White
park KAHH-9999 White
park KABB-0001 Black
park KAHH-7777 Red
park KAHH-2701 Blue
park KAHH-3141 Black
leave 4
status
park KAP-333 White
park DLAA-9999 White
registration_numbers_for_cars_with_colour White
slot_numbers_for_cars_with_colour White
slot_number_for_registration_number KAHH-3141
slot_number_for_registration_number MHAY-1111

 Output (to STDOUT):
Created a parking lot with 6 slots
Allocated slot number: 1
Allocated slot number: 2
Allocated slot number: 3
Allocated slot number: 4
Allocated slot number: 5
Allocated slot number: 6
Slot number 4 is free
Slot No.  Registration No
1         KAHH-1234
2         KAHH-9999
3         KABB-0001
5         KAHH-2701
6         KAHH-3141
Allocated slot number: 4
Sorry, parking lot is full
KAHH-1234, KAHH-9999, KAP-333
1, 2, 4
6
Not found

Example: Interactive
$ bin/parking_lot
Assuming a parking lot with 6 slots, the following commands should be run in sequence by typing them in at a prompt and should produce output as described below the command. Note that ​exit ​terminates the process and returns control to the shell.
$ create_parking_lot 6
Created a parking lot with 6 slots
$ park KAHH-1234 White
Allocated slot number: 1
$ park KAHH-9999 White
Allocated slot number: 2
Colour
White
White
Black
Blue
Black

$ park KABB-0001 Black
Allocated slot number: 3
$ park KAHH-7777 Red
Allocated slot number: 4
$ park KAHH-2701 Blue
Allocated slot number: 5
$ park KAHH-3141 Black
Allocated slot number: 6
$ leave 4
Slot number 4 is free
$ status
Slot No.  Registration No
1         KAHH-1234
2         KAHH-9999
3         KABB-0001
5         KAHH-2701
6         KAHH-3141
$ park KAP-333 White
Allocated slot number: 4
$ park DLAA-9999 White
Sorry, parking lot is full
Colour
White
White
Black
Blue
Black
$ registration_numbers_for_cars_with_colour White
KAHH-1234, KAHH-9999, KAP-333
$ slot_numbers_for_cars_with_colour White
1, 2, 4
$ slot_number_for_registration_number KAHH-3141
6
$ slot_number_for_registration_number MHAY-1111
Not found
$ exit


Conditions:
You have to solve the problem in any object oriented or functional language without using any external libraries to the core language except for a testing library for TDD
