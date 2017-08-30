/************************************************************************
 *                                                                      *
 *  DDDD     SSSS    AAA        Daten- und Systemtechnik Aachen GmbH    *
 *  D   D   SS      A   A       Pascalstrasse 28                        *
 *  D   D    SSS    AAAAA       52076 Aachen-Oberforstbach, Germany     *
 *  D   D      SS   A   A       Telefon: +49 (0)2408 / 9492-0           *
 *  DDDD    SSSS    A   A       Telefax: +49 (0)2408 / 9492-92          *
 *                                                                      *
 *                                                                      *
 *  (c) Copyright by DSA - all rights reserved                          *
 *                                                                      *
 ************************************************************************
 *
 * Initial Creation:
 *    Author      rak
 *    Created on  Aug 29, 2017
 *
 ************************************************************************/
package com.speeda.rss.model;

public class AbstractFeedModel {
    private String title;
    private String link;
    private String description;

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
}
