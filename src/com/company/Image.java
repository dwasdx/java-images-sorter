package com.company;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image implements Comparable<Image> {

    private Metadata metadata;
    private BufferedImage image;

    public Image(File file) throws Exception {
        image = ImageIO.read(file);
        metadata = new Metadata();
        metadata.setName(file.getName());
        metadata.setCreatedDate(new Date(file.lastModified()));
        int width = image.getWidth();
        int height = image.getHeight();
        metadata.setType(image.getType());
        metadata.setWidth(width);
        metadata.setHeight(height);
//        metadata.setSize(file.length());
    }

    public Image(String path) throws Exception {
        this(new File(path));
    }

    public Image(BufferedImage image) {
        this.image = image;
        metadata = new Metadata();
        metadata.setType(image.getType());
        metadata.setWidth(image.getWidth());
        metadata.setHeight(image.getHeight());
//        metadata.setSize(image.getHeight() * image.getWidth());
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public Pixel getRGBA_at(int x, int y) {
        int pixel = image.getRGB(x, y);
        return new Pixel(pixel);
    }

    private Image scaleGivenImageToSize(Image given, int height, int width) {
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = scaledImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(given.image, 0, 0, width, height, null);
        g2.dispose();
        return new Image(scaledImage);
    }

    public double calculateDistance(Image rhs) {
        double rgbScaler = 765;
        double d = 0;

        rhs = scaleGivenImageToSize(rhs, metadata.getHeight(), metadata.getWidth());
        Metadata rhsMetadata = rhs.getMetadata();
        rhsMetadata.setWidth(metadata.getWidth());
        rhsMetadata.setHeight(metadata.getHeight());
//        rhsMetadata.setSize(rhs.metadata.getSize());
        for (int i = 0; i < rhsMetadata.getHeight(); i++) {
            for (int j = 0; j < rhsMetadata.getWidth(); j++) {
//                System.out.println("i - " + i);
//                System.out.println("j - " + j);
                Pixel lPixel = this.getRGBA_at(j, i);
                Pixel rPixel = rhs.getRGBA_at(j, i);
                d += (double)Math.abs(lPixel.getRGB_sum() - rPixel.getRGB_sum()) / rgbScaler;
            }
        }
        return 1 - d;
    }

    @Override
    public int compareTo(Image rhs) {
        double d = calculateDistance(rhs);
        return (int)Math.round(d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image1 = (Image) o;
        return Objects.equals(metadata, image1.metadata) &&
                image.equals(image1.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, image);
    }
}
