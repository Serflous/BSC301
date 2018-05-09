/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.analytical;

/**
 *
 * @author Mat
 */
public class MatchedPhobia
{
    
    
    private Phobia m_phobia;
    private String m_sentence;
    
    public MatchedPhobia(Phobia phobia, String sentence)
    {
        m_phobia = phobia;
        m_sentence = sentence;
    }
    
    public Phobia GetPhobia()
    {
        return m_phobia;
    }
    
    public String GetSentence()
    {
        return m_sentence;
    }
    
    
}
