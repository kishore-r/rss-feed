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
public class FeedMessage extends AbstractFeedModel {
    private String author;
    private String guid;
    private int feedNo;
    private String pubDate;
    private String enclosure;

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
     * @param pubDate The pubDate to set.
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the enclosure.
     */
    public String getEnclosure() {
        return enclosure;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param enclosure The enclosure to set.
     */
    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

}
