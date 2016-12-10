package com.sourboatlife.ui.models;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 11/27/2016.
 */
public class Episode {
    private List<String> links;
    private List<String> tags;
    private String title;
    private String description;
    private String originalAirDate;

    protected Episode() {}

    public List<String> getLinks() {
        return links;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginalAirDate() {
        return originalAirDate;
    }

    public static class Builder {
        private List<String> links = new ArrayList<>();
        private List<String> tags = new ArrayList<>();
        private String title;
        private String description;
        private ZonedDateTime originalAirDate;

        public Episode build()
        {
            Episode episode = new Episode();
            episode.title = this.title;
            episode.links = links;
            episode.tags = tags;
            episode.description = description;
            if (originalAirDate != null)
            {
                episode.originalAirDate = originalAirDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            return episode;
        }

        public Builder withTitle(String t)
        {
            this.title = t;
            return this;
        }

        public Builder withLink(String link) {
            this.links.add(link);
            return this;
        }

        public Builder withTag(String tag) {
            this.tags.add(tag);
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withOriginalAirDate(ZonedDateTime originalAirDate) {
            this.originalAirDate = originalAirDate;
            return this;
        }
    }
}