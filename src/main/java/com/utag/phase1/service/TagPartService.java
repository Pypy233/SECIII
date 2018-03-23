package com.utag.phase1.service;

import com.utag.phase1.domain.TagPart;
import com.utag.phase1.util.Response;

import java.io.IOException;
import java.util.List;

public interface TagPartService {

    /**
     *
     * @param imageID
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param description
     * @return
     */
    public Response<Boolean> saveTagPart(String imageID, double x1, double x2,
                                         double y1, double y2, String description) throws IOException;


    /**
     *
     * @param imageID
     * @return
     */
    public Response<List<TagPart>> showTagPart(String imageID) throws IOException;


    /**
     *
     * @param imageID
     * @return
     */
    public Response<Boolean> deleteTagPart(String imageID) throws IOException;


    /**
     *
     * @param imageID
     * @return
     * @throws IOException
     */
    public Response<Boolean> updateTagPart(String imageID, double x1, double x2, double y1,
                                           double y2, String description) throws IOException;

    /**
     * 得到对应描述的字符串长度
     * @param imageID
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     * @throws IOException
     */
    public Response<Integer> getDescriptionLength(String imageID, double x1, double x2, double y1,
                                                   double y2) throws IOException;


}
