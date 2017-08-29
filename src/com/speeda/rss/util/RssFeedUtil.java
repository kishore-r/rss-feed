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
 * COMMENT - Add description of this class or interface here. 
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
     * COMMENT - Enter concise description of the method's purpose. 
     * 
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
            RssFeedUtil.printToStandardOut(result);
        }
        return result;
    }

    /**
     * COMMENT - Enter concise description of the method's purpose. 
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
     * COMMENT - Enter concise description of the method's purpose. 
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
     * COMMENT - Enter concise description of the method's purpose. 
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
