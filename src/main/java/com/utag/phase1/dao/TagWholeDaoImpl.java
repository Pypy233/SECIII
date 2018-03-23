package com.utag.phase1.dao;

import com.utag.phase1.dao.DaoService.TagWholeDao;
import com.utag.phase1.domain.TagWhole;
import com.utag.phase1.util.FileTool;
import com.utag.phase1.util.GsonTool;

import java.io.IOException;
import java.util.ArrayList;


public class TagWholeDaoImpl implements TagWholeDao {
    private static final String FILE_NAME = "whole_pictures.json";

    private ArrayList<TagWhole> init() throws IOException{
        ArrayList<String> imageStrList = (ArrayList<String>) FileTool.readFile(FILE_NAME);
        ArrayList<TagWhole> imageList = new ArrayList<>();

        for(String str: imageStrList){
            imageList.add(GsonTool.getBean(str, TagWhole.class));
        }

        return imageList;

    }

    @Override
    public boolean saveTagWhole(String imageID, String description) throws IOException{
        TagWhole tagWhole = new TagWhole(imageID, description);
        String jsonStr = GsonTool.toJson(tagWhole);
        return FileTool.writeFile(FILE_NAME, jsonStr);
    }

    @Override
    public boolean deleteTagWhole(String imageID) throws IOException{
        ArrayList<TagWhole> list = init();
        ArrayList<String> resultList = new ArrayList<>();

        for(TagWhole t: list){
            if(!t.getImageID().equals(imageID)){
                TagWhole tagWhole = new TagWhole(t.getImageID(), t.getDescription());
                String jsonStr = GsonTool.toJson(tagWhole);
                resultList.add(jsonStr);
            }
        }
        return FileTool.rewriteFile(FILE_NAME, resultList);
    }

    @Override
    public boolean updateTagWhole(String imageID, String description) throws IOException{
        ArrayList<TagWhole> list = init();
        ArrayList<String> resultList = new ArrayList<>();

        for(TagWhole t: list){
            if(t.getImageID().equals(imageID)){
                TagWhole tagWhole = new TagWhole(imageID, description);
                String jsonStr = GsonTool.toJson(tagWhole);
                resultList.add(jsonStr);
            }
            else{
                resultList.add(GsonTool.toJson(t));
            }
        }
        return FileTool.rewriteFile(FILE_NAME, resultList);
    }

    @Override
    public int getDescriptionLength(String imageID) throws IOException{
        ArrayList<TagWhole> list = init();

        for(TagWhole t: list){
            if(t.getImageID().equals(imageID)){
                String des = t.getDescription();
                return des.length();
            }
        }
        return 0;
    }
}
