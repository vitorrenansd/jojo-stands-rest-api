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
        standList.add(new StandsDTO("The World", "Dio Brando", "https://pbs.twimg.com/media/E92GkgKWUAAc4RJ.png", "https://youtu.be/NRBqnKjJ8AE"));
        standList.add(new StandsDTO("Crazy Diamond", "Josuke Higashikata", "https://pbs.twimg.com/media/E92GkgKWUAAc4RJ.png", "https://www.youtube.com/watch?v=Fv6rBVEko80"));
        standList.add(new StandsDTO("Killer Queen", "Yoshikage Kira", "https://pm1.aminoapps.com/6328/280c29bb62deb94d84f7fcdad4518d04b1235458_00.jpg", "https://www.youtube.com/watch?v=fiwcZ0pg3xM"));
        standList.add(new StandsDTO("Gold Experience", "Giorno Giovanna", "https://p2.trrsf.com/image/fget/cf/1200/900/middle/images.terra.com/2023/10/11/654708523-06133356799254.jpg", "https://youtu.be/W944vHnaQPw?t=13"));
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