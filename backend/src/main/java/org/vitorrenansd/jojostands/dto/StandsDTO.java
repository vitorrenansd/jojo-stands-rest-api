package org.vitorrenansd.jojostands.dto;

public class StandsDTO {
    private String stand;
    private String user;
    private String imageUrl;

    
    public StandsDTO(String stand, String user, String imageUrl) {
        this.stand = stand;
        this.user = user;
        this.imageUrl = imageUrl;
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

    public void setStand(String stand) {
        this.stand = stand;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}