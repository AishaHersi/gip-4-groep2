package be.ucll.gip4group2.Match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class MatchRestController {

    @Autowired
    public MatchService matchService;

    @PutMapping("/match/{id}")
    public void updateMatch(@PathVariable long id, @RequestBody Match match){
        matchService.updateMatch(id,match);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/match")
    public Match addMatch(@RequestBody Match match){
        matchService.add(match);
        return match;
    }

    @GetMapping("/match/{id}")
    public Optional<Match> getMatchById(@PathVariable long id) {
        return matchService.findById(id);
    }

    @RequestMapping("/match")
    public Iterable<Match> getMatches() {
        return matchService.findAll();
    }

    @DeleteMapping("/match/{id}")
    public void removeMatch(@RequestBody Match match){
        matchService.removeMatch(match);
    }
}
