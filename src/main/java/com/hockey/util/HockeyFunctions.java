package com.hockey.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.hockey.model.Fixture;
import com.hockey.model.Match;
import com.hockey.model.MatchStats;
import com.hockey.model.Player;
import com.hockey.model.PlayerStats;
import com.hockey.model.Team;
import com.hockey.service.HockeyService;

public class HockeyFunctions {
	
	public static class PlayerStatsComparator implements Comparator<PlayerStats> {
	    @Override
	    public int compare(PlayerStats bs1, PlayerStats bs2) {
	       return Float.compare(Float.valueOf(bs2.getValue()), Float.valueOf(bs1.getValue()));
	    }
	}
	
	public static List<Fixture> processAllFixtures(HockeyService footballService) {
		List<Fixture> fixtures = footballService.getFixtures();
		for(Team tm : footballService.getTeams()) {
			for(Fixture fix : fixtures) {
				if(fix.getHometeamid() == tm.getTeamId()) {
					fix.setHome_Team(tm);
				}
				if(fix.getAwayteamid() == tm.getTeamId()) {
					fix.setAway_Team(tm);
				}
			}
		}
		return fixtures;
	}
	
	public static String twoDigitString(long number) {
	    if (number == 0) {
	        return "00";
	    }
	    if (number / 10 == 0) {
	        return "0" + number;
	    }
	    return String.valueOf(number);
	}
	
	public static String replace(float number) {
	    return String.valueOf(number).replace(".0", "");
	}
	
