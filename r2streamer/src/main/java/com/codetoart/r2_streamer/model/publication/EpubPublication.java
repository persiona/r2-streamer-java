package com.codetoart.r2_streamer.model.publication;

import android.support.annotation.Nullable;

import com.codetoart.r2_streamer.model.publication.link.Link;
import com.codetoart.r2_streamer.model.publication.metadata.MetaData;
import com.codetoart.r2_streamer.model.tableofcontents.ToC;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shrikant Badwaik on 25-Jan-17.
 */

public class EpubPublication {
    @JsonProperty("metadata")
    public MetaData metadata;
    @JsonProperty("toc")
    public ToC tableOfContents;

    @JsonIgnore
    public Map<String,Link> linkMap;
    @JsonProperty("links")
    public List<Link> links;
    @JsonIgnore
    public List<Link> matchingLinks;
    @JsonProperty("spines")
    public List<Link> spines;
    @JsonProperty("resources")
    public List<Link> resources;
    @JsonIgnore
    public List<Link> guides;

    //public List<Link> pageList;
    @JsonIgnore
    public Link[] pageList;
    @JsonIgnore
    //public List<Link> landmarks;
    public Link[] landmarks;
    @JsonIgnore
    //public List<Link> LOI;
    public Link[] LOI;
    @JsonIgnore
    //public List<Link> LOA;
    public Link[] LOA;
    @JsonIgnore
    //public List<Link> LOV;
    public Link[] LOV;
    @JsonIgnore
    //public List<Link> LOT;
    public Link[] LOT;

    public Map<String, String> internalData;

    @JsonIgnore
    //public List<Link> otherLinks;
    public Link[] otherLinks;

    @JsonProperty("cover")
    public Link coverLink;

    public EpubPublication() {
        this.matchingLinks = new ArrayList<>();
        this.links = new ArrayList<>();
        this.spines = new ArrayList<>();
        this.resources = new ArrayList<>();
        this.guides= new ArrayList<>();
        this.internalData = new HashMap<>();

        this.linkMap = new HashMap<>();
    }

    public EpubPublication(MetaData metadata, List<Link> links, List<Link> matchingLinks, List<Link> spines, List<Link> resources, List<Link> guides, ToC tableOfContents, Link[] pageList, Link[] landmarks, Link[] LOI, Link[] LOA, Link[] LOV, Link[] LOT, HashMap<String, String> internalData, Link[] otherLinks, Link coverLink) {
        this.metadata = metadata;
        this.links = links;
        this.matchingLinks = matchingLinks;
        this.spines = spines;
        this.resources = resources;
        this.guides = guides;
        this.tableOfContents = tableOfContents;
        this.pageList = pageList;
        this.landmarks = landmarks;
        this.LOI = LOI;
        this.LOA = LOA;
        this.LOV = LOV;
        this.LOT = LOT;
        this.internalData = internalData;
        this.otherLinks = otherLinks;
        this.coverLink = coverLink;
    }

    public Link getCoverLink() {
        return getLink("cover");
    }

    @Nullable
    private Link getLink(String coverPath) {
        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).rel.equals(coverPath)) {
                return links.get(i);
            }
        }
        return null;
    }

    public Link getResourceMimeType(String resourcePath) {
        /*for (int i = 0; i < links.size(); i++) {
            if (links.get(i).href.equals(resourcePath)) {
                return links.get(i);
            }
        }*/

        if(linkMap.containsKey(resourcePath)){
            return linkMap.get(resourcePath);
        }

        return null;
    }
}