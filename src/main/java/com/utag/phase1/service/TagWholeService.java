package com.utag.phase1.service;

import com.utag.phase1.util.Response;

import java.io.IOException;

public interface TagWholeService {

    /**
     *
     * @return
     */
    public Response<Boolean> saveTagWhole(int imageID, String description) throws IOException;

    /**
     *
     * @return
     */
    public Response<Boolean> deleteTagWhole(int imageID) throws IOException;

    /**
     *
     * @return
     */
    public Response<Boolean> updateTagWhole(int imageID, String description) throws IOException;
}
