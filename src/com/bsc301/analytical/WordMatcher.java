/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.analytical;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mat
 */
public class WordMatcher
{
    
    
    private List<Phobia> m_phobias;
    
    public WordMatcher(List<Phobia> phobias)
    {
        m_phobias = phobias;
    }
    
    public List<MatchedPhobia> FindMatchedPhobias(String sentence)
    {
        List<MatchedPhobia> matchedPhobias = new ArrayList<MatchedPhobia>();
        
        String[] words = sentence.split("\\W+");
        for(String word : words)
        {
            for(Phobia phobia : m_phobias)
            {
                for(String phobiaWord : phobia.GetWords())
                {
                    if(word.toLowerCase().contains(phobiaWord))
                    {
                        if(LevenshteinDistance(word.toLowerCase(), phobiaWord) <= 1)
                        {
                            MatchedPhobia match = new MatchedPhobia(phobia, sentence, word);
                            matchedPhobias.add(match);
                            //System.out.println(sentence + " -> " + phobia.GetPhobia());
                        }
                    }
                }
            }
        }
        
        return matchedPhobias;
    }
    
    private int LevenshteinDistance(String wordA, String wordB)
    {
        int[] costs = new int[wordB.length() + 1];
        for(int i =0; i < costs.length; i++)
        {
            costs[i] = i;
        }
        for(int i = 1; i <= wordA.length(); i++)
        {
            costs[0] = i;
            int k = i - 1;
            for(int j = 1; j <= wordB.length(); j++)
            {
                int l = Math.min(1 + Math.min(costs[j], costs[j - 1]), wordA.charAt(i - 1) == wordB.charAt(j - 1) ? k : k + 1);
                k = costs[j];
                costs[j] = l;
            }
        }
        return costs[wordB.length()];
    }
    
    
}
