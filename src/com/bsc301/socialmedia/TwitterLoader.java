/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.socialmedia;

import com.bsc301.util.References;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Mat
 */
public class TwitterLoader
{
    
    
    private static TwitterLoader instance;
    
    public static TwitterLoader GetInstance()
    {
        if(instance == null)
            instance = new TwitterLoader();
        return instance;
    }
    
    private TwitterLoader()
    {
        
    }
    
    public List<Status> GetStatuses(String username, boolean includeRetweets)
    {
        ArrayList<Status> returnStatuses = new ArrayList<>();
        try
        {
            ConfigurationBuilder builder = new ConfigurationBuilder();
            builder.setDebugEnabled(true)
                   .setOAuthConsumerKey(References.STRING_TWITTER_CONSUMER_KEY)
                   .setOAuthConsumerSecret(References.STRING_TWITTER_CONSUMER_SECRET)
                   .setApplicationOnlyAuthEnabled(true)
                   .setTweetModeExtended(true);

            TwitterFactory tf = new TwitterFactory(builder.build());
            Twitter twitterInstance = tf.getInstance();
            OAuth2Token token = twitterInstance.getOAuth2Token();
            int currentPageIndex = 1;
            int currentSize = 0;
            ResponseList<Status> statuses;
            do
            {
                Paging currentPage = new Paging(currentPageIndex++, 100);
                statuses = twitterInstance.getUserTimeline(username, currentPage);
                for(Status status : statuses)
                {
                    if(includeRetweets)
                    {
                        returnStatuses.add(status);
                    }
                    else
                    {
                        if(!status.isRetweet())
                        {
                            returnStatuses.add(status);
                        }
                    }
                }
            }
            while(statuses.size() > 0);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            return returnStatuses;
        }
    }
    
    public List<Status> GetStatuses(String username)
    {
        return GetStatuses(username, false);
    }
    
    
}
