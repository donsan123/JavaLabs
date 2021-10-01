package main;

public class textbasedgame{
	//Global Variables
	public static int keys = 0;
	public static int bedpost = 0;
	public static int cd = 0;
	public static int health = 100;
	public static int numberofthings = 0;
	public static boolean iskeytaken = false;
	public static boolean iskeyfound = false;
	public static boolean isbedposttaken = false;
	public static boolean ismattressremoved = false;
	public static boolean islargerdooropen = false;
	public static boolean issmallerdooropen = false;
	public static boolean survivedthehole = false;
	public static boolean passwordslip = false;
	public static boolean inthemirrorroom = false;
	public static boolean ismirrorinspected = false;
	public static boolean ismirrorbroken = false;
	public static boolean inthecomproom = false;
	public static boolean searchthecomproom = false;
	
	public static void main (String[] args) {
		pn("CELLBLOCK");
		pn("You wake up on an uncomfortable cot. Feeling the lumpy bits underneath, you peer around the featureless, whitewashed room. ");
		pn("The sharp flourescent lights give off a cold air and goosebumps rise under your skin. On one side of the room is a small door, only large enough for you to" );
		pn("crawl in. On the other end is a great big iron door, similar to those seen in a bank vault. There is a keyhole in that door. ");
		gameLoop();
	}
	public static void gameLoop(){
		while(true) {
			String input = Input.inputString("What do you want to do? ");
			input = input.toLowerCase();
			boolean b = processCommand(input);
			if(b)
				break;
		} pn("Thanks for playing!");
	}
	public static boolean processCommand(String input) {
		if(input.equals("search")||input.equals("search room")) {
			if (!iskeyfound) {
			pn("The room is searched and you find a key");
			iskeyfound = true;
			}else {
				pn("You've already searched the room");
			}
		}
		if (input.equals("take the key")) {
			if(iskeyfound == true) {
				pn("You take the key");
				keys++;
				numberofthings++;
				iskeytaken = true;
			} else if (!iskeyfound) {
				pn("Key?? What key?");
			} else{
				pn("The key is already taken.");
			}
		} else if(input.equals("sit on the bed")) {
			if (!ismattressremoved) {
				pn("You sit down and you ponder a bit. The mattress is so thin, you can hear the bed posts of the bed creak");
			} else{
				pn("You can't sit on an empty bed.");
			}
		} else if (input.equals("remove the mattress")){
			if (!ismattressremoved) {
				pn("You remove the lumpy mattress. What lays before you know is simply a wooden bedframe.");
				ismattressremoved = true;
			} else {
				pn("You've already taken out the mattress");
			}
		} else if(input.equals("hit the bed")||input.equals("hit a bedpost")){
			if (!isbedposttaken) {
				pn("You hit the bedpost, and the stick comes off easily. The rest of the bed collapses into a heap of nails and wood, which makes it pretty much unusable");
				bedpost++;
				numberofthings++;
				isbedposttaken = true;
			} else {
				pn("The remaining heap of dust and nails is unusable.");
			}
		} else if(input.equals("open the larger door")) {
			if(iskeytaken == true) {
				pn("The key, amazingly, opens the door. As you peer out into the darkness, a wet dripping sound can be heard.");
				islargerdooropen = true;
			} else {
				pn("The door is locked. You'd better find a key");
			}
		} else if(input.equals("enter the tunnel")) {
			if (islargerdooropen == true) {
				pn("It's so dark in the tunnel, you can't even see the front of your hand. You stumble along the darkness, and your hand brushes the wet walls");
			} else {
				pn("You can't do that at this time");
			}
		}else if(input.equals("walk forwards with hands on the wall")) {
			pn("You walk forwards hesitantly. Suddenly the floor opens up and you fall into a huge hole. You have died.");
			pn("Type quit to quit");
			health = 0;
		}else if(input.equals("walk forwards with the stick leading me forwards")) {
			if (bedpost == 1) {
				survivedthehole = true;
				pn("You walk forwards hesitantly, the stick in front of you like the blind do. Suddenly, you nearly trip over as the floor descends downwards into a hole.");
				pn("You then feel along the edges of the passage, and you sense a small ledge on the edge of the hole.");
				pn("After you traverse across the pit, you come across a locked door. Next to the door is a password lock. You need the combination in order to open the door.");
			} else {
				pn("You don't have a stick");
			}
		}else if(input.equals("enter the password")) {
			if(passwordslip == true && survivedthehole == true) {
				pn("You stand in front of the password lock. What was the password, again?");
				if(input.equals("5249")) {
					pn("The door swings open. Freedom at last!");
				} else {
					pn("That password is wrong. Please try again.");
				}
			} else {
				pn("You don't have the password slip. Go back and find it!");
			}
		} else if(input.equals("go back to your cell")) {
			if(islargerdooropen == true) {
				pn("You scurry back into your little cell. The large door swings shut behind you.");
				survivedthehole = false;
				islargerdooropen = false;
			}else if (issmallerdooropen == true) {
				pn("After walking around a bit, you crawl back into the little tunnel and into the cell. The door shuts behind you");
				issmallerdooropen = false;
			}else {
				pn("Go back... where?");
			}
		}else if(input.equals("open the smaller door")) {
			issmallerdooropen = true;
			pn("This door leads into a space too small for you to walk in. Instead you will have to crawl in the little tunnel. At the end you see what looks like a room.");
		}else if(input.equals("crawl inside")){
			if (issmallerdooropen == true) {
				pn("You crawl inside the little tunnel. It's too small for your liking, but you manage. At the end of the tunnel, there is a room, nearly identical to your room, with it's own little cot");
				pn("This room has a large mirror in it, and seems pretty threadbare otherwise.");
				inthemirrorroom = true;
			} else {
				pn("crawl? where to?");
			}
		}else if(input.equals("inspect the mirror")) {
			if (inthemirrorroom == true) {
				pn("You decide to take a closer look at the mirror. When you press your finger to the glass, there doesn't seem to be a gap...");
				ismirrorinspected = true;
			} else {
				pn("You're not in the mirror room");
			}
		}else if(input.equals("hit the mirror")) {
			if (ismirrorinspected == true) {
				pn("What do you hit the mirror with?");
				pn("A) Your fist");
				pn("B) Your key");
				pn("C) Your stick");
				if (input.equals("a")||input.equals("fist")) {
					pn("Your knuckles crack, but the impact has had no effect on the mirror");
				} else if (input.equals("b")||input.equals("key")) {
					if (iskeytaken == true) {
						pn("Hitting the key against the mirror reveals nothing except a sliver of a crack if you look very closely");
					} else {
						pn("What key?");
					}
				} else if (input.equals("c")||input.equals("stick")) {
					if(isbedposttaken == true) {
						ismirrorbroken = true;
						pn("Smashing the bedpost-turned-stick against the mirror turns it into a bunch of pieces, where you can see the room behind the mirror. An array of computers greet you");
					} else {
						pn("What key?");
					}
				}
			} else {
				pn("Why would you want to hit a mirror?");
			}
		}else if(input.equals("enter the computer room")) {
			if(ismirrorbroken == true) {
				pn("There are a lot of computers here, but no way to get out... The computers are all disconnected anyways.");
			} else {
				pn("A computer room??? I wish.");
			}
		} else if(input.equals("search the computer room")) {
			if (inthecomproom == true) {
				pn("You find nothing much except for a cd of 'The Shining' and a slip that has the numbers 5249 on them");
			} else {
				pn("There is no computer room... or is there?");
			}
		} else if(input.equals("take the cd")) {
			if (searchthecomproom == true) {
				pn("You take the cd of 'The Shining'");
				cd++;
				numberofthings++;
			} else {
				pn("???");
			}
		} else if(input.equals("take the number slip")) {
			if (searchthecomproom == true) {
				pn("Upon closer inspection, this slip is titled 'Password'. You stuff it in your pocket.");
				passwordslip = true;
			} else {
				pn("???");
			}
		} else if(input.equals("inventory")){
			pn("You have " + health + " health.");
			pn("You have " + numberofthings + " items. These items are:");
			pn("  " + keys + " key");
			pn("  " + bedpost + " bedpost");
		} else if(input.equals("quit")||input.equals("exit")) 
			return true;
		else {
			pn("Sorry I don't understand your command.");
		}return false;
	}

	public static <E> void p(E item) {
		System.out.print(item);
	}
	
	public static <E> void pn(E item) {
		System.out.println(item);
	}
}