/************************************************************************
 *                                                                      *
 *                                                                      *
 *  (c) Copyright  all rights reserved                                  *
 *                                                                      *
 ************************************************************************
 *
 * Initial Creation:
 *    Author      rak
 *    Created on  Aug 28, 2017
 *
 ************************************************************************/
package com.speeda.rss.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import com.speeda.rss.model.FeedEnum;

/**
 * Utility class for Rss Feed  related operations. 
 * 
 */
public final class RssFeedUtil {
    /**
     * prevent instantiation of Utility classes 
     * 
     */
    private RssFeedUtil() {

    }

    public static final String READ_URL = "http://tech.uzabase.com/rss";
    private static final String UTF_8_ENCODING = "UTF-8";

    /**
     * Provides character data between nodes . 
     *    <guid isPermalink="false">hatenablog://entry/8599973812279548363</guid>
     *    returns hatenablog://entry/8599973812279548363 for upove nodes
     *
     * @param event
     * @param eventReader
     * @return
     * @throws XMLStreamException
     */
    public static String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            if (event.isStartElement()) {

            }
            result = event.asCharacters().getData();
        }
        return result;
    }

    /**
     * provides data between description nodes . 
     * 
     *
     * @param event
     * @param eventReader
     * @return
     * @throws XMLStreamException
     */
    public static String getDescriptionData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        StringBuilder content = new StringBuilder();
        while (eventReader.hasNext()) {
            event = eventReader.nextEvent();
            if (event.isStartElement()) {
                content = new StringBuilder();
            } else if (event.isEndElement()) {
                if (event.asEndElement().getName().getLocalPart().equals((FeedEnum.DESCRIPTION.toString().toLowerCase()))) {
                    return content.toString();
                }

            } else if (event.isCharacters()) {
                content.append(event.asCharacters().getData());
            }
        }
        return content.toString();
    }

    /**
     * returns an Input Stream for the provided URL. 
     * 
     *
     * @param url
     * @return
     */
    public static InputStream getInputStream(URL url) {
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Alternative static method for System.out.println. 
     * 
     * 
     * @param message
     */
    public static void printToStandardOut(String message) {
        try {
            PrintStream sysout = new PrintStream(System.out, true, UTF_8_ENCODING);
            sysout.println(message);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
