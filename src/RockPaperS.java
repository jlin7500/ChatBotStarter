import java.util.Scanner;

public class RockPaperS
{
    public static void RPS(String a)
    {
        Scanner a1 = new Scanner(System.in);
        int Be = Math.random() * 3 + 1;
        String [] comp = {"rock", "paper", "scissors"};
        String compA = comp[Be];
        System.out.println("On the count of 3, we say which our choice");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        String choice = a1.nextLine();
        choice=choice.toLowerCase();
        System.out.println(compA);

        if(choice.equals(compA))
        {

        }


    }
}
