/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.socialmedia;

import com.bsc301.util.References;
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
    
    public ResponseList<Status> GetStatuses(String username)
    {
        ResponseList<Status> statuses = null;
        try
        {
            ConfigurationBuilder builder = new ConfigurationBuilder();
            builder.setDebugEnabled(true)
                   .setOAuthConsumerKey(References.STRING_TWITTER_CONSUMER_KEY)
                   .setOAuthConsumerSecret(References.STRING_TWITTER_CONSUMER_SECRET)
                   .setApplicationOnlyAuthEnabled(true);

            TwitterFactory tf = new TwitterFactory(builder.build());
            Twitter twitterInstance = tf.getInstance();
            OAuth2Token token = twitterInstance.getOAuth2Token();
            statuses = twitterInstance.getUserTimeline(username);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            return statuses;
        }
    }
    
    
}
