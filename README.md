# Graphics-Projects
A collection of various small JavaScript and Processing graphics projects done for fun!

----------------------------
Descriptions of each project
----------------------------

flying_terrain
--------------
Using perlin noise I determined the height of each cell in my grid and drew triangles between those vertices to create the image of terrain. 
To make the 'flying' aspect, I generated more verticies with the perlin noise and had the new points advance towards the viewing point.


fractal_tree_final
------------------
Using a recursive method, I draw lines that branch off in two directions at a certain angle decided by the slider, which continually get shorter.

mazefinal
---------
Using Depth First Search, I search the cells, and 'knock down' walls every time the search advances. This search will continue until it can't any further, 
then will back track until it sees available cells that haven't been visited yet. The result of the process of knocking down walls will reveal a maze 
with a path from any cell to any other cell. 

rays
----
I randomly generate walls, where rays will emit from the particle to the nearest wall using line intersection formulae. This particle's position can be 
decided by perlin noise (rays1_perlin_noise) or by the cursor position (rays2_cursor). 

reaction_diffusion
------------------
Simulates a reaction using the Gray-Scott model. There is an initial reactant and catalyst, which react and propogate the reaction to surrounding remaining reactant.
