package org.vitorrenansd.jojostands.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stands")
public class StandsAPI {
    private final StandsFacade standsFacade;

    @Autowired
    public StandsAPI(StandsFacade standsFacade) {
        this.standsFacade = standsFacade;
    }

    @GetMapping
    public List<StandsDTO> getAll() {
        return standsFacade.getAll();
    }

    @GetMapping("/random")
    public StandsDTO getRandom() {
        return standsFacade.getRandom();
    }

    @PostMapping
    public void create(@RequestBody StandsDTO stand) {
        standsFacade.addStand(stand);
    }
}