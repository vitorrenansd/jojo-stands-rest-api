package org.vitorrenansd.jojostands.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stand")
public class StandsAPI {
    private final StandsFacade standsFacade;

    @Autowired
    public StandsAPI(StandsFacade standsFacade) {
        this.standsFacade = standsFacade;
    }

    @GetMapping
    public StandsDTO getRandom() {
        return standsFacade.getRandom();
    }
    
    @GetMapping("/all")
    public List<StandsDTO> getAll() {
        return standsFacade.getAll();
    }
}