package com.sourboatlife.ui.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 11/27/2016.
 */
public class Episode {
    private String link;
    private List<String> tags;
    private String title;
    private String description;
    private ZonedDateTime originalAirDate;

    protected Episode() {}

    public String getLink() {
        return link;
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

    public ZonedDateTime getOriginalAirDate() {
        return originalAirDate;
    }

    public static class Builder {
        private String link;
        private List<String> tags = new ArrayList<>();
        private String title;
        private String description;
        private ZonedDateTime originalAirDate;

        public Episode build()
        {
            Episode episode = new Episode();
            episode.title = this.title;
            episode.link = link;
            episode.tags = tags;
            episode.description = description;
            episode.originalAirDate = originalAirDate;
            return episode;
        }

        public Builder withTitle(String t)
        {
            this.title = t;
            return this;
        }

        public Builder withLink(String link) {
            this.link = link;
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