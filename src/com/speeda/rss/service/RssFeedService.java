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
package com.speeda.rss.service;

import com.speeda.rss.model.Feed;

/**
 * COMMENT - Add description of this class or interface here. 
 */
public interface RssFeedService {
    /**
     * Reads RSS feeds from the supplied URL. 
     *
     * @param url
     * @return Feed
     */
    Feed readFeed(String url);

    /**
     * Creates a RSS Feed based on the supplied name using the provided Feed. 
     *
     * @param feedName String
     * @param rssfeed Feed
     */
    void writeFeed(String feedName, Feed rssfeed);

}
