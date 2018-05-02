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
import edu.stanford.nlp.simple.*;

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
     * Separate a body of text into a list of sentences.
     * 
     * @param text Body of text
     * @return List of strings separated
     */
    public List<Sentence> GenerateSentences(String text)
    {
        Document doc = new Document(text);
        return(doc.sentences());
    }
    
    public List<String> GenerateSentencesAsStrings(String text) {
        ArrayList<String> strings = new ArrayList<>();
        Document doc = new Document(text);
        
        for(Sentence sent : doc.sentences()) {
            strings.add(sent.text());
        }
        
        return(strings);
    }
    
    /**
     * Separate a post into a list of sentences.
     * 
     * @param <T> Type of post
     * @param post Post
     * @return List of sentences
     */
    public <T> List<Sentence> GenerateSentencesFromPost(T post) {
        return(GenerateSentences(GetPostText(post)));
    }
    
    /**
     * Separate multiple posts by sentence into a list of strings.
     * 
     * @param <T> Type of post
     * @param posts Posts
     * @return List of strings, separated by sentence
     */
    public <T> List<String> GenerateSentencesFromPosts(List<T> posts) {
        ArrayList<String> strings = new ArrayList<>();
        
        for(T post : posts) {
            List<Sentence> sents = GenerateSentencesFromPost(post);
            
            for(Sentence sent : sents) {
                strings.add(sent.text());
            }
        }
        
        return(strings);
    }
}
