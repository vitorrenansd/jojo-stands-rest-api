package org.vitorrenansd.jojostands.dto;

public class StandsDTO {
    private String stand;
    private String user;
    private String imageUrl;
    private String videoUrl;

    
    public StandsDTO(String stand, String user, String imageUrl, String videoUrl) {
        this.stand = stand;
        this.user = user;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

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