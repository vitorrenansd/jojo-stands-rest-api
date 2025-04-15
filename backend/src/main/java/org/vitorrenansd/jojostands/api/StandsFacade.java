package org.vitorrenansd.jojostands.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class StandsFacade {
    private final List<StandsDTO> standList = new ArrayList<>();

    public StandsFacade() {
        standList.add(new StandsDTO("Star Platinum","Jotaro Kujo", "https://pbs.twimg.com/media/E92GkgKWUAAc4RJ.png", "https://www.youtube.com/watch?v=xvFZjo5PgG0"));
        standList.add(new StandsDTO("The World", "Dio Brando", "https://pbs.twimg.com/media/E92GkgKWUAAc4RJ.png", "https://www.youtube.com/watch?v=xvFZjo5PgG0"));
        standList.add(new StandsDTO("Crazy Diamond", "Josuke Higashikata", "https://pbs.twimg.com/media/E92GkgKWUAAc4RJ.png", "https://www.youtube.com/watch?v=xvFZjo5PgG0"));
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