/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.socialmedia;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import com.restfb.types.Post;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mat
 */
public class FacebookLoader
{
    
    
    private static FacebookLoader instance;
    
    public static FacebookLoader GetInstance()
    {
        if(instance == null)
            instance = new FacebookLoader();
        return instance;
    }
    
    private FacebookLoader()
    {
        
    }
    
    public List<Post> GetFacebookJsonString(String authToken)
    {
        ArrayList<Post> allPosts = new ArrayList<>();
        try
        {
            FacebookClient client = new DefaultFacebookClient(authToken, Version.LATEST);
            //return client.fetchObject("me/posts", JsonObject.class);
            Connection<Post> feed = client.fetchConnection("me/feed", Post.class);
            for(List<Post> page : feed)
            {
                for(Post post : page)
                {
                    if(post.getMessage() != null)
                    {
                        allPosts.add(post);
                    }
                }
            }
            return allPosts;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            return allPosts;
        }
    }
    
    
}
