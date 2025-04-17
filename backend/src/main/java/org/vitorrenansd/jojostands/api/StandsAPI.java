package org.vitorrenansd.jojostands.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling the JoJo Stand API endpoints.
 * <p>
 * This class exposes RESTful API endpoints to interact with JoJo stands. It allows clients to fetch a random stand or a list of all available stands.
 * The endpoints interact with the StandsFacade to retrieve the necessary data.
 * </p>
 * 
 * <p>
 * Available endpoints:
 * </p>
 * <ul>
 *   <li><code>/stand</code> - Returns a random JoJo stand.</li>
 *   <li><code>/stand/all</code> - Returns a list of all available JoJo stands.</li>
 * </ul>
 * @author vitorrenansd
 * @since 2025-04-15
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StandsAPI {
    private final StandsFacade standsFacade;

    @Autowired
    public StandsAPI(StandsFacade standsFacade) {
        this.standsFacade = standsFacade;
    }

    // IP:PORT/random
    @GetMapping(value = "/random")
    public StandsDTO getRandom() {
        return standsFacade.getRandom();
    }
    
    // IP:PORT/all
    @GetMapping(value = "/all")
    public List<StandsDTO> getAll() {
        return standsFacade.getAll();
    }
}