# Datastructure-Assingment
PROBLEM STATEMENT: 

You work in a wildlife research centre in Australia. Your friend Grof is very interested in how kangaroos
move around in the wild area. He told you that kangaroos are herbivores and only eat certain foods
such as carrots, apples, etc. Studies also shown that male kangaroos tend to go to places with more
female kangaroos for certain purpose. Grof also said that kangaroos are intelligent, and their behaviour
is similar to human. They will form colonies when the group is large enough and move in groups. Since
you are an excellent programmer, Grof asked you to help build a simulator that simulates kangaroos’
behaviour in the wildlife.

KANGAROO SIMULATOR:

Imagine a wildlife area with plenty of spaces and resources. The area is inhabited by a group of
kangaroos each starting at random places. Different area has different amount of resources, some has
more, some has none. Male kangaroos move around by jumping from one point to another while
female kangaroos will not move. However, certain places will be more difficult to travel to, and some
kangaroos do not have the ability to do so. Hence, the simulator should start with a map (randomly
generated/user input). A map consists of different points where kangaroos can stay and use the
resources there. Each kangaroo has different needs and start and random points in the map. Kangaroos
will jump to another point if the current point’s resource is depleting. If there are extra foods in the
point, the kangaroo will keep the extras in its pouch. When the number of kangaroos in a place exceed
a certain threshold, they will form a colony and stay at the place forever. Kangaroo can join the colony
if the resource there is enough for everybody (including foods in pouch). The simulation ends when no
kangaroo is moving around anymore.

POINT:

Each point represents area that kangaroos can stay in the map. Point have resources/food for available
and each point can only house a limited number of kangaroos. Points on the map are connected to each
other however, each path (connection) has a high obstacle. If two points are connected, kangaroo can
travel freely between the points as long as it can jump over the obstacle and the point is not full yet.
For example, Point A is connected to point B. Point B has more food/resource than in point A but the
path AB is blocked by a wall of height 10. So, all kangaroos that are able to jump 10 high will travel to
point B for more food. 

KANGAROO:

Kangaroo can be either male or female. Female kangaroo will not move around the map but it will still
store foods into its pouch. Each kangaroo will have a pouch that can hold a limited amount of food.
Whenever a kangaroo reaches a new point, it will first eat the food to restore energy used to travel to
the new point and keep the remaining food in its pouch (food needed = height of obstacle + 0.5 * food
in pouch). The food needed to restore energy is proportional to the obstacle’s height and the amount of
food carried in pouch. Before a kangaroo decides to leave the current area, it will first check all nearby
points that it can jumps to and move to the point that will results in more food and more female
kangaroos. For example, point A with 0 food is connected to point B with obstacle height 5 and point C 
with obstacle height 8. Point B has 10 food and point C has 15 food. Kangaroo X at point A is carrying 8
foods. It will jump to point C as after reaching there and eating 9 (15 - (8 + 0.5*8)) food to restore
energy, point C will still have 3 foods remaining. However, if point A currently has more than 3 foods,
the kangaroo will not jump to point C. If the remaining food is equal, the kangaroo will decide based on
the number of female kangaroos.

COLONY:

A colony is formed, when the number of kangaroos (including female) in the point exceeds a certain
threshold. The threshold will be set by user. When a colony is formed, kangaroos will stay at the point
and will not move away. All foods carried by the kangaroos will be shared with each other. When new
kangaroo arrives at the colony, it will be forced to join the colony if it is carrying food enough for
everyone as a gift and the limit of the point is not reached. For example, kangaroo Y carrying 3 foods try
to join a colony of 5 kangaroos will be rejected and kangaroo Y will not be able to pass through the
colonized point.

INPUT:

The map can be either randomly generated or input by user.
If input by user, the first line of input will be an integer n, the number of points that is in the network.
The following lines will describe the n instances of points, each separated by a blank line. In each
instance, the first line contains four integers, a, f, l and m, with a representing the ID of the point, f
representing the number of food available in the point, l represents how many kangaroos the point can
fit while m represents the number of path connected to the point. The next m lines will contain 2
integers, A and h. A is the ID of the other point which is connected to the current point while h is the
height of the obstacle in the path.
The second input contains information of each kangaroo available in the map. First line of the input will
be an integer x, the number of kangaroos. The following x lines will contain 3 variables, i, s, and p. i is
the point where the current kangaroo starts at, s is the gender of the kangaroo (M is male, F is female)
while p is the amount of food that can be stored in its pouch.
Final line of input will indicate the threshold amount of kangaroo to form a colony.
Feel free to modify the input format as you see fit. You may change to console prompt but do not leave
out any information.

OUTPUT:

The output should consist of z lines with z representing the sum of number of colonies and number of
remaining kangaroos. For each colony, print out the total number of kangaroos in that colony. For each
remaining kangaroo, print out the location of the kangaroo, gender of kangaroo and how much food is
in its pouch.


