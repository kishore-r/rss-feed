/************************************************************************
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

/**
 * . 
 * 
 */
public class FeedMessage {
    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;
    private int feedNo;


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
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
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
     * @return Returns the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the guid.
     */
    public String getGuid() {
        return guid;
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
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @param author The author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param guid The guid to set.
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the feedNo.
     */
    public int getFeedNo() {
        return feedNo;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param feedNo The feedNo to set.
     */
    public void setFeedNo(int feedNo) {
        this.feedNo = feedNo;
    }

}
