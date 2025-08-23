public class Main 
{
    public static void main(String[] args) 
    {
        //|||||||||||||||| Working |||||||||||||
        Vector vec_obj1=new Vector(3,4,6);

        vec_obj1.set_coordinates(0,2);

        vec_obj1.set_coordinates(3, 3);
        vec_obj1.set_coordinates(4, 3);
        vec_obj1.set_coordinates(5, 3);
        vec_obj1.set_coordinates(6, 3);

        System.out.println(vec_obj1.toString());
        System.out.println("this vectors magnitude is : " + vec_obj1.Magnitude());


        Vector vec_obj2=new Vector(7,5,1);

        vec_obj2.set_coordinates(3, 4);
        vec_obj2.set_coordinates(4,5 );
        vec_obj2.set_coordinates(5, 3);
        vec_obj2.set_coordinates(6, 3);
        

        System.out.println(vec_obj2.toString());

        //||||||||||| Creating a copy of vec_obj2
        Vector copy = vec_obj2.clone(vec_obj2);
        System.out.println("Copy of obj2. "+copy.toString());
        System.out.print("Are these equal : ");
        System.out.println(vec_obj2.equals(copy)); //|||||||| true
        copy.set_coordinates(0, 99.0);
        System.out.println("changed Copy of obj2. "+copy.toString());
        System.out.print("Are these equal : ");
        System.out.println(vec_obj2.equals(copy)); //|||||||| false, Hence deep copy
        
        System.out.println("When added " + vec_obj1.Add(vec_obj2).toString());
        System.out.println("When subtracted " + vec_obj1.Subb(vec_obj2).toString());
        System.out.println("Their Dot Product. " + vec_obj1.DotProduct(vec_obj2));

        Vector vec_obj5=new Vector(2,4,6);
        Vector vec_obj6=new Vector(7,5,1);
        System.out.println("the Cross Product. " + vec_obj5.CrossProduct(vec_obj6).toString());
       //|||||| Iterating using a for each loop with help of prebuit iterator method which we make a method of in Vecto
      //|||||| I am still not clear how this works...
        System.out.println("Now Iterating through the first vector ")
        for (double v : vec_obj1) 
        {
            System.out.print(v + " ");
        }
    }

}

