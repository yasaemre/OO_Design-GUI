package HW5_MVC_GUI;

public class SoccerClub extends SportClub {

	private String clubName;
	private int numOfPlayers;
	private int numOfCoaches = 4;
	private ClubStatus status;
	
	public SoccerClub(int numOfPlayers, String clubName) {
		super(numOfPlayers, clubName);
	}
	public SoccerClub (int numOfPlayers, String clubName, ClubStatus status) {
		super(numOfPlayers, clubName);
		this.status = status;
	}
	public ClubStatus getStatus() {
		return status;
	}
	public String getName() {
		return clubName;
	}
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	public void setNumOfPlayers(int number) {
		if (number > 0 && number < 100) {
			this.numOfPlayers = number;
		}
	}
	@Override
	public String toString() {
		String soccerClub = super.toString();
		soccerClub += " And it's status is " + status;
		return soccerClub;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SoccerClub) {
			SoccerClub otherSoccerClub = (SoccerClub) obj;
			return super.equals(obj) && numOfPlayers == otherSoccerClub.numOfPlayers;
		} else {
			return false;
		}
	}
	@Override
	public void play() {
		super.play();
		System.out.println("\tThe players play the soccer");
	}

	@Override
	public void numOfCoaches() {
		System.out.println("\t"+ super.getName() + " has " + numOfCoaches + " coaches");
	}
	@Override
	public void havePlayers() {
		System.out.println(clubName + " having " + numOfPlayers + " players");
	}
	public String bonus() {
		if (status == ClubStatus.ACTIVE) {
			return "\t" + super.getName() + " is being paid success bonuses to the players \n";
		} else {
			return "\t" + super.getName() + " not being paid bonuses \n";
		}
	}
}
