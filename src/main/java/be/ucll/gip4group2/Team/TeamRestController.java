package be.ucll.gip4group2.Team;

import be.ucll.gip4group2.Player.Person;
import be.ucll.gip4group2.Player.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class TeamRestController {

    @Autowired
    private TeamService teamService;


    //manager stories = team naam aanmaken / wijzigen
    @PutMapping("/team/{tid}")
    public void updateTeamNaam(@PathVariable("tid") long tid, @RequestBody Team team){
        teamService.updateTeam(tid ,team);
    }


    //manager stories = spelers toevoegen aan het team
    @PutMapping("/team/addPlayer/{tid}/{pid}")
    public void addPlayer(@PathVariable("tid") long tid, @PathVariable("pid") Long pid){
        teamService.addPlayer(pid,tid);
    }


    //manager stories = spelers toevoegen aan het reserve team
    @PutMapping("/team/addReservePlayer/{tid}/{pid}")
    public void addReservePlayer(@PathVariable("tid") long tid, @PathVariable("pid") Long pid){
        teamService.addReservePlayer(pid,tid);
    }

    //manager stories = speler verwijderen uit het team
    @PutMapping("/team/delPlayer/{tid}/{pid}")
    public void delPlayer(@PathVariable("tid") long tid, @PathVariable("pid") Long pid){
        teamService.delPlayer(pid,tid);
    }

    //manager stories = speler verwijderen uit het reserve team
    @PutMapping("/team/delResPlayer/{tid}/{pid}")
    public void delResPlayer(@PathVariable("tid") long tid, @PathVariable("pid") Long pid){
        teamService.delResPlayer(pid,tid);
    }

    @PutMapping("/team/updatemanager/{tid}/{pid}")
    public void updateTeamManager(@PathVariable("tid") long tid, @PathVariable("pid") Long pid){
        teamService.updateTeamManager(pid,tid);
    }

    @PutMapping("/team/promoteResPlayersToActivePlayer/{tid}/{pid}")
    public void promoteResPlayerToActivePlayer(@PathVariable("tid")long tid, @PathVariable("pid") Long pid){
        teamService.promoteResPlayerToActivePlayer(pid,tid);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/team")
    public Team addTeam(@RequestBody Team team){
        teamService.add(team);
        return team;
    }

    @GetMapping("/team/{id}")
    public Optional<Team> getTeamById(@PathVariable long id){
        return teamService.findById(id);
    }

    @GetMapping("/team/players/{id}")
    public List<Person> getPlayers(@PathVariable long id){
        return teamService.findById(id).get().getPlayers();
    }

    @GetMapping("/team/Resplayers/{id}")
    public List<Person> getResPlayers(@PathVariable long id){
        return teamService.findById(id).get().getReservePlayers();
    }


    //manager stories = teams oplijsten
    @RequestMapping("/team")
    public Iterable<Team> getTeams(){return teamService.findAll();}

    @DeleteMapping("/team/{id}")
    public void removeTeam(@RequestBody Team team) {
        teamService.removeTeam(team);
    }
}
