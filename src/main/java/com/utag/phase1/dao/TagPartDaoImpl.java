package com.utag.phase1.dao;

import com.google.gson.Gson;
import com.utag.phase1.dao.DaoService.TagPartDao;
import com.utag.phase1.domain.TagPart;
import com.utag.phase1.util.FileTool;
import com.utag.phase1.util.GsonTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TagPartDaoImpl implements TagPartDao {

    private static final String FILE_PATH = "part_pictures.json";

    private ArrayList<TagPart> init() throws IOException{
        ArrayList<String> imageStrList = (ArrayList<String>) FileTool.readFile(FILE_PATH);
        ArrayList<TagPart> imageList = new ArrayList<>();

        for(String str: imageStrList){
            imageList.add(GsonTool.getBean(str, TagPart.class));
        }

        return imageList;
    }

    @Override
    public boolean saveTagPart(int imageID, double x1, double x2, double y1, double y2, String description) throws IOException{
        TagPart tagPart = new TagPart(imageID, x1, x2, y1, y2, description);
        String jsonStr = GsonTool.toJson(tagPart);
        return FileTool.writeFile(FILE_PATH, jsonStr);
    }

    @Override
    public List<TagPart> showTagPart(int imageID) throws IOException{
        List<TagPart> resultList = new ArrayList<>();
        ArrayList<TagPart> list = init();

        for(TagPart tagPart: list){
            if(tagPart.getImageID() == imageID)
                resultList.add(tagPart);
        }
        return resultList;
    }

    @Override
    public boolean deleteTagPart(int imageID) throws IOException{
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<TagPart> list = init();

        for(TagPart tagPart: list){
            if(tagPart.getImageID() != imageID){
                TagPart tagPart1 = new TagPart(tagPart.getImageID(), tagPart.getX1(), tagPart.getX2(),
                        tagPart.getY1(), tagPart.getY2(), tagPart.getDescription());
                String jsonStr = GsonTool.toJson(tagPart1);
                resultList.add(jsonStr);
            }
        }
        return FileTool.rewriteFile(FILE_PATH, resultList);
    }


}
