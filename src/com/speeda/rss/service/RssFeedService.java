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
     * Method is incomplete, need more simplification to make it concrete method.
     *
     * @param feedName String
     * @param rssfeed Feed
     */
    void writeFeed(String feedName, Feed rssfeed);

}
