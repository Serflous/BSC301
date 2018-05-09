/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.analytical;

import java.util.List;

/**
 *
 * @author Mat
 */
public class Phobia
{
    
    
    private String m_phobia;
    private String m_description;
    private List<String> m_words;
    
    public Phobia(String phobia, String description, List<String> words)
    {
        m_phobia = phobia;
        m_description = description;
        m_words = words;
    }
    
    public String GetPhobia()
    {
        return m_phobia;
    }
    
    public String GetDescription()
    {
        return m_description;
    }
    
    public List<String> GetWords()
    {
        return m_words;
    }
    
    
}
