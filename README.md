# Vector
- A vector can have any number of dimensions either 2D, 3D, or nD. So to represent the dimensions of a vector we use a dynamic array that stores any number of dimension.
- In `Vector` class the constructors either asign default value or a value recieved from user to asign the initial and most common dimension of a vector.
- The `vec_dimen_count()` method returns the size of the array of the current object.
- The `get_coordiantes()` method returns the element on the index that is given in parameter.
- The `set_coordiantes()` method sets the value of given index/dimension to a value given by user. We implement a fail safe that incase that we acces and index that does not yet exist then we assigne 0 to unasigned indeces and then we set the value of required index.
- The `Magnitude()` returns the magnitude of current vector.
- The `equals()` checks if two vectors are equal.
- The `bigger_vector()` method checks which vector has more dimensions and returns the nubmer of dimensions and then assignes 0 to the missing dimensions in the smaller vector to avoid index out of bounds error when doing operations on it with the larger vector.
- The `Add()` functions adds two vectors and returns the resultant vector with a `Vector` return type.
- The `Subb()` functions subtracts two vectors and returns the resultant vector with a `Vector` return type.
- The `DotProduct()` returns the scalar product of two vectors.
- The `CrossProcut()` returns the vector product of two vectors. As Cross Product is only possible when both vectors are 3D so here we throw a error if they are not and terminate the program.
- The `clone()` creats a deep copy of Vector object which is. so that if we make changes to copy vector it doesn't effect the original and niether a change in the original after making the copy affects the copy.
- Finally we implement a `toString()` for easily displaying vectors.

- The `Main` class is used to make objects and run the operatoins of Vector class.
