package workamerica.contexts.candidates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workamerica.contexts.candidates.components.CandidateComponent;
import workamerica.contexts.candidates.entities.Candidate;
import workamerica.contexts.candidates.repository.CandidateRepository;

/**
 * Created by Faizan on 8/2/2016.
 */
@RestController
@RequestMapping("/candidates")
public class CandidateRestController {

    @Autowired
    CandidateComponent component;

    @RequestMapping(value = "/{candidateID}", method = RequestMethod.GET)
    public ResponseEntity<Candidate> getByID(@PathVariable Long candidateID) {
        Candidate candidate = component.findByID(candidateID);
        return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
    }

    @RequestMapping(value = "/certification", method = RequestMethod.PUT)
    void updateCertification(@RequestParam Long certificationID, @RequestParam String certificationName) {
    }

    @RequestMapping(value = "/{candidateID}/{fieldID}", method = RequestMethod.POST)
    void addField(@PathVariable Long fieldID, @PathVariable Long candidateID) {
        component.addField(fieldID, candidateID);
    }

    @RequestMapping(value = "/create",
            headers = {"Content-Type=application/x-www-form-urlencoded",
                    "Content-Type=multipart/form-data"},
            method = RequestMethod.POST)
    public Candidate create (@RequestBody Candidate candidate) {
        component.create(candidate);
        return null;
    }



}
