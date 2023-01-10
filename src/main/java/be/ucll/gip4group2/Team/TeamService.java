package be.ucll.gip4group2.Team;

import be.ucll.gip4group2.Player.Person;
import be.ucll.gip4group2.Player.PersonRepository;
import be.ucll.gip4group2.Utils.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.Console;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team updateTeam(long id, Team _team){
        Optional<Team> team = teamRepository.findById(id);

        if (team.isPresent()) {
            team.get().setTeamName(_team.getTeamName());
            team.get().setManager(_team.getManager());
            team.get().setPlayers(_team.getPlayers());
            team.get().setReservePlayers(_team.getReservePlayers());

            teamRepository.save(team.get());
            return team.get();
        } else{
            throw new UnprocessableEntityException("Team already exists.");
        }
    }
    public Team updateTeamManager(long id, long managerid){
        Optional<Team> team = teamRepository.findById(id);
        Optional<Person> manager = personRepository.findById(managerid);

        if (team.isPresent() && manager.isPresent()) {
            team.get().setManager(manager.get());

            teamRepository.save(team.get());
            return team.get();
        } else{
            throw new UnprocessableEntityException("Team already exists.");
        }
    }

    // promote player
    public Team addPlayer(long id, long playerid){
        Optional<Team> team = teamRepository.findById(id);
        Optional<Person> player = personRepository.findById(playerid);

        if (team.isPresent() && player.isPresent()) {
            team.get().addPlayer(player.get());

            teamRepository.save(team.get());
            return team.get();
        } else{
            throw new UnprocessableEntityException("Team already exists.");
        }
    }
    public Team addReservePlayer(long id, long playerid){
        Optional<Team> team = teamRepository.findById(id);
        Optional<Person> player = personRepository.findById(playerid);

        if (team.isPresent() && player.isPresent()) {
            team.get().addReservePlayer(player.get());

            teamRepository.save(team.get());
            return team.get();
        } else{
            throw new UnprocessableEntityException("Team already exists.");
        }
    }

    public Team delPlayer(long id, long playerid){
        Optional<Team> team = teamRepository.findById(id);
        Optional<Person> player = personRepository.findById(playerid);

        if (team.isPresent() && player.isPresent()) {
            team.get().delPlayer(player.get());

            teamRepository.save(team.get());
            return team.get();
        } else{
            throw new UnprocessableEntityException("Team already exists.");
        }

    }public Team delResPlayer(long id, long playerid){
        Optional<Team> team = teamRepository.findById(id);
        Optional<Person> player = personRepository.findById(playerid);

        if (team.isPresent() && player.isPresent()) {
            team.get().delResPlayer(player.get());

            teamRepository.save(team.get());
            return team.get();
        } else{
            throw new UnprocessableEntityException("Team already exists.");
        }
    }

    public Team promoteResPlayerToActivePlayer(long id, long personid){
        Optional<Team> team = teamRepository.findById(id);
        Optional<Person> player = personRepository.findById(personid);

        if (team.isPresent() && player.isPresent()){
            team.get().delResPlayer(player.get());
            team.get().addPlayer(player.get());

            teamRepository.save(team.get());
            return team.get();
        } else {
            throw new UnprocessableEntityException("Team already exists");
        }
    }

    public void add(Team team){
        List<Team> teamList = teamRepository.findAll();

        for(Team currentTeam: teamList){
            if(currentTeam.getId().equals(team.getId())){
                throw new UnprocessableEntityException("Team already exists.");
            }
        }
        teamRepository.save(team);
    }


    public Optional<Team> findById(long id) {return teamRepository.findById(id);}

    public void removeTeam(Team team) {
        teamRepository.delete(team);
    }
}
