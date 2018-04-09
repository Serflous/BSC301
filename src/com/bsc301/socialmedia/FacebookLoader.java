/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.socialmedia;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.json.JsonObject;

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
    
    public JsonObject GetFacebookJsonString(String authToken)
    {
        FacebookClient client = new DefaultFacebookClient(authToken, Version.LATEST);
        return client.fetchObject("me/posts", JsonObject.class);
    }
    
    
}
