package com.rackspace.cloud.sense.client.adapter.archive;

import com.rackspace.cloud.sense.client.adapter.AdapterTools;
import com.rackspace.cloud.sense.client.adapter.FeedSourceAdapter;
import com.rackspace.cloud.sense.domain.response.AdapterResponse;
import java.util.Calendar;
import org.apache.abdera.model.Feed;
import org.apache.abdera.protocol.server.RequestContext;

/**
 * This interface describes an adapter that is able to archive and store feeds as
 * well as retrieve them. This interface may be tagged onto a FeedSourceAdapter
 * to combine the Functionality of both in one class.
 *
 * @author John Hopper
 */
public interface FeedArchiver {

    /**
     * SENSe will inject archive adapters with a tools object using this method 
     * during initialization of the application. The init method also includes a
     * reference to the FeedSourceAdapter the archiver is associated with.
     *
     * @param tools
     */
    void init(AdapterTools tools, FeedSourceAdapter fsa);

    /**
     * 
     * @param archivalIntervalInMiliseconds
     * @throws UnsupportedOperationException
     */
    void setArchivalInterval(long archivalIntervalInMiliseconds) throws UnsupportedOperationException;

    /**
     * 
     * @return
     */
    long getArchivalInterval();

    /**
     *
     * @param request
     * @param date
     * @return
     */
    AdapterResponse<Feed> getArchivedFeed(RequestContext request, Calendar requested);

    /**
     * 
     * @param date
     */
    void archiveFeed(Calendar archiveTime);
}