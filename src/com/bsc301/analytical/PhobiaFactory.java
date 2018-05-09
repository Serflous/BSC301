/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.analytical;

import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mat
 */
public class PhobiaFactory
{
    
    public static List<Phobia> CreatePhobias(String input)
    {
        List<Phobia> allPhobias = new ArrayList<Phobia>();
        try
        {
            String json = new String(Files.readAllBytes(Paths.get(input)));
            JsonParserFactory factory = JsonParserFactory.getInstance();
            JSONParser m_parser = factory.newJsonParser();
            Map jsonMap = m_parser.parseJson(json);
            List phobiasList = (List)jsonMap.get("root");
            for(int i = 0; i < phobiasList.size(); i++)
            {
                Map phobia = (Map)phobiasList.get(i);
                List phobiaWords = (List)phobia.get("words");
                String phobiaName = (String)phobia.get("phobia");
                String phobiaDescription = (String)phobia.get("desc");
                Phobia phobiaObj = new Phobia(phobiaName, phobiaDescription, phobiaWords);
                allPhobias.add(phobiaObj);
            }
        }
        catch(Exception ex)
        {
            
        }
        return allPhobias;
    }
    
    
}
