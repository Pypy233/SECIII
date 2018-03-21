package com.utag.phase1.dao.DaoService;

import java.io.IOException;

public interface TagWholeDao {

    /**
     *
     * @param imageID
     * @param description
     * @return
     */
    public boolean saveTagWhole(int imageID, String description) throws IOException;

    /**
     *
     * @param imageID
     * @param
     * @return
     */
    public boolean deleteTagWhole(int imageID) throws IOException;

    /**
     *
     * @param imageID
     * @param description
     * @return
     */
    public boolean updateTagWhole(int imageID, String description) throws IOException;

}
