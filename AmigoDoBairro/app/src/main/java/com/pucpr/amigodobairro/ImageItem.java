package com.pucpr.amigodobairro;

public class ImageItem {
    private final String imageName;
    private final String message;

    public ImageItem(String imageName, String message) {
        this.imageName = imageName;
        this.message = message;
    }

    public String getImageName() {
        return imageName;
    }

    public String getMessage() {
        return message;
    }
}
