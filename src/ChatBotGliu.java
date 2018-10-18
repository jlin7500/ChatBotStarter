import java.util.*;



public class ChatBotGliu {
    //emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
    int emotion = 0;
    String username="";

    /**
     * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
     * @param statement the statement typed by the user
     */
    public void chatLoop(String statement)
    {
        Scanner in = new Scanner (System.in);
        System.out.println (getGreeting());


        while (!statement.equals("Bye"))
        {


            statement = in.nextLine();
            //getResponse handles the user reply
            System.out.println(getResponse(statement));


        }


    }
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return("Hi.What is your name?");
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";

        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }

        else if (findKeyword(statement, "I won't tell") >= 0)
        {
            response = "Why so negative?";
            emotion--;
        }
        else if(statement == null)
        {
            response ="Please follow the instruction";
            emotion--;
        }
        else if (findKeyword(statement, "My name is") >= 0) {
            String intro = "Have you ever hear of Minecraft? It is the best game in the world!";
            response = transformNametoStatement(statement) + intro;
            emotion++;
        }
        else if(statement.equalsIgnoreCase("yes"))
            {
                System.out.println("Great,"+username+" let's discover more about Minecraft!Type\nHow to survie the first night?\nor Command Block");
                emotion++;
            }

            else if(statement.equalsIgnoreCase("no"))
            {
                System.out.println("Ok,new comer "+username+" Here are some interesting topics of Minecraft:\nHow to survive the first night\nCommand BlockType what you want to know in the chatbox to know more about it.");
            }


        // Response transforming I want to statement
        else if (findKeyword(statement,"How to survive the first night", 0) >= 0)
        {
            response = HowtoSurvive(statement);
        }
        else if (findKeyword(statement, "CommandBlock",0) >= 0)
        {
            response = transformCB(statement);
        }
        else
        {
            response = getRandomResponse();
        }

        return response;
    }


    public String transformNametoStatement(String statement)
    {
        statement=statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn=findKeyword(statement,"My name is",0 );
        username=statement.substring(psn+10).trim();
        return"Hello "+username+" what a good name.";
    }


    /**
     * Take a statement with "I want to <something>." and transform it into
     * "Why do you want to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String HowtoSurvive(String statement)
    {
        Random Sanwer=new Random();

        //  Remove the final period, if there is one
        String[] surviveMethod={"Start punching trees down in a new world\nCreate a crafting table\nCraft a wooden pick out of planks and sticks\nGet lots of cobblestone\nTry to find a tall mountain or a cave and stay inside.",
        "Dig all the way down,stay until the sun rises:)."+"Start punching trees down and make a wood sword(by using a crafting table)\n\t■\n\t■\n\t|\nso you can fight the monsters.","Say\"I love Notch\" 100 times."};
        statement = statement.trim();
        String RsurviveMethod=surviveMethod[Sanwer.nextInt(surviveMethod.length)];
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "How to survive the first night", 0);
        String restOfStatement = statement.substring(psn + 30).trim();
        return restOfStatement + "You could\n"+RsurviveMethod;
    }


    /**
     * Take a statement with "I want <something>." and transform it into
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    private String transformCB(String statement)
    {
        Random Sanwer=new Random();
        String[] CBMethod={"A command block is a block that can execute command in Minecraft.","Players can active many command blocks in a time,which is more effective than execute one command at a time using the chat box",
        "One command block can only execute one command at a time"};
        String commandblock=CBMethod[Sanwer.nextInt(CBMethod.length)];
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "commandblock", 0);
        String restOfStatement = statement.substring(psn +10).trim();
        return "You really want to know about" + restOfStatement + "?"+"\n"+commandblock;

    }


    /**
     * Take a statement with "I <something> you" and transform it into
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */



    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
                            int startPos)
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

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }



    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse ()
    {
        Random r = new Random ();
        if (emotion > 1)
        {
            return randomHappyResponses [r.nextInt(randomHappyResponses.length)]+HapplyEmoji[r.nextInt(HapplyEmoji.length)];

        }
        if (emotion < 0)
        {
            return randomAngryResponses [r.nextInt(randomAngryResponses.length)]+AngryEmoji[r.nextInt(AngryEmoji.length)];
        }
        return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
    }

    private String [] randomNeutralResponses = {"Java Edition of Minecraft has reach 28 millions sales as of March,2018",
            "Spectator mode is a game mode that spectators are invisible and can fly. ",
            "You can actually make infinite water with two water buckets",
            "You can play Minecraft in almost every platform/OS.",
            "Chatbot has crashed.Ah,not really.",
            "Markus Persson,known as Notch, is the creator of Minecraft",
            "Sorry,could you say that again?",
            "Please follow the instruction."
    };
    private String [] randomAngryResponses = {"100% N00B.", "gg ez", "You look like a steven!","/kill @p","I will let you see the power of my \"Sharpness enchantment.level.1000\"sword"};
    private String [] randomHappyResponses = {"We are friends because we play Minecraft","What is your favorite Minecraft item?", "I have a feeling that"+ username+" are a command block master","I think"+username+" already know how to survive the first night","Mine"+username+"craft?"+" I actually don't know what that means"};
    private String [] AngryEmoji={"(＃`Д´)",	"ヾ(`ヘ´)ﾉﾞ","ヽ( `д´*)ノ","ヽ(‵﹏´)ノ", "(ﾒ` ﾛ ´)","(҂ `з´ )"};
    private String [] HapplyEmoji={"(*≧ω≦*)","(´｡• ᵕ •｡`)","(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧","o(≧▽≦)o","(๑˃ᴗ˂ﻭ)"};
}
