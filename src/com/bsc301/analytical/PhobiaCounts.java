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
public class PhobiaCounts
{
    
    
    private Phobia m_phobia;
    private int m_count;
    
    public PhobiaCounts(Phobia phobia, int count)
    {
        m_phobia = phobia;
        m_count = count;
    }
    
    public Phobia GetPhobia()
    {
        return m_phobia;
    }
    
    public int GetCount()
    {
        return m_count;
    }
    
    public void SetPhobia(Phobia phobia)
    {
        m_phobia = phobia;
    }
    
    public void SetCount(int count)
    {
        m_count = count;
    }
    
    @Override
    public String toString()
    {
        return m_phobia.GetPhobia();
    }
    
    
}
