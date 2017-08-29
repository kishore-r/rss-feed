/************************************************************************
 *                                                                      *
 *                                                                      *
 *                                                                      *
 *  (c) Copyright by  - all rights reserved                             *
 *                                                                      *
 ************************************************************************
 *
 * Initial Creation:
 *    Author      rak
 *    Created on  Aug 28, 2017
 *
 ************************************************************************/
package com.speeda.rss.model;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private String pubDate;
    private final List<FeedMessage> feedMessages = new ArrayList<FeedMessage>();

    public Feed(String title, String link, String description, String language, String copyright, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    public Feed() {
        // TODO Auto-generated constructor stub
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the link.
     */
    public String getLink() {
        return link;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the copyright.
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the pubDate.
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param link The link to set.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param language The language to set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param copyright The copyright to set.
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param pubDate The pubDate to set.
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the feedMessages.
     */
    public List<FeedMessage> getFeedMessages() {
        return feedMessages;
    }

}
