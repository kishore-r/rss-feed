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
package com.speeda.rss.serviceImpl;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.speeda.rss.model.Feed;
import com.speeda.rss.model.FeedMessage;
import com.speeda.rss.util.RssFeedUtil;

/**
 * provides display methods for Feed and FeedMesages along with node creation method with an intention that it 
 * can be overridden for specific different use cases. 
 * 
 * 
 */
public abstract class AbstractRssFeed {
    protected XMLEventFactory eventFactory;
    protected XMLEvent end;
    protected XMLEvent tab;
    protected EndElement eElement;
    private static final String[] EXCLUDE_STRING_LIST = { "NewsPicks" };
    protected static String RSS_VERSION = "2.0";

    /**
     * COMMENT - Enter concise description of the method's purpose. 
     * 
     *
     * @param eventWriter
     * @param name
     * @param value
     * @throws XMLStreamException
     */
    protected void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
        eventFactory = XMLEventFactory.newInstance();
        end = eventFactory.createDTD("\n");
        tab = eventFactory.createDTD("\t");
        // create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);
    }

    /**
     * Used for Message filtering , here it excludes occurrences of string "NewsPicks" from the description message. 
     * EXCLUDE_STRING_LIST can be updated /added to add more filtered messages.
     *
     * @param message
     * @return String
     */
    protected String getFilteredDescription(String message) {
        for (String exclude : EXCLUDE_STRING_LIST) {
            message = message.replaceAll(exclude, "");
        }
        return message;
    }

    /**
     * provides display functionality for Feed's basic information such as
     * copy right , language , link , publication date etc... 
     *
     * @param feed
     */
    public void displayFeedDetails(Feed feed) {
        RssFeedUtil.printToStandardOut("---------------------------- FEED INFORMATION -----------------------------------------------------\n");

        RssFeedUtil.printToStandardOut("\n TITLE : " + feed.getTitle() + " \n LINK : " + feed.getLink() + "\n DESCRIPTION : " + feed.getDescription() + "\n LASTBUILDDATE : " + feed.getLastBuildDate() + "\n DOCS : " + feed.getDocs()
            + "\n GENERATOR : " + feed.getGenerator() + "  \n");
        RssFeedUtil.printToStandardOut("-----------------------------------------------------------------------------------------------------");
    }

    /**
     * provides display functionality for Feed Messages basic information such as
     * copy right , language , link , publication date etc...  
     *
     * @param feedMessage
     */
    public void displayFeedMessage(FeedMessage feedMessage) {

        RssFeedUtil.printToStandardOut("--------------------------- " + feedMessage.getFeedNo() + " . FEED MESSAGE  -----------------------------------------");
        RssFeedUtil.printToStandardOut("\n TITLE: " + feedMessage.getTitle() + "\n");
        RssFeedUtil.printToStandardOut("\n LINK: " + feedMessage.getLink() + "\n");
        RssFeedUtil.printToStandardOut("\n DESCRIPTION: " + getFilteredDescription(feedMessage.getDescription()) + "\n");
        RssFeedUtil.printToStandardOut("\n PUBDATE: " + feedMessage.getPubDate() + "\n");
        RssFeedUtil.printToStandardOut("\n GUID: " + feedMessage.getGuid() + "\n");
        RssFeedUtil.printToStandardOut("\n ENCLOSURE: " + feedMessage.getEnclosure() + "\n");
        RssFeedUtil.printToStandardOut("-----------------------------------------------------------------------------------------------------");
    }
}
