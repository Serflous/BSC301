/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301;

import com.bsc301.gui.GUI;
import com.bsc301.synonyms.DictionaryCreator;
import java.io.File;

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
        
    }
    
    
}
