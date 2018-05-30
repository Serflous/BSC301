/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301;

import com.bsc301.analytical.MatchedPhobia;
import com.bsc301.analytical.Phobia;
import com.bsc301.analytical.PhobiaFactory;
import com.bsc301.analytical.SentimentAnalyser;
import com.bsc301.gui.GUI;
import com.bsc301.analytical.WordMatcher;
import com.bsc301.synonyms.DictionaryCreator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mat
 */
public class Main
{
    
    
    public static void main(String[] inputArgs) throws IOException
    {   
        GUI gui = new GUI();
        gui.flipVisibility();
        
        // creates json file of phobia synonyms using datamuse thesaurus api.
        //DictionaryCreator.run("input/phobias.json","output/phobia-keywords.json");
        
        //SentimentAnalyser.init();
        //String str1 = "I love spiders";
        //String str2 = "I hate spiders";
        //System.out.println(str1 + " : " + SentimentAnalyser.findSentiment(str1));
        //System.out.println(str2 + " : " + SentimentAnalyser.findSentiment(str2));
        
        // Run program through files
        /*List<String> facebookPosts = Files.readAllLines(Paths.get("output/facebook_test_data.txt"));
        List<String> twitterPosts = Files.readAllLines(Paths.get("output/twitter_test_data.txt"));
        FileWriter fileWriter = new FileWriter("output/results.csv");
        List<String> allPosts = new ArrayList<>();
        allPosts.addAll(facebookPosts);
        allPosts.addAll(twitterPosts);
        List<Phobia> phobias = PhobiaFactory.CreatePhobias("input/phobias.json");
        WordMatcher matcher = new WordMatcher(phobias);
        SentimentAnalyser.init();
        
        fileWriter.append("Post,");
        fileWriter.append("Sentiment,");
        fileWriter.append("Matched Phobias,");
        fileWriter.append("Matched Keyword");
        fileWriter.append("\n");
        
        int count = 1;
        float progress = 0;
        String[] sentimentNames = {"Very negative", "Negative", "Neutral", "Positive", "Very positive"};
        for(String sentence : allPosts)
        {
            List<MatchedPhobia> matches = matcher.FindMatchedPhobias(sentence);
            sentence = '"' + sentence.replace("\"", "\"\"") + '"';
            fileWriter.append(sentence + ',');
            fileWriter.append(sentimentNames[SentimentAnalyser.findSentiment(sentence)] + ',');
            fileWriter.append("\"");
            for(MatchedPhobia matchedPhobia : matches)
            {
                fileWriter.append(matchedPhobia.GetPhobia().GetPhobia() + ',');
            }
            fileWriter.append("\",\"");
            for(MatchedPhobia matchedPhobia : matches)
            {
                fileWriter.append(matchedPhobia.GetMatchedWord() + ',');
            }
            fileWriter.append("\"\n");
            progress = (count++ / (float)allPosts.size()) * 100;
            System.out.println("Progress: " + String.format("%.2f", progress) + "%");
        }
        
        fileWriter.flush();
        fileWriter.close();*/
    }
    
    
}