	public static String getPlayerSquadType(int player_id,String Goal_Type ,Match match)
	{	
		if(Goal_Type.equalsIgnoreCase(HockeyUtil.OWN_GOAL)) {
			for(Player plyr : match.getHomeSquad()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.AWAY;
				}
			}
			for(Player plyr : match.getHomeSubstitutes()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.AWAY;
				}
			}
			for(Player plyr : match.getAwaySquad()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.HOME;
				}
			}
			for(Player plyr : match.getAwaySubstitutes()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.HOME;
				}
			}
		}else if(Goal_Type.equalsIgnoreCase(HockeyUtil.GOAL) || Goal_Type.equalsIgnoreCase(HockeyUtil.PENALTY)) {
			for(Player plyr : match.getHomeSquad()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.HOME;
				}
			}
			for(Player plyr : match.getHomeSubstitutes()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.HOME;
				}
			}
			for(Player plyr : match.getAwaySquad()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.AWAY;
				}
			}
			for(Player plyr : match.getAwaySubstitutes()) {
				if(plyr.getPlayerId() == player_id) {
					return HockeyUtil.AWAY;
				}
			}
		}
		
		return "";
	}
	
	public static String calExtraTimeGoal(String half,long number_in_milli) {
		
		long time=0,number=0;
		
		number = (number_in_milli/1000);
		
		if(half.equalsIgnoreCase("first") && number > 900) {
			time = ((number - 900)/60) + 1;
			return "15' (+" + time + "')" ;
		}else if(half.equalsIgnoreCase("second") && number > 900) {
			time = ((number - 900)/60) + 1;
			return "15' (+" + time + "')" ;
		}if(half.equalsIgnoreCase("extra1") && number > 900) {
			time = ((number - 900)/60) + 1;
			return "15' (+" + time + "')" ;
		}else if(half.equalsIgnoreCase("extra2") && number > 900) {
			time = ((number - 900)/60) + 1;
			return "15' (+" + time + "')" ;
		}else {
			return String.valueOf((number/60)+1) + "'" ;
		}
	}
	
	public static String goal_shortname(String goal_type) {
		if(goal_type.equalsIgnoreCase(HockeyUtil.PENALTY)) {
			return " (P) ";
		}else if(goal_type.equalsIgnoreCase(HockeyUtil.OWN_GOAL)) {
			return " (OG) ";
		}else if(goal_type.equalsIgnoreCase(HockeyUtil.GOAL)) {
			return " ";
		}
		return "";
	}
	
	public static Player populatePlayer(HockeyService footballService, Player player, Match match)
	{
		Player this_plyr = new Player();
		this_plyr = footballService.getPlayer(HockeyUtil.PLAYER, String.valueOf(player.getPlayerId()));
		if(this_plyr != null) {
			this_plyr.setPlayerPosition(player.getPlayerPosition()); this_plyr.setCaptainGoalKeeper(player.getCaptainGoalKeeper());
		}
		return this_plyr;
	}
	
	public static Match populateMatchVariables(HockeyService footballService,Match match) 
	{
		List<Player> players = new ArrayList<Player>();
		
		for(Player plyr:match.getHomeSquad()) {
			players.add(populatePlayer(footballService, plyr, match));
		}
		match.setHomeSquad(players);

		players = new ArrayList<Player>();
		for(Player plyr:match.getHomeSubstitutes()) {
			players.add(populatePlayer(footballService, plyr, match));
		}
		match.setHomeSubstitutes(players);
		
		players = new ArrayList<Player>();
		if(match.getHomeOtherSquad() != null) {
			for(Player plyr:match.getHomeOtherSquad()) {
				players.add(populatePlayer(footballService, plyr, match));
			}
		}
		match.setHomeOtherSquad(players);
		
		players = new ArrayList<Player>();
		for(Player plyr:match.getAwaySquad()) {
			players.add(populatePlayer(footballService, plyr, match));
		}
		match.setAwaySquad(players);

		players = new ArrayList<Player>();
		for(Player plyr:match.getAwaySubstitutes()) {
			players.add(populatePlayer(footballService, plyr, match));
		}
		match.setAwaySubstitutes(players);
		
		players = new ArrayList<Player>();
		if(match.getAwayOtherSquad() != null) {
			for(Player plyr:match.getAwayOtherSquad()) {
				players.add(populatePlayer(footballService, plyr, match));
			}
		}
		match.setAwayOtherSquad(players);
		
		if(match.getHomeTeamId() > 0)
			match.setHomeTeam(footballService.getTeam(HockeyUtil.TEAM, String.valueOf(match.getHomeTeamId())));
		if(match.getAwayTeamId() > 0)
			match.setAwayTeam(footballService.getTeam(HockeyUtil.TEAM, String.valueOf(match.getAwayTeamId())));
		if(match.getGroundId() > 0) {
			match.setGround(footballService.getGround(match.getGroundId()));
			match.setVenueName(match.getGround().getFullname());
		}

		if(match.getMatchStats() != null) {
			for(MatchStats ms : match.getMatchStats()) {
				ms.setPlayer(footballService.getPlayer(HockeyUtil.PLAYER, String.valueOf(ms.getPlayerId())));
			}
		}
		
		return match;
	}
	
	public static String getOnlineCurrentDate() throws IOException
	{
		HttpURLConnection httpCon = (HttpURLConnection) new URL("https://mail.google.com/").openConnection();
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(httpCon.getDate()));
	}	
	
	public static List<Player> getPlayersFromDB(HockeyService footballService, String whichTeamToProcess, Match match)
	{
		List<Player> players = new ArrayList<Player>(),whichTeamToCheck = new ArrayList<Player>();
		boolean player_found = false; 
		int whichTeamId = 0; 
		
		switch (whichTeamToProcess) {
		case HockeyUtil.HOME:
			whichTeamId = match.getHomeTeamId();
			whichTeamToCheck = match.getHomeSquad();
			break;
		case HockeyUtil.AWAY:
			whichTeamId = match.getAwayTeamId();
			whichTeamToCheck = match.getAwaySquad();
			break;
		}
		for(Player plyr : footballService.getPlayers(HockeyUtil.TEAM,String.valueOf(whichTeamId))) {
			player_found = false;
			for(Player subPlyr : whichTeamToCheck) {
				if (subPlyr.getPlayerId() == plyr.getPlayerId()) {
					player_found = true;
				}
			}
			if(player_found == false) {
				players.add(plyr);
			}
		}
		return players;
	}	
}
