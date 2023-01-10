package be.ucll.gip4group2.Team;

import be.ucll.gip4group2.Player.Person;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String teamName;


    @OneToOne
    private Person manager;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "players")
    private List<Person> players;

    @OneToMany
    @JoinColumn(name = "reserve_players")
    private List<Person> reservePlayers;

    public Team(){ } //Voor Hibernate

    public Team(String teamName, Person manager, List<Person> players, List<Person> reservePlayers){
        this.teamName = teamName;
        this.manager = manager;
        this.players = players;
        this.reservePlayers = reservePlayers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }


    //functies voor vaste spelers
    public List<Person> getPlayers() {
        return players;
    }

    public void setPlayers(List<Person> player) {
        this.players = player;
    }

    public void addPlayer(Person player){
        List<Person> players = getPlayers();
        players.add(player);
        setPlayers(players);
    }

    public void delPlayer(Person player){
        List<Person> players = getPlayers();
        players.remove(player);
        setPlayers(players);
    }


    public List<Person> getReservePlayers() {
        return reservePlayers;
    }

    public void setReservePlayers(List<Person> reservePlayers) {
        this.reservePlayers = reservePlayers;
    }

    public void addReservePlayer(Person player){
        List<Person> resplayers = getReservePlayers();
        resplayers.add(player);
        setReservePlayers(resplayers);
    }

    public void delResPlayer(Person player){
        List<Person> resplayers = getReservePlayers();
        resplayers.remove(player);
        setReservePlayers(resplayers);
    }

}
