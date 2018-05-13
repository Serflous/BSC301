/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.synonyms;


import com.bsc301.demo.Phobia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clemw
 */
public class DictionaryCreator {
 
    public static void run(String inputPath, String outputPath){        
     
        DatamuseQuery datamuse = new DatamuseQuery();
        JSONParse jsonparse = new JSONParse();
        
        System.out.println("Reading input file");
        
        String phobiasJSON = DictionaryParse.getJSON(inputPath);
        
        System.out.println("Parsing input file");
        
        List<Phobia> phobias = jsonparse.parseDictionary(phobiasJSON);
        
        System.out.println("Requesting synonyms from api");
        
        for(Phobia ph : phobias){
            List<String> synonyms = new ArrayList<>( ph.synonyms );
            
            for(String synonym: synonyms){
                String result = datamuse.findRelSyn(synonym,ph.name);
                
                String[] words = jsonparse.parseWords(result);
                
                for(String word: words){
                    ph.synonyms.add(word);
                }
            }
        }
        
        System.out.println("writing to file");
        
        DictionaryParse.putJSON(outputPath,phobias);
        
        System.out.println("complete");
    }       
    
    
}
