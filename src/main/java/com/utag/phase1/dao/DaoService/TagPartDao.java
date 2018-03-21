package com.utag.phase1.dao.DaoService;

import com.utag.phase1.domain.TagPart;
import com.utag.phase1.util.Response;

import java.io.IOException;
import java.util.List;

public interface TagPartDao {
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
    public boolean saveTagPart(int imageID, double x1, double x2, double y1, double y2, String description) throws IOException;


    /**
     *
     * @param imageID
     * @return
     */
    public List<TagPart> showTagPart(int imageID) throws IOException;

    /**
     *
     * @param imageID
     * @return
     */
    public boolean deleteTagPart(int imageID) throws IOException;

}
