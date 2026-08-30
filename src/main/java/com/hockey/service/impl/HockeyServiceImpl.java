package com.hockey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hockey.dao.HockeyDao;
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
import com.hockey.service.HockeyService;

@Service("footballService")
@Transactional
public class HockeyServiceImpl implements HockeyService {

 @Autowired
 private HockeyDao footballDao;
 
@Override
public Player getPlayer(String whatToProcess, String valueToProcess) {
	return footballDao.getPlayer(whatToProcess, valueToProcess);
}

@Override
public Team getTeam(String whatToProcess, String valueToProcess) {
	return footballDao.getTeam(whatToProcess, valueToProcess);
}

@Override
public List<Team> getTeams() {
	return footballDao.getTeams();
}

@Override
public List<NameSuper> getNameSupers() {
	return footballDao.getNameSupers();
}

@Override
public List<Player> getPlayers(String whatToProcess, String valueToProcess) {
	return footballDao.getPlayers(whatToProcess, valueToProcess);
}

@Override
public List<Ground> getGrounds() {
	return footballDao.getGrounds();
}

@Override
public List<Playoff> getPlayoffs() {
	return footballDao.getPlayoffs();
}

@Override
public List<VariousText> getVariousTexts() {
	return footballDao.getVariousTexts();
}

@Override
public Ground getGround(int ground_id) {
	return footballDao.getGround(ground_id);
}

@Override
public List<Bugs> getBugs() {
	return footballDao.getBugs();
}

@Override
public List<Statistics> getAllStats() {
	return footballDao.getAllStats();
}

@Override
public List<Player> getAllPlayer() {
	return footballDao.getAllPlayer();
}

@Override
public List<Fixture> getFixtures() {
	return footballDao.getFixtures();
}

@Override
public List<Formation> getFormations() {
	return footballDao.getFormations();
}

@Override
public List<TeamColor> getTeamColors() {
	return footballDao.getTeamColors();
}

@Override
public List<Staff> getStaffs() {
	return footballDao.getStaff();
}

@Override
public List<Officials> getOfficials() {
	return footballDao.getOfficials();
}

}