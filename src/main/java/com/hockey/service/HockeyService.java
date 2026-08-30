package com.hockey.service;

import java.util.List;

import com.hockey.model.Bugs;
import com.hockey.model.Fixture;
import com.hockey.model.Formation;
import com.hockey.model.Ground;
import com.hockey.model.NameSuper;
import com.hockey.model.Officials;
import com.hockey.model.Player;
import com.hockey.model.Playoff;
import com.hockey.model.Staff;
import com.hockey.model.Statistics;
import com.hockey.model.Team;
import com.hockey.model.TeamColor;
import com.hockey.model.VariousText;

public interface HockeyService {
  Player getPlayer(String whatToProcess, String valueToProcess);
  Team getTeam(String whatToProcess, String valueToProcess);
  Ground getGround(int ground_id);
  List<Player> getPlayers(String whatToProcess, String valueToProcess);
  List<Team> getTeams();
  List<NameSuper> getNameSupers();
  List<Ground> getGrounds();
  List<Playoff> getPlayoffs();
  List<VariousText> getVariousTexts();
  List<Statistics> getAllStats();
  List<Player> getAllPlayer();
  List<Bugs> getBugs();
  List<Fixture> getFixtures();
  List<Formation> getFormations();
  List<TeamColor> getTeamColors();
  List<Staff> getStaffs();
  List<Officials> getOfficials();
}