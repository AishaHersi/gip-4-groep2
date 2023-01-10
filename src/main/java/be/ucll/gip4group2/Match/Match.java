package be.ucll.gip4group2.Match;

import be.ucll.gip4group2.Player.Person;
import be.ucll.gip4group2.Team.Team;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String placeName;

    @OneToOne
    private Team team1;

    @OneToOne
    private Team team2;

    @OneToMany
    @JoinColumn(name = "goals")
    private List<Person> goals;

    String date;

    public Match(){}

    public Match(Long id, String placeName, Team team1, Team team2,List<Person> goals_t1,String date) {
        this.id = id;
        this.placeName = placeName;
        this.team1 = team1;
        this.team2 = team2;
        this.goals = goals;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public List<Person> getGoals() {
        return goals;
    }

    public void setGoals(List<Person> goals) {
        this.goals = goals;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
