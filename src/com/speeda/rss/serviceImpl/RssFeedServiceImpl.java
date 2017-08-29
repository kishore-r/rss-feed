/************************************************************************
 *                                                                      *
 *                                                                      *
 *  (c) Copyright by  all rights reserved                               *
 *                                                                      *
 ************************************************************************
 *
 * Initial Creation:
 *    Author      rak
 *    Created on  Aug 28, 2017
 *
 ************************************************************************/
package com.speeda.rss.serviceImpl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.speeda.rss.model.Feed;
import com.speeda.rss.model.FeedEnum;
import com.speeda.rss.model.FeedMessage;
import com.speeda.rss.service.RssFeedService;
import com.speeda.rss.util.RssFeedUtil;

/**
 * COMMENT - Add description of this class or interface here. 
 * 
 */
public class RssFeedServiceImpl extends AbstractRssFeed implements RssFeedService {
    protected XMLInputFactory inputFactory;
    protected InputStream in;
    protected XMLEventReader eventReader;
    protected XMLOutputFactory outputFactory;
    protected XMLEventWriter eventWriter;

    @Override
    public Feed readFeed(String url) {

        Feed feed = new Feed();
        int feedMEsageCount = 0;
        try {
            final URL readUrlPath = new URL(url);

            // First create a new XMLInputFactory
            inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            in = RssFeedUtil.getInputStream(readUrlPath);
            eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            FeedMessage feedMessage = new FeedMessage();
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();
                    FeedEnum feedEnum = null;
                    try {
                        feedEnum = FeedEnum.valueOf(localPart.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        continue;
                    }

                    if (feedEnum != null) {
                        readRssNodes(feed, feedMessage, event, feedEnum);
                    }

                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equals((FeedEnum.ITEM.toString().toLowerCase()))) {
                        feedMessage.setFeedNo(++feedMEsageCount);
                        feed.getFeedMessages().add(feedMessage);
                        feedMessage = new FeedMessage();
                        event = eventReader.nextEvent();
                        continue;
                    }
                }
            }
        } catch (XMLStreamException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    /**
     * Reads RSS Feed nodes such as ITEM, TITLE, DESCRIPTION, LINK, GUID, LANGUAGE, AUTHOR, COPYRIGHT. 
     *
     * @param feed Feed
     * @param feedMessage FeedMessage
     * @param event XMLEvent
     * @param feedEnum FeedEnum
     * @throws XMLStreamException
     */
    protected void readRssNodes(Feed feed, FeedMessage feedMessage, XMLEvent event, FeedEnum feedEnum) throws XMLStreamException {
        switch (feedEnum) {
            case ITEM:
                // header 
                event = eventReader.nextEvent();
                break;
            case TITLE:
                feedMessage.setTitle(RssFeedUtil.getCharacterData(event, eventReader));
                break;
            case DESCRIPTION:
                feedMessage.setDescription(RssFeedUtil.getDescriptionData(event, eventReader));
                break;
            case LINK:
                feedMessage.setLink(RssFeedUtil.getCharacterData(event, eventReader));
                break;
            case GUID:
                feedMessage.setGuid(RssFeedUtil.getCharacterData(event, eventReader));
                break;
            case LANGUAGE:
                feed.setLanguage(RssFeedUtil.getCharacterData(event, eventReader));
                break;
            case AUTHOR:
                feedMessage.setAuthor(RssFeedUtil.getCharacterData(event, eventReader));
                break;
            case COPYRIGHT:
                feed.setCopyright(RssFeedUtil.getCharacterData(event, eventReader));
                break;
            default:
                break;
        }
    }

    @Override
    public void writeFeed(String url, Feed rssfeed) {

        try {
            // create a XMLOutputFactory
            outputFactory = XMLOutputFactory.newInstance();

            // create XMLEventWriter
            eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(url));

            // create a EventFactory
            eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");

            // create and write Start Tag
            StartDocument startDocument = eventFactory.createStartDocument();

            eventWriter.add(startDocument);

            // create open tag
            eventWriter.add(end);

            createRssNodes(rssfeed, end, eventWriter);

            eventWriter.close();
        } catch (Exception e) {

        }

    }

    /**
     * created XML nodes for RSS feed and RessFedd messages . 
     * 
     * @param  eventWriter XMLEventWriter
     * @param rssfeed Feed
     * @param end XMLEvent
     * @throws XMLStreamException
     */
    protected void createRssNodes(Feed rssfeed, XMLEvent end, XMLEventWriter eventWriter) throws XMLStreamException {
        StartElement rssStart = eventFactory.createStartElement("", "", "rss");
        eventWriter.add(rssStart);
        eventWriter.add(eventFactory.createAttribute("version", "2.0"));
        eventWriter.add(end);

        eventWriter.add(eventFactory.createStartElement("", "", "channel"));
        eventWriter.add(end);

        createFeedInfo(rssfeed, eventWriter);

        for (FeedMessage entry : rssfeed.getFeedMessages()) {
            eventWriter.add(eventFactory.createStartElement("", "", "item"));
            eventWriter.add(end);
            createNode(eventWriter, "title", entry.getTitle());
            createNode(eventWriter, "description", entry.getDescription());
            createNode(eventWriter, "link", entry.getLink());
            createNode(eventWriter, "author", entry.getAuthor());
            createNode(eventWriter, "guid", entry.getGuid());
            eventWriter.add(end);
            eventWriter.add(eventFactory.createEndElement("", "", "item"));
            eventWriter.add(end);
        }

        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "channel"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "rss"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndDocument());
    }

    /**
     * Creates  basic RSS nodes for "Title" , "Link" , "Description", "Language", "Copyright",
     *
     * @param rssfeed Feed
     * @param eventWriter  XMLEventWriter
     * @throws XMLStreamException
     */
    protected void createFeedInfo(Feed rssfeed, XMLEventWriter eventWriter) throws XMLStreamException {

        createNode(eventWriter, FeedEnum.TITLE.toString().toLowerCase(), rssfeed.getTitle());
        createNode(eventWriter, FeedEnum.LINK.toString().toLowerCase(), rssfeed.getLink());
        createNode(eventWriter, FeedEnum.DESCRIPTION.toString().toLowerCase(), rssfeed.getDescription());
        createNode(eventWriter, FeedEnum.LANGUAGE.toString().toLowerCase(), rssfeed.getLanguage());
        createNode(eventWriter, FeedEnum.COPYRIGHT.toString().toLowerCase(), rssfeed.getCopyright());

    }
}