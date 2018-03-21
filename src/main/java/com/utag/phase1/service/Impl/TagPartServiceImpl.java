package com.utag.phase1.service.Impl;

import com.utag.phase1.dao.DaoService.TagPartDao;
import com.utag.phase1.dao.TagPartDaoImpl;
import com.utag.phase1.domain.TagPart;
import com.utag.phase1.service.TagPartService;
import com.utag.phase1.util.Response;

import java.io.IOException;
import java.util.List;

public class TagPartServiceImpl implements TagPartService {
    TagPartDao tagPartDao = new TagPartDaoImpl();

    @Override
    public Response<Boolean> saveTagPart(int imageID, double x1, double x2, double y1, double y2, String description)
            throws IOException{
        Response<Boolean> response = new Response<>();
        if(tagPartDao.saveTagPart(imageID, x1, x2, y1, y2, description))
            response.setSuccess(true);
        else
            response.setSuccess(false);
        return response;
    }

    @Override
    public Response<List<TagPart>> showTagPart(int imageID) throws IOException{
        Response<List<TagPart>> response = new Response<>();
        response.setData(tagPartDao.showTagPart(imageID));
        return response;
    }

    @Override
    public Response<Boolean> deleteTagPart(int imageID)throws IOException {
        Response<Boolean> response = new Response<>();
        if(tagPartDao.deleteTagPart(imageID))
            response.setSuccess(true);
        else
            response.setSuccess(false);
        return response;
    }

}
