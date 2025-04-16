package org.vitorrenansd.jojostands.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service class responsible for handling the business logic related to JoJo stands.
 * <p>
 * This class loads the stand data from a JSON file, provides methods to retrieve all stands, get a random stand, and add new stands.
 * It manages the list of stands through the StandsDTO objects and is used by the StandsAPI to fetch the necessary data for the API endpoints.
 * </p>
 * 
 * @author vitorrenansd
 * @since 2025-04-15
 */
@Service
public class StandsFacade {
    private final List<StandsDTO> standList = new ArrayList<>();

    public StandsFacade() {
        try {
            // Loads array standList with the values inside stands.json
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("stands.json").getInputStream();
            List<StandsDTO> loadedList = mapper.readValue(inputStream, new TypeReference<List<StandsDTO>>() {});
            standList.addAll(loadedList);
        } catch (IOException e) {
            e.printStackTrace(); // Syntax error, null, etc
        }
    }

    // Get all Stands from stands.json
    public List<StandsDTO> getAll() {
        return standList;
    }

    // Get a random Stand from stands.json
    public StandsDTO getRandom() {
        if (standList.isEmpty()) {
            return null;
        }
        return standList.get(new Random().nextInt(standList.size())); // .nextInt() = 0 to N
    }
}