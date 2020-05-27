package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Image i1 = new Image("album_cover.png");
        Image i2 = new Image("alone.jpg");
        Image i3 = new Image("cat.jpg");
        Image i4 = new Image("crosses.jpeg");
        Image i5 = new Image("flowers.jpg");
        Image i6 = new Image("view.jpg");
        ImagesCollection collection = new ImagesCollection();
        collection.add(i1);
        collection.add(i2);
        collection.add(i3);
        collection.add(i4);
        collection.add(i5);
        collection.add(i6);

        System.out.println("Sorting by name");
        var arr = collection.sortedByName();
        for (Image image : arr) {
            System.out.println(image.getMetadata().getName());
        }
        System.out.println("");

        System.out.println("Sorting by date");
        arr = collection.sortedByDate();
        for (Image image : arr) {
            System.out.println(image.getMetadata().getName() + " " + image.getMetadata().getCreatedDate().toString());
        }
        System.out.println("");

        System.out.println("Sorting by size");
        arr = collection.sortedBySize();
        for (Image image : arr) {
            System.out.println(image.getMetadata().getName() + " " + image.getMetadata().getSize());
        }
        System.out.println("");

        //sorting from farest to closest
        System.out.println("Sorting by distance");
        arr = collection.sortedByDistance(i2);
        for (Image image : arr) {
            System.out.println(image.getMetadata().getName());
        }
    }
}
