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
 * @author peterd - 32455678
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
    
    // Restrict class construction
    private SentenceSplitter()
    {
        
    }

    /**
     * Get text from either Facebook post or Twitter status.
     * 
     * @param <T> Type of post
     * @param post Post to get text from
     * @return String of Post text
     */
    private <T> String GetPostText(T post) {
        String message = post instanceof Post ? ((Post)post).getMessage() : ((Status)post).getText();
        return message;
    }
    
    /**
     * Separate list of strings into new list of strings on period character.
     * 
     * @param strings List of strings
     * @return List of strings separated
     */
    public List<String> GenerateSentences(List<String> strings)
    {
        ArrayList<String> sentences = new ArrayList<>();
        
        for(String string : strings)
        {
            // Split text on '.'
            String[] sentenceArray = string.split("\\.");
            for(String sentence : sentenceArray)
            {
                sentences.add(sentence);
            }
        }
        return sentences;
    }
    
    /**
     * Separate a list of posts into a list of sentences.
     * 
     * @param <T> Type of post
     * @param posts List of posts
     * @return List of separated strings
     */
    public <T> List<String> GenerateSentencesFromPosts(List<T> posts) {
        ArrayList<String> postTexts = new ArrayList<>();
        
        for(T post : posts) {
            postTexts.add(GetPostText(post));
        }
        
        List<String> postSentences = GenerateSentences(postTexts);
        return postSentences;
    }
}
