/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.demo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author clemw
 */
public class StaticResults {
    
    // detected phobias
    public static final List<Phobia> PHOBIAS = Arrays.asList(
            new Phobia("n1",true,"desc n1","suggest n1"),
            new Phobia("n2",true,"desc n2","suggest n2")            
    );
    
}
