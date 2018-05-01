/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.synonyms;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bsc301.demo.Phobia;



/**
 *
 * @author clemw
 */
public class DictionaryParse {
    

    public static String getJSON(String filePath) {
        
        StringBuilder s = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String inputLine;
            s = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                s.append(inputLine);
            in.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return s != null ? s.toString() : null;
    }
    
    public static void putJSON(String filePath,List<Phobia> phobias){        
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write("[\n");
           
            for(int i = 0; i < phobias.size(); i++){
                out.append("\t{\n");
                out.append("\t\"phobia\":");
                out.append("\"").append(phobias.get(i).name).append("\",\n");
                
                out.append("\t\"description\":");
                out.append("\"").append(phobias.get(i).description).append("\",\n");
                
                out.append("\t\"words\":[\n");
                
                for(int j = 0; j < phobias.get(i).synonyms.size(); j++){
                    out.append("\t\t\"").append(phobias.get(i).synonyms.get(j) );
                    if(phobias.get(i).synonyms.size() == j + 1){
                        out.append("\"]\n");
                    }else{
                        out.append("\",\n");
                    }
                }                
                if(phobias.size() == i + 1){
                    out.append("\t}\n");
                }else{
                    out.append("\t},\n");
                }
            }
            
            out.append("]");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(DictionaryParse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
