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

@Service
public class StandsFacade {
    private final List<StandsDTO> standList = new ArrayList<>();

    public StandsFacade() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("stands.json").getInputStream();
            List<StandsDTO> loadedList = mapper.readValue(inputStream, new TypeReference<List<StandsDTO>>() {});
            standList.addAll(loadedList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<StandsDTO> getAll() {
        return standList;
    }

    public StandsDTO getRandom() {
        if (standList.isEmpty()) {
            return null;
        }
        return standList.get(new Random().nextInt(standList.size()));
    }

    public void addStand(StandsDTO stand) {
        standList.add(stand);
    }
}