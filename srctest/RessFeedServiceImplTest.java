import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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

    }

    public void testWriteFeed() {
        RssFeedServiceImpl rssFeedServiceImpl = new RssFeedServiceImpl();
        String copyright = "Copyright hold by Lars Vogel";
        String title = "Eclipse and Java Information";
        String description = "Eclipse and Java Information";
        String language = "en";
        String link = "http://www.vogella.com";
        Calendar cal = new GregorianCalendar();
        Date creationDate = cal.getTime();
        SimpleDateFormat date_format = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
        String pubdate = date_format.format(creationDate);
        Feed rssFeeder = new Feed(title, link, description);

        // now add one example entry
        FeedMessage writeFeed = new FeedMessage();
        writeFeed.setTitle("RSSFeed");
        writeFeed.setDescription("Test Description");
        writeFeed.setAuthor("nonsense@somewhere.de (Lars Vogel)");
        writeFeed.setGuid("http://www.vogella.com/tutorials/RSSFeed/article.html");
        writeFeed.setLink("http://www.vogella.com/tutorials/RSSFeed/article.html");
        rssFeeder.getFeedMessages().add(writeFeed);

        try {
            rssFeedServiceImpl.writeFeed("articles.rss", rssFeeder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
