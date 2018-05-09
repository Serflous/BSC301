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
                        MatchedPhobia match = new MatchedPhobia(phobia, sentence);
                        matchedPhobias.add(match);
                        System.out.println(sentence + " -> " + phobia.GetPhobia());
                    }
                }
            }
        }
        
        return matchedPhobias;
    }
    
    
}
