import java.util.Scanner;

public class RockPaperS
{
    public static int RPS()
    {
        Scanner a1 = new Scanner(System.in);
        int Be = (int) Math.random() * 3 + 1;
        String [] comp = {"rock", "paper", "scissors"};
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
            choice = a1.nextLine();
        }
        else if (!choice.equals(compA))
        {
            System.out.println("I win or Do you want to argue with me?");
            choice= a1.nextLine();
        }
        if(choice.equals("yes"))
        {
            return -6;
        }
        if(choice.equals("no"))
        {
            return +9;
        }
        if(findKeyword(choice, "win",0)>=0))
        {
            return +6;
        }
        if(findKeyword(choice, "lose",0)>=0))
        {
            return -2;
        }
    }

    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                    // letter
                    && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }
}
