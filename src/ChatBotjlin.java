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
	String username = "";
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
		System.out.println("Please type everything in lower case as the bot is sensitive. (⁄ ⁄•⁄ω⁄•⁄ ⁄)");
		return("Hello, what's your name");
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement) {
		String response = "";

		if (statement.length() == 0) {
			response = "Say something, please.";
			emotion--;
		}
		else if (findKeyword(statement, "classes") >= 0) {
			response = "There are 2 types of classes, tanks and damage dealers." + username + "," + "Which one of them would you like to learn about?";
			emotion++;
		} else if (findKeyword(statement, "class") >= 0) {
			response = "There are 2 types of classes, tanks and damage dealers." + username + "," + "Which one of them would you like to learn about?";
			emotion++;
		} else if (findKeyword(statement, "tanks") >= 0) {
			response = "There are 3 tank classes: warden, blade master, and kung fu master.";
			emotion++;
		} else if (findKeyword(statement, "tank") >= 0) {
			response = "There are 3 tank classes: warden, blade master, and kung fu master.";
			emotion++;
		} else if (findKeyword(statement, "damage") >= 0) {
			response = "There are melee and ranged damage dealers? Which would you like to learn about" + username + "?" ;
			emotion++;
		} else if (findKeyword(statement, "damage dealer") >= 0) {
			response = "There are melee and ranged damage dealers? Which would you like to learn about"  + username + "?";
			emotion++;
		} else if (findKeyword(statement, "ranged") >= 0) {
			response = "There are 4 ranged damage dealers: gunslinger, warlock, summoner, and force master.Which would you like to learn about?";
			emotion++;
		} else if (findKeyword(statement, "melee") >= 0) {
			response = "There are 4 melee damage dealers: destroyer, blade dancer, soul fighter, and assassin. Which would you like to learn about";
			emotion++;
		} else if (findKeyword(statement, "warlock") >= 0) {
			response = "The warlock is a slow class that deals medium damage, but mainly offers a buff to the party called 'soulburn'. The warlock has 2 playable elements, shadow and ice." + username +" " + "If you like to get carried you can play this class.";
			emotion++;
		} else if (findKeyword(statement, "gunslinger") >= 0) {
			response = "The gunslinger is a damage dealing class that hits hard and moves fast, they don't have many buffs to offer, only their massive damage. The gunslinger has 2 playable elements, fire and shadow." + username + " " + "If you like big damage and having a bad stereotype you can play this.";
			emotion++;
		} else if (findKeyword(statement, "summoner") >= 0) {
			response = "The summoner is a class with a little pet! The summoner deals the main damage, while the cat offers healing, protection, and damage reduction. The summoner has 2 playable elements, earth and wind." + username + " " +"You want to dress up your pet? Then this is the right class for you!";
			emotion++;
		} else if (findKeyword(statement, "force master") >= 0) {
			response = "The force master is a one of the classes with a skill set that switches back and forth between 2 elements, ice and fire. The force master has 2 playable elements, ice and fire. It may seem unique that they can use 2 elements but they mainly use 1 in combat, the other is used for utility." + username + " " + "Big damage and party utility but most overcrowded class in the game.";
			emotion++;
		} else if (findKeyword(statement, "blade dancer") >= 0) {
			response = "The blade dancer is a class that hits fast and moves fast. The blade dancer is not at all like the blade master, despite its name. The blade dancer also offers party protection but is a melee damage dealer. The blade dancer has 2 playable elements, lightning and wind." + username + " " +"If you like to be fast and smol you can play this";
			emotion++;
		} else if (findKeyword(statement, "Blade dancer") >= 0) {
			response = "The blade dancer is a class that hits fast and moves fast. The blade dancer is not at all like the blade master, despite its name. The blade dancer also offers party protection but is a melee damage dealer. The blade dancer has 2 playable elements, lightning and wind."+ username + " " +"If you like to be fast and smol you can play this";
			emotion++;
		} else if (findKeyword(statement, "Blade Dancer") >= 0) {
			response = "The blade dancer is a class that hits fast and moves fast. The blade dancer is not at all like the blade master, despite its name. The blade dancer also offers party protection but is a melee damage dealer. The blade dancer has 2 playable elements, lightning and wind."+ username + " " +"If you like to be fast and smol you can play this";
			emotion++;
		} else if (findKeyword(statement, "blade Dancer") >= 0) {
			response = "The blade dancer is a class that hits fast and moves fast. The blade dancer is not at all like the blade master, despite its name. The blade dancer also offers party protection but is a melee damage dealer. The blade dancer has 2 playable elements, lightning and wind."+ username + " " +"If you like to be fast and smol you can play this";
			emotion++;
		} else if (findKeyword(statement, "warden") >= 0) {
			response = "The warden is a tank class that moves slow and hits hard. It has a greater health pool than the other tanks because it has a unique character design that gives a passive shield on top of the health bar." + username + "," + " " + "this is the bane of the community!";
			emotion++;
		} else if (findKeyword(statement, "blade master") >= 0) {
			response = "The blade master is a tank class that offers party protection. The blade master is a typical tank with nothing special. The blade master has 2 playable elements, fire and lightning." + username + "," + " " + "this is the OG tank, the actual 'true tank' in my opinion." ;
			emotion++;
		} else if (findKeyword(statement, "kung fu") >= 0) {
			response = "The kung fu master is a tank class that offers many offensive buffs. The kung fu master also has a unique passive that allows them to dodge almost anything." + username + "," + " " + "hardest class to play but can deal ridiculous amounts of damage.";
			emotion++;
		} else if (findKeyword(statement, "kung fu master") >= 0) {
			response = "The kung fu master is a tank class that offers many offensive buffs. The kung fu master also has a unique passive that allows them to dodge almost anything."  + username + "," + " " + "hardest class to play but can deal ridiculous amounts of damage.";
			emotion++;
		} else if (findKeyword(statement, "assassin") >= 0) {
			response = "Every class has two elements which may vary their playstyle greatly. The assassin has the elements of shadow and lightning. Assassins can help their party members skip through monsters and sometimes can solo bosses." + username + "," + " " + "not many play this class, but whatever floats your boat!";
			emotion++;
		} else if (findKeyword(statement, "soul fighter") >= 0) {
			response = "The soul fighter is a class that can switch between melee and range, effectively helping it stay out of harms range. The soul fighter can heal their teammates and even resurrect them if they die. The soul fighter has 2 playable elements, ice and earth." + username +  "," + " " + "tryhard class, all I have to say.";
			emotion++;
		} else if (findKeyword(statement, "destroyer") >= 0) {
			response = "The destroyer can be a slow moving hard hitting class, it can also be a fast moving class depending on how you play it. The destroyer has the unique ability to save allies that are near death from fatal damage.";
			emotion++;
		} else if (findKeyword(statement, "story") >= 0) {
			response = "A quick overview of the story is that your whole school(more like family in the game) has been killed by your masters previous student. you then set off on a path of revenge. If you found this little introduction interesting, feel free to play the game to learn more";
			emotion++;
		} else if (findKeyword(statement, "overview") >= 0) {
			response = "A quick overview of the story is that your whole school(more like family in the game) has been killed by your masters previous student. you then set off on a path of revenge. If you found this little introduction interesting, feel free to play the game to learn more";
			emotion++;
		} else if (findKeyword(statement, "explanation") >= 0) {
			response = "It is a mmo, also know as massive multiplayer online game.";
			emotion++;
		} else if (findKeyword(statement, "folwell") >= 0) {
			response = "Watch your backpacks, Mr. Folwell doesn't fall well.";
			emotion++;
		} else if (findKeyword(statement, "goldman") >= 0) {
			response = "Go for the gold, man.";
			emotion++;
		}
		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = transformIWantToStatement(statement);
		} else if (findKeyword(statement, "I want", 0) >= 0) {
			response = transformIWantStatement(statement);
		} else if (findKeyword(statement, "learn", 0) >= 0) {
			response = transformLearn(statement);
		} else if (findKeyword(statement, "no") >= 0) {
			response = getRandomResponse();
			emotion--;
		} else if (findKeyword(statement, "yes") >= 0) {
			response = getRandomResponse();
			emotion++;
		} else {
			response = getRandomResponse();
			emotion--;
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
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
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
		return"Hello "+ username+" It's nice to meet you.";
	}
	private String transformLearn(String statement)
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
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
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you be happy if you had " + restOfStatement + "?";
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
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
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
	private String [] randomNeutralResponses = {"Blade and Soul may be playable in America, but the developers still follow Korea.",
			"Weeks before the NCmedia day, NCSOFT announced a new Unreal Engine 3 based MMORPG only known by its codename Project [M]. For the next two weeks, a teaser website was updated revealing more information about the project.",
			"The first closed beta test was scheduled for April 27, 2011, while the open beta test and commercial release were to be determined within the year.",
			"An anime adaptation of the game was produced and aired from April to June 2014.",
			"On May 10, 2018, NCsoft has teased a new \"Blade & Soul Vision Update\", the renovation project with upgrading the engine to Unreal Engine 4.",
			"Indeed.",
			"Do you really think so" + username + "?",
			"Okay.",
			"Could you say that again" + username + "?"
	};
	private String [] randomAngryResponses = {"(‡▼益▼)", "Hmph ( `ε´ )" + username + "is a mean person", "Master wouldn't be happy" + username , "٩(╬ʘ益ʘ╬)۶", "I'm coming for you" + username + "!","(；⌣̀_⌣́)"};
	private String [] randomHappyResponses = {"H A P P Y ＼(≧▽≦)／" , "Today is a good day (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧", "Nice (☆▽☆)", "(￣ω￣)"};
	
}
