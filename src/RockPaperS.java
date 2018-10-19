
import java.util.Scanner;

public class RockPaperS
{
    public static void RPS()
    {
        Scanner a1 = new Scanner(System.in);
        int Be = (int) Math.random() * 3;
        String [] comp = {"space rock", "unbreakable paper", "scissors that cut everything"};
        String compA = comp[Be];
        System.out.println("We are gonna play Rock Paper Scissors");
        System.out.println("On the count of 3, we say which our choice");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        String choice = a1.nextLine();
        choice=choice.toLowerCase();
        System.out.println(compA);

        if(choice.equals(compA))
        {
            System.out.println("I guess we either both lose or both win");
        }
        else if (!choice.equals(compA))
        {
            System.out.println("I win!(I did play within the rules)");
        }

    }
}
