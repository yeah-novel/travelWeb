package com.example.travel.domain;

public class Image {
    private long id;
    private String path;
    private String source;
    private long spotId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getSpotId() {
        return spotId;
    }

    public void setSpotId(long spotId) {
        this.spotId = spotId;
    }
}
