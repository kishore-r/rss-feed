import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.speeda.rss.model.Feed;
import com.speeda.rss.model.FeedMessage;
import com.speeda.rss.service.RssFeedService;
import com.speeda.rss.serviceImpl.AbstractRssFeed;
import com.speeda.rss.serviceImpl.RssFeedServiceImpl;
import com.speeda.rss.util.RssFeedUtil;

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

public class RessFeedServiceImplTest {

    @Test
    public void testReadFeed() {
        RssFeedService rssFeedServiceImpl = new RssFeedServiceImpl();
        Feed feed = rssFeedServiceImpl.readFeed(RssFeedUtil.READ_URL);
        ((AbstractRssFeed)rssFeedServiceImpl).displayFeedDetails(feed);
        for (FeedMessage message : feed.getFeedMessages()) {
            ((AbstractRssFeed)rssFeedServiceImpl).displayFeedMessage(message);
        }
        assertTrue(feed.getGenerator().equals("Hatena::Blog"));
        assertTrue(feed.getTitle().equals("UZABASE Tech Blog"));
        assertTrue(feed.getLink().equals("http://tech.uzabase.com/"));
        assertTrue(feed.getFeedMessages().get(0).getTitle().contains("Docker Container"));
    }

    /**
     * RSS named "test-rss.rss" should be created in the root folder. 
     *
     */
    @Test
    public void testWriteFeed() {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        Feed feed = new Feed();
        feed.setTitle("test rss feed creation");
        feed.setLink("http://tech.uzabase.com");
        feed.setDescription("Test description for the feed");
        format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        feed.setLastBuildDate(format.format(curDate));
        feed.setDocs("http://blogs.law.harvard.edu/tech/rss");
        feed.setGenerator("Kishore Ravi");
        for (int i = 0; i < 5; i++) {
            curDate = new Date();
            FeedMessage feedMessage = new FeedMessage();
            feedMessage.setTitle("Feed Message: " + i);
            feedMessage.setLink("Test Link: " + i);
            feedMessage.setDescription("Test Description: " + i);
            feedMessage.setPubDate(format.format(curDate));
            feedMessage.setGuid("Test guid: " + i);
            feedMessage.setEnclosure("Test Enclosure: " + i);
            feed.getFeedMessages().add(feedMessage);
        }
        try {
            RssFeedService rssFeedServiceImpl = new RssFeedServiceImpl();
            rssFeedServiceImpl.writeFeed("test-rss.rss", feed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
