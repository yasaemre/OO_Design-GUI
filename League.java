package HW5_MVC_GUI;

import java.util.ArrayList;
import java.util.Collections;

public class League {
	private ArrayList<SportClub> clubList;

	public League() {
		clubList = new ArrayList<>();
	}
	public void addClub(SportClub e) {
		clubList.add(e);
	}
	
	public ArrayList<SportClub> getClubList() {
		Collections.sort(clubList);
		return clubList;
	}
}
