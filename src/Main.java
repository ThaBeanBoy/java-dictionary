import Generics_Experiment.Dictionary;
import Generics_Experiment.InvalidKeyException;

import java.util.Scanner;
//import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final Scanner Read = new Scanner(System.in);

        Dictionary<String, Integer> Students_Scores = new Dictionary<String, Integer>();

        Students_Scores.add("Lebron James", 90);
        Students_Scores.add("John Doe", 73);
        Students_Scores.add("Steph Curry", 50);
        Students_Scores.add("Mario", 32);

        System.out.println("Number of students : " + Students_Scores.size());
        System.out.print("Student name : ");
        String StudentName = Read.nextLine();

        try{
            System.out.println(StudentName + " : " + Students_Scores.retrieve(StudentName));
        }catch(InvalidKeyException e){
            System.out.println("Student name not found");
        }catch(Exception e){
            System.out.println("Unknown error occured");
        }
    }
}