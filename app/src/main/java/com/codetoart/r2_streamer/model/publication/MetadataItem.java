package com.codetoart.r2_streamer.model.publication;

import java.util.List;

/**
 * Created by Shrikant on 25-Jan-17.
 */

public class MetadataItem {
    private String property;
    private String value;
    //private List<MetadataItem> children;
    private MetadataItem[] children;

    public MetadataItem() {
    }

    public MetadataItem(String property, String value, MetadataItem[] children) {
        this.property = property;
        this.value = value;
        this.children = children;
    }
}