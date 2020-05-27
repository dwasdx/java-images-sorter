package com.company;
import java.util.*;

public class ImagesCollection {
    private ArrayList<Image> array = new ArrayList<>();

    public ImagesCollection(ArrayList<Image> array) {
        this.array = new ArrayList<>(array);
    }

    public ImagesCollection() {
    }

    public void add(Image image) {
        array.add(image);
    }

    public void add(int index, Image image) {
        array.add(index, image);
    }

    public ArrayList<Image> getImages() { return array; }

    public Image get(int index) {
        return array.get(index);
    }

    public Image remove(int index) {
        if (index >= array.size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array.remove(index);
    }

    public void remove(Image image) {
        array.remove(image);
    }

    public ArrayList<Image> sortedByName() {
        array.sort(Comparator.comparing(i -> i.getMetadata().getName()));
        return array;
    }

    public ArrayList<Image> sortedBySize() {
        array.sort(Comparator.comparing(i -> i.getMetadata().getSize()));
        return array;
    }

    public ArrayList<Image> sortedByDate() {
        array.sort(Comparator.comparing(i -> i.getMetadata().getCreatedDate()));
        return array;
    }

    public ArrayList<Image> sortedByDistance(Image image) {
        array.sort(Comparator.comparing(i -> i.calculateDistance(image)));
        return array;
    }

}
