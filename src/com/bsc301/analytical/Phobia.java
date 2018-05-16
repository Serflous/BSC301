/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.analytical;

import java.util.List;
import java.util.Objects;

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
    
    @Override
    public String toString()
    {
        return m_phobia;
    }
    
    @Override
    public int hashCode()
    {
        return m_phobia.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Phobia other = (Phobia) obj;
        if (!Objects.equals(this.m_phobia, other.m_phobia))
        {
            return false;
        }
        return true;
    }
    
    
}
