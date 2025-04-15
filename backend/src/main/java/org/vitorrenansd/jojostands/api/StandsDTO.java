package org.vitorrenansd.jojostands.api;

/**
 * Data Transfer Object (DTO) for representing a JoJo stand.
 * <p>
 * This class encapsulates the data for a JoJo stand, including the stand name, user, image URL, and video URL.
 * It is used to transfer stand data between different layers of the application, such as from the service to the API controller.
 * </p>
 * 
 * @author vitorrenansd
 * @since 2025-04-15
 */
public class StandsDTO {
    private String stand;
    private String user;
    private String imageUrl;
    private String videoUrl;


    public StandsDTO() {}

    public String getStand() {
        return this.stand;
    }
    public String getUser() {
        return this.user;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}