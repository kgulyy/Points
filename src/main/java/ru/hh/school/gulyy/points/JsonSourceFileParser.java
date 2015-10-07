package ru.hh.school.gulyy.points;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Константин on 07.10.2015.
 */
public class JsonSourceFileParser {
    public static Set<Point> parse(String fileName) {
        Set<Point> result = new HashSet<Point>();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray pointArray = (JSONArray) jsonObject.get("points");
            for (Object object : pointArray) {
                jsonObject = (JSONObject) object;
                Long x = (Long) jsonObject.get("x");
                Long y = (Long) jsonObject.get("y");
                result.add(new Point(x.intValue(), y.intValue()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
