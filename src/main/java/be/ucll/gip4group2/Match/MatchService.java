package be.ucll.gip4group2.Match;

import be.ucll.gip4group2.Utils.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> findAll() {return matchRepository.findAll(); }

    public Match updateMatch(long id, Match m){
        Optional<Match> match = matchRepository.findById(id);
        if(match.isPresent()){
            match.get().setPlaceName(m.getPlaceName());
            match.get().setTeam1(m.getTeam1());
            match.get().setTeam2(m.getTeam2());
            matchRepository.save(match.get());
            return match.get();
        }
        throw new UnprocessableEntityException("Match already exists");
    }

    public void add(Match match){
        List<Match> matchList = matchRepository.findAll();
        for (Match currentMatch: matchList){
            if (currentMatch.getId().equals(match.getId())){
                throw new UnprocessableEntityException("Match already exisist.");
            }
        }
        matchRepository.save(match);
    }

    public Optional<Match> findById(long id) {return matchRepository.findById(id);}

    public void removeMatch(Match match) {matchRepository.delete(match);}
}
