package com.company;
import java.util.Date;
import java.util.Objects;

public class Metadata {
    private String name;
    private int type;
    private String location;
    private int width, height;
//    private long size;
    private Date createdDate;

    public Metadata() {
        name = "";
        type = 0;
        location = "";
        width = 0;
        height = 0;
//        size = 0;
        createdDate = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metadata)) return false;
        Metadata metadata = (Metadata) o;
        return type == metadata.type &&
                width == metadata.width &&
                height == metadata.height &&
//                size == metadata.size &&
                Objects.equals(name, metadata.name) &&
                Objects.equals(location, metadata.location) &&
                Objects.equals(createdDate, metadata.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, location, width, height, createdDate);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

//    public void setSize(long size) {
//        this.size = size;
//    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public long getSize() {
        return width * height;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
