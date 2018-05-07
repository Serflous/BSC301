/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.socialmedia;

import com.bsc301.analytical.SentenceSplitter;
import com.restfb.types.Post;
import edu.stanford.nlp.simple.Sentence;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;

/**
 *
 * @author Mat
 */
public class MasterLoader
{
    
    
    // Singleton Stuff
    private static MasterLoader me;
    public static MasterLoader GetInstance()
    {
        if(me == null)
            me = new MasterLoader();
        return me;
    }
    
    private List<String> m_facebookSentences;
    private List<String> m_twitterSentences;
    
    private MasterLoader()
    {
        
    }
    
    public boolean LoadFacebook(String authToken)
    {
        List<Post> posts = FacebookLoader.GetInstance().GetFacebookJsonString(authToken);
        m_facebookSentences = new ArrayList<String>();
        m_facebookSentences = SentenceSplitter.GetInstance().GenerateSentencesFromPosts(posts);
        return true;
    }
    
    public boolean LoadTwitter(String username)
    {
        List<Status> statuses = TwitterLoader.GetInstance().GetStatuses(username);
        if(statuses == null)
        {
            System.err.println("Twitter Error");
            return false;
        }
        else
        {
            m_twitterSentences = new ArrayList<String>();
            for (Status s : statuses)
            {
                List<Sentence> sentences = SentenceSplitter.GetInstance().GenerateSentencesFromPost(s);
                for(Sentence sentence : sentences)
                {
                    m_twitterSentences.add(sentence.text());
                }
            }
        }
        return true;
    }
    
    public List<String> GetAllLoadedSentences()
    {
        List<String> allSentences = new ArrayList<String>();
        if(m_facebookSentences != null)
            allSentences.addAll(m_facebookSentences);
        if(m_twitterSentences != null)
            allSentences.addAll(m_twitterSentences);
        return allSentences;
    }
    
    
}
