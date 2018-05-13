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
import java.util.List;

/**
 *
 * @author Mat
 */
public class Main
{
    
    
    public static void main(String[] inputArgs)
    {   
//        GUI gui = new GUI();
//        gui.flipVisibility();
        
        // creates json file of phobia synonyms using datamuse thesaurus api.
        DictionaryCreator.run("input/phobias.json","output/phobia-keywords.json");
        
//        SentimentAnalyser.init();
//        String str1 = "I love spiders";
//        String str2 = "I hate spiders";
//        System.out.println(str1 + " : " + SentimentAnalyser.findSentiment(str1));
//        System.out.println(str2 + " : " + SentimentAnalyser.findSentiment(str2));
    }
    
    
}
