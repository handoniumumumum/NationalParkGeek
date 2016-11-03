package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyResults {
	
	private Map<String, Integer> parkVotes = new HashMap<>();
	private List<Park> parkList = new ArrayList<>();
	
	
	public void setParkList(List<Park> parkList) {
		this.parkList = parkList;
	}
	
	public List<Park> getParkList() {
		return parkList;
	}

	public void addParkAndVote(String parkCode, int votes)
	{
		parkVotes.put(parkCode, votes);
	}
	
	public int getVotesByParkCode(String parkCode)
	{
		return parkVotes.get(parkCode);
	}


	
	

}
