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
    private String m_matchedWord;
    
    public MatchedPhobia(Phobia phobia, String sentence, String matchedWord)
    {
        m_phobia = phobia;
        m_sentence = sentence;
        m_matchedWord = matchedWord;
    }
    
    public Phobia GetPhobia()
    {
        return m_phobia;
    }
    
    public String GetSentence()
    {
        return m_sentence;
    }
    
    public String GetMatchedWord()
    {
        return m_matchedWord;
    }
    
    
}
