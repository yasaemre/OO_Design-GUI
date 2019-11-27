package HW5_MVC_GUI;

import java.util.Comparator;

public abstract class SportClub implements Comparable<SportClub> {
	private int numOfPlayers;
	private String clubName;
	protected static Player player;
	private ClubStatus status;
	public static int numOfClub = 0;
	public static final int DEFAULT_NUM = 0;
	
	public final static Comparator<SportClub> NAME_COMPARATOR = new SportClubNameComparator();
	public final static Comparator<SportClub> NAME_NUMOFPLAYER_COMPARATOR = new SportClubNameNumOfPlayerComparator();
	
	private static class SportClubNameComparator implements Comparator<SportClub> {
		
		@Override
		public int compare(SportClub s1, SportClub s2) {
			return s1.clubName.compareTo(s2.clubName);
		}
	}
	
	private static class SportClubNameNumOfPlayerComparator implements Comparator<SportClub> {
		
		@Override
		public int compare(SportClub s1, SportClub s2) {
			if(s1.clubName.compareToIgnoreCase(s2.clubName)==0) { 
				return Integer.compare(s1.numOfPlayers, s2.numOfPlayers);
			} else { 
				return s1.clubName.compareToIgnoreCase(s2.clubName);
			}
		}
	}
	
	public SportClub (int numOfPlayers, String name) {
		this.numOfPlayers = numOfPlayers;
		this.clubName = name;
		
		SportClub.numOfClub++;
	}
	public SportClub (String name) {
		this(DEFAULT_NUM, name);
	}
	
	public String getName() {
		return clubName;
	}
	public static int getNumOfClub() {
		return numOfClub;
	}
	
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	public void setNumOfPlayers(int number) {
		if (number > 0 && number < 100) {
			this.numOfPlayers = number;
		}
	}
	public void setName(String name) {
		this.clubName = name;
	}
	@Override
	public String toString() {
		return clubName + " (Club's number of players: " + numOfPlayers + ")";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SportClub) {
			SportClub otherClub = (SportClub) obj;
			
			int otherClubP = otherClub.numOfPlayers;
			String otherClubName = otherClub.clubName;
			
			if (numOfPlayers == otherClubP && clubName.equalsIgnoreCase(otherClubName)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public int compareTo(SportClub club) {
		if(clubName.compareToIgnoreCase(club.clubName) != 0) {
			return clubName.compareToIgnoreCase(club.clubName);
		} else {
			return Integer.compare(numOfPlayers, club.numOfPlayers);
		}
	}
	public void play() {
		System.out.println("Playing: " + clubName);
	}
	public void havePlayers() {
		System.out.println(clubName + " having " + numOfPlayers);
	}
	public abstract String bonus();
	public abstract void numOfCoaches();
}
