import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotjlin
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;

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
		System.out.println("Hello, I see you selected the Blade and Soul bot ☆*:.｡.o(≧▽≦)o.｡.:*☆, or you just didn't select anything and got sent here(ノ°益°)ノ.");
		System.out.println("What would you like to learn about the game?");
		System.out.println("We have types of classes, overview of the story, explanation of what type of game Blade and Soul is.");
		return("");
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

		else if (findKeyword(statement, "classes") >= 0)
		{
			response = "There are 3 types of classes, tanks, damage dealers, and supports. Which one of them would you like to learn about?";
                	emotion--;
		}
		else if (findKeyword(statement, "tanks") >= 0)
		{
			response = "There are 3 tank classes: warden, blade master, and kung fu master.";
		}
		else if (findKeyword(statement, "tank") >= 0)
		{
			response = "There are 3 tank classes: warden, blade master, and kung fu master.";
		}
		else if (findKeyword(statement, "warden") >= 0)
		{
			response = "The warden is a tank class that moves slow and hits hard. It has a greater health pool than the other tanks because it has a unique character design that gives a passive sheild on top of the health bar.";
		}
		else if (findKeyword(statement, "blade master") >= 0)
		{
			response = "The blade master is a tank class that offers party protection. The blade master is a typical tank with nothing special. ";
		}
		else if (findKeyword(statement, "kung fu") >= 0)
		{
			response = "The kung fu master is a tank class that offers many offensive buffs. The kung fu master also has a unique passive that allows them to dodge almost anything.";
		}
		else if (findKeyword(statement, "kung fu master") >= 0)
		{
			response = "The kung fu master is a tank class that offers many offensive buffs. The kung fu master also has a unique passive that allows them to dodge almost anything.";
		}
		else if (findKeyword(statement, "assassin") >= 0)
		{
			response = "Every class has two elements which may vary their playstyle greatly. The assassin has the elements of shadow and lightning. Despite the name, the shadow assasin does most damage when out of stealth. The lightning assassin on the other hand does more damage";
		}
		else if (findKeyword(statement, "blade master") >= 0)
		{
			response = "Every class has two elements which may vary their playstyle greatly. The blade master has the elements of fire and lightning. The blade master can offer protection to the whole party and is also one of the few tank classes the game.  has Fire is easier to play than lightning.";
		}
		else if (findKeyword(statement, "story") >= 0)
		{
			response = "A quick overview of the story is that your whole school(more like family in the game) has been killed by your masters previous student. you then set off on a path of revenge. If you found this little introduction intersting, feel free to play the game to learn more";
			emotion++;
		}
		else if (findKeyword(statement, "overview") >= 0)
		{
			response = "A quick overview of the story is that your whole school(more like family in the game) has been killed by your masters previousa student. you then set off on a path of revenge. If you found this little introduction intersting, feel free to play the game to learn more";
			emotion++;
		}
		else if (findKeyword(statement,"explanation") >= 0)
		{
			response = "It is a mmo, also know as massive multiplayer online game.";
			emotion++;
		}
		else if (findKeyword(statement, "folwell") >= 0)
		{
			response = "Watch your backpacks, Mr. Folwell doesn't fall well.";
			emotion++;
		}
		else if (findKeyword(statement, "goldman") >= 0)
		{
			response = "Go for the gold, man.";
			emotion++;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement , "learn", 0) >= 0)
		{
			response =transformLearn(statement);
		}
		else
		{
			response = getRandomResponse();
		}

		return response;
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */


	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}

	private String transformLearn(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "learn", 0);
		String restOfStatement = statement.substring(psn + 5).trim();
		return "Why do you want to learn " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	

	
	
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
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	
}
