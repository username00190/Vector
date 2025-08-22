import java.util.*;
public class Vector 
{
    private ArrayList<Double> vector = new ArrayList<Double>();
    private int temp=0;
    private int bigger_size=0;
    private int big=0;
    private boolean equality;
    private double magnitude;


    public Vector()
    {
        vector.add((double) (0));
        vector.add((double) (0));
    }
    public Vector(double x, double y)
    {
        vector.add((double) (x));
        vector.add((double) (y));
    }
    public Vector(double x, double y, double z)
    {
        vector.add((double) (x));
        vector.add((double) (y));
        vector.add((double) (z));
    }

    public int vec_dimen_count()
    {
        return vector.size();
    }

    public boolean equals(Vector another)
    {
        if(this.vec_dimen_count()!=another.vec_dimen_count())
            equality=false;
        
        else
        {
            for (int j=0;j<this.vec_dimen_count();j++)
            {
                if(this.get_coordinates(j)==another.get_coordinates(j))
                    equality=true;

                else
                {
                    equality=false;
                    break;
                }
            }
        }
        return equality;
    }
    public double get_coordinates(int i)
    {
        if(i<this.vec_dimen_count())
            return vector.get(i);
        else
            throw new IndexOutOfBoundsException("! The given index does not exist !");
    }
    public void set_coordinates(int i, double component)
    {
        //||||||||||||||| If the index i does not already exist in vector array then we assign 0 to the indexes till that required index and then we change value
        if(vector.size()<=i)
        {
            temp=i-vector.size()+1;
            for(int j=0;j<temp;j++)
            {
                vector.add (0.0);
            }
        }
        vector.set(i, component);
    }
    public int bigger_vector(Vector toCheck)
    {
        if(this.vec_dimen_count()<toCheck.vec_dimen_count())
            {
                bigger_size=toCheck.vec_dimen_count();
                
                this.set_coordinates(bigger_size-1, 0);//||||||To avoid index out of bounds error we assign zero to unasigned dimensions
                //||||||||||||||||||| when adding or multiplying b/w vectors with different sizes
            }

        else if(this.vec_dimen_count()>toCheck.vec_dimen_count())
            {
                bigger_size=this.vec_dimen_count();
                toCheck.set_coordinates(bigger_size-1, 0);//|||||||||||| Same as above
            }
            else
                bigger_size=toCheck.vec_dimen_count();

        return bigger_size;
    }

    public double Magnitude()
    {
        for(int j=0;j<this.vec_dimen_count();j++)
        {
            magnitude+=this.get_coordinates(j)*this.get_coordinates(j);
        }
        return (Math.sqrt(magnitude));
    }

    public Vector Add(Vector another)
    {
        Vector addedVector=new Vector();

        if(big==0)//|||| To avoid calling the function more than once for one object
            big=bigger_vector(another);

        for(int j=0;j<big;j++)
        {
            addedVector.set_coordinates(j, (this.get_coordinates(j) + another.get_coordinates(j)));
        }
        return addedVector;
    }
    public Vector Subb(Vector another)
    {
        Vector addedVector=new Vector();

        if(big==0)//|||| To avoid calling the function more than once for one object
            big=bigger_vector(another);

        for(int j=0;j<big;j++)
        {
            addedVector.set_coordinates(j, (this.get_coordinates(j) - another.get_coordinates(j)));
        }
        return addedVector;
    }

    public Double DotProduct(Vector another)
    {
        //|||||||||| If dimension is unequal we assign 0 in the missing dimensions in the vector with lower dimensions. 
        //|||||||||| This is what we did in 1st year physics so hopefully its right
        Double dot_product=0.0;
        
        if(big==0)
            big=bigger_vector(another);

        for(int j=0;j<big;j++)
        {
            dot_product+= (this.get_coordinates(j) * another.get_coordinates(j));
        }
        return dot_product;
    }

    public Vector CrossProduct(Vector another)
    {
        Vector crossProduct=new Vector();
        //||||||||||||| According to my reasearch the cross product is only for vectors in 3d space
        //||||||||||||| its possible for higher dimensions but it uses some complex and advanced maths that is beyond the scope of this assignment
        if(this.vec_dimen_count()!=3 || another.vec_dimen_count()!=3)
            throw new IllegalArgumentException("! Cross product can only be found when both vectors have 3 dimensions !");
            

        else
        {
            //||||||||| Just googled and converted the cross product math formula into code. I aint doin any manual maths 😤
            //||||||||| I always used the matrix method to find cross product in 1st year and I have no Idea how to implement that here and I didn't know this weird formula ever in my life
            crossProduct.set_coordinates(0, (this.get_coordinates(1)*another.get_coordinates(2))-(this.get_coordinates(2)*another.get_coordinates(1)));
            crossProduct.set_coordinates(1, (this.get_coordinates(2)*another.get_coordinates(0))-(this.get_coordinates(0)*another.get_coordinates(2)));
            crossProduct.set_coordinates(2, (this.get_coordinates(0)*another.get_coordinates(1))-(this.get_coordinates(1)*another.get_coordinates(0)));   
        }
        return crossProduct;
    }

    public Vector clone(Vector toClone) //|||||||| Make deep copy of vector recieved in parameter. 
    {
        //|||||||||||||| Credit to https://www.geeksforgeeks.org/java/deep-shallow-lazy-copy-java-examples/ for this

        Vector cloned = new Vector(); // Create a new Vector object
        cloned.vector = new ArrayList<Double>(); // Initialize its internal list

        for (int i = 0; i < toClone.vec_dimen_count(); i++) 
        {
            cloned.vector.add(toClone.get_coordinates(i)); // Copy each component
        }
        return cloned;
    }

    @Override
    public String toString()
    {
        String condition="current vector is: (";
        for(int j=0;j<this.vec_dimen_count();j++)
        {
            condition=condition+get_coordinates(j)+", ";
        }
        return condition+")\t with size : "+this.vec_dimen_count();
    }
    
}
