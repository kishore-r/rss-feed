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

public class Feed extends AbstractFeedModel {

    private String lastBuildDate;
    private String generator;
    private String docs;
    private final List<FeedMessage> feedMessages = new ArrayList<FeedMessage>();

    public Feed(String title, String link, String description) {
        this.setTitle(title);
        this.setLink(link);
        this.setDescription(description);

    }

    public Feed() {
        // TODO Auto-generated constructor stub
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

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the generator.
     */
    public String getGenerator() {
        return generator;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param generator The generator to set.
     */
    public void setGenerator(String generator) {
        this.generator = generator;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the lastBuildDate.
     */
    public String getLastBuildDate() {
        return lastBuildDate;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param lastBuildDate The lastBuildDate to set.
     */
    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @return Returns the docs.
     */
    public String getDocs() {
        return docs;
    }

    /**
     * COMMENT - Add concise description of this setter method.
     *           Description should go beyond the method name.
     * 
     * @param docs The docs to set.
     */
    public void setDocs(String docs) {
        this.docs = docs;
    }

}
