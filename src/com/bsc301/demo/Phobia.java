/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.demo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clemw
 */
public class Phobia {
    
    public String name;
    public boolean found;
    public String description;
    public String suggestions;
    public List<String> synonyms = new ArrayList<>();
    
    public Phobia(){}
    
    public Phobia(String name, boolean found, String desc, String sug){
        this.name = name;
        this.found = found;
        this.description = desc;
        this.suggestions = sug;
    }
    
    public void addSynonym(String synonym){
        this.synonyms.add(synonym);
    }
    
}
