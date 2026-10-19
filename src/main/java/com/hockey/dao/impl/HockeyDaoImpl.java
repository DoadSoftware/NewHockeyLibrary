package com.hockey.dao.impl;

import java.util.Collections;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
import com.hockey.util.HockeyUtil;

@Transactional
@Repository("hockeyDao")
public class HockeyDaoImpl implements HockeyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Player getPlayer(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

            case HockeyUtil.PLAYER:

                return sessionFactory.getCurrentSession()
                        .createQuery(
                                "from Player WHERE playerId = :playerId",
                                Player.class)
                        .setParameter(
                                "playerId",
                                Integer.valueOf(valueToProcess))
                        .uniqueResult();

            default:
                return null; // single object, so null
        }
    }

    @Override
    public Team getTeam(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

            case HockeyUtil.TEAM:

                return sessionFactory.getCurrentSession()
                        .createQuery(
                                "from Team WHERE teamId = :teamId",
                                Team.class)
                        .setParameter(
                                "teamId",
                                Integer.valueOf(valueToProcess))
                        .uniqueResult();

            default:
                return null;
        }
    }

    @Override
    public List<NameSuper> getNameSupers() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from NameSuper",
                        NameSuper.class)
                .getResultList();
    }

    @Override
    public List<Team> getTeams() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Team",
                        Team.class)
                .getResultList();
    }

    @Override
    public List<Player> getPlayers(
            String whatToProcess,
            String valueToProcess) {

        switch (whatToProcess) {

            case HockeyUtil.TEAM:

                return sessionFactory.getCurrentSession()
                        .createQuery(
                                "from Player WHERE teamId = :teamId",
                                Player.class)
                        .setParameter(
                                "teamId",
                                Integer.valueOf(valueToProcess))
                        .getResultList();

            default:
                return Collections.emptyList(); // list, so empty list
        }
    }

    @Override
    public List<Bugs> getBugs() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Bugs",
                        Bugs.class)
                .getResultList();
    }

    @Override
    public List<Ground> getGrounds() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Ground",
                        Ground.class)
                .getResultList();
    }

    @Override
    public List<Playoff> getPlayoffs() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Playoff",
                        Playoff.class)
                .getResultList();
    }

    @Override
    public List<VariousText> getVariousTexts() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from VariousText",
                        VariousText.class)
                .getResultList();
    }

    @Override
    public Ground getGround(int ground_id) {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Ground WHERE groundId = :groundId",
                        Ground.class)
                .setParameter(
                        "groundId",
                        ground_id)
                .uniqueResult();
    }

    @Override
    public List<Statistics> getAllStats() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Statistics",
                        Statistics.class)
                .getResultList();
    }

    @Override
    public List<Player> getAllPlayer() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Player",
                        Player.class)
                .getResultList();
    }

    @Override
    public List<Fixture> getFixtures() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Fixture",
                        Fixture.class)
                .getResultList();
    }

    @Override
    public List<Formation> getFormations() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Formation",
                        Formation.class)
                .getResultList();
    }

    @Override
    public List<TeamColor> getTeamColors() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from TeamColor",
                        TeamColor.class)
                .getResultList();
    }

    @Override
    public List<Staff> getStaff() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Staff",
                        Staff.class)
                .getResultList();
    }

    @Override
    public List<Officials> getOfficials() {

        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Officials",
                        Officials.class)
                .getResultList();
    }
}