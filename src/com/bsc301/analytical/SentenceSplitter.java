/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.analytical;

import com.restfb.types.Post;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;

/**
 *
 * @author 32974146
 */
public class SentenceSplitter
{
    
    
    private static SentenceSplitter me;
    public static SentenceSplitter GetInstance()
    {
        if(me == null)
            me = new SentenceSplitter();
        return me;
    }
    
    private SentenceSplitter()
    {
        
    }
    
    public <T> List<String> GenerateSentences(List<T> posts)
    {
        ArrayList<String> sentences = new ArrayList<>();
        
        for(T post : posts)
        {
            // Gets post or status text
            String message = post instanceof Post ? ((Post)post).getMessage() : ((Status)post).getText();
            
            // Split post on '.'
            String[] sentenceArray = message.split("\\.");
            for(String sentence : sentenceArray)
            {
                sentences.add(sentence);
            }
        }
        return sentences;
    }
    
    
}
