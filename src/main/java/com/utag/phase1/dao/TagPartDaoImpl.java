package com.utag.phase1.dao;

import com.google.gson.Gson;
import com.utag.phase1.dao.DaoService.TagPartDao;
import com.utag.phase1.domain.TagPart;
import com.utag.phase1.util.FileTool;
import com.utag.phase1.util.GsonTool;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TagPartDaoImpl implements TagPartDao {

    private static final String FILE_NAME = "part_pictures.json";

    private ArrayList<TagPart> init() throws IOException{
        ArrayList<String> imageStrList = (ArrayList<String>) FileTool.readFile(FILE_NAME);
        ArrayList<TagPart> imageList = new ArrayList<>();

        for(String str: imageStrList){
            imageList.add(GsonTool.getBean(str, TagPart.class));
        }

        return imageList;
    }

    @Override
    public boolean saveTagPart(String imageID, double x1, double x2, double y1, double y2, String description) throws IOException{
        TagPart tagPart = new TagPart(imageID, x1, x2, y1, y2, description);
        String jsonStr = GsonTool.toJson(tagPart);
        return FileTool.writeFile(FILE_NAME, jsonStr);
    }

    @Override
    public List<TagPart> showTagPart(String imageID) throws IOException{
        List<TagPart> resultList = new ArrayList<>();
        ArrayList<TagPart> list = init();

        for(TagPart tagPart: list){
            if(tagPart.getImageID().equals(imageID))
                resultList.add(tagPart);
        }
        return resultList;
    }

    @Override
    public boolean deleteTagPart(String imageID) throws IOException{
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<TagPart> list = init();

        for(TagPart tagPart: list){
            if(!tagPart.getImageID().equals(imageID)){
                TagPart tagPart1 = new TagPart(tagPart.getImageID(), tagPart.getX1(), tagPart.getX2(),
                        tagPart.getY1(), tagPart.getY2(), tagPart.getDescription());
                String jsonStr = GsonTool.toJson(tagPart1);
                resultList.add(jsonStr);
            }
        }
        return FileTool.rewriteFile(FILE_NAME, resultList);
    }

    @Override
    public boolean updateTagPart(String imageID, double x1, double x2, double y1, double y2, String description) throws IOException {
        ArrayList<String> resultList = new ArrayList<>();
        ArrayList<TagPart> list = init();

        for(TagPart tagPart: list){
            if(tagPart.getImageID().equals(imageID) && tagPart.getX1() == x1
                    && tagPart.getX2() == x2 && tagPart.getY1() == y1 && tagPart.getY2() == y2){
                TagPart tagPart1 = new TagPart(imageID, x1, x2, y1, y2, description);
                String jsonStr = GsonTool.toJson(tagPart1);
                resultList.add(jsonStr);
            }
            else{
                TagPart tagPart1 = new TagPart(tagPart.getImageID(), tagPart.getX1(), tagPart.getX2(),
                        tagPart.getY1(), tagPart.getY2(), tagPart.getDescription());
                String jsonStr = GsonTool.toJson(tagPart1);
                resultList.add(jsonStr);
            }
        }
        return FileTool.rewriteFile(FILE_NAME, resultList);
    }


    @Override
    public int getDescriptionLength(String imageID, double x1, double x2, double y1, double y2) throws IOException{
        ArrayList<TagPart> list = init();
        for(TagPart tagPart: list){
            if(tagPart.getImageID().equals(imageID) && ((tagPart.getX1() == x1 &&
                    tagPart.getX2() == x2 && tagPart.getY1() == y1 && tagPart.getY2() == y2)) || (tagPart.getX1() == x2 &&
            tagPart.getX2() == x1 && tagPart.getY1() == y2 && tagPart.getY2() == y1)){

                String str = tagPart.getDescription();
                return str.length();
            }
        }
        return 0;
    }


}
