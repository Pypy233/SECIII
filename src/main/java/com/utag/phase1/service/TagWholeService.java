package com.utag.phase1.service;

import com.utag.phase1.util.Response;
import java.io.IOException;

public interface TagWholeService {

    /**
     *保存整张图片标注信息
     * @return
     */
    public Response<Boolean> saveTagWhole(String imageID, String description) throws IOException;

    /**
     *删除标注信息
     * @return
     */
    public Response<Boolean> deleteTagWhole(String imageID) throws IOException;

    /**
     *更新标注信息
     * @return
     */
    public Response<Boolean> updateTagWhole(String imageID, String description) throws IOException;

    /**
     * 获得对应照片标注字符串长度
     * @param imageID
     * @return
     * @throws IOException
     */
    public Response<Integer> getDescriptionLength(String imageID) throws IOException;
}
