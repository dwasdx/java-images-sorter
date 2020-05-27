package com.company;

import java.util.Objects;

public class Pixel {
    private int r, g, b, alpha;

    public Pixel(int rgb) {
        alpha = (rgb >> 24) & 0xff;
        r = (rgb >> 16) & 0xff;
        g = (rgb >> 8) & 0xff;
        b = (rgb) & 0xff;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getAlpha() {
        return alpha;
    }

    public int getRGB_sum() { return r + g + b; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pixel)) return false;
        Pixel pixel = (Pixel) o;
        return r == pixel.r &&
                g == pixel.g &&
                b == pixel.b &&
                alpha == pixel.alpha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b, alpha);
    }
}
