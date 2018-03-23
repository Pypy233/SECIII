package com.utag.phase1.dao.DaoService;

import java.io.IOException;

/**
 * 整张图片标注的数据层服务
 */
public interface TagWholeDao {

    /**
     *保存整张图片标注的结果
     * @param imageID
     * @param description
     * @return
     */
    public boolean saveTagWhole(String imageID, String description) throws IOException;

    /**
     * 删除整张图片保存
     * @param imageID
     * @param
     * @return
     */
    public boolean deleteTagWhole(String imageID) throws IOException;

    /**
     *更新整张图片保存
     * @param imageID
     * @param description
     * @return
     */
    public boolean updateTagWhole(String imageID, String description) throws IOException;

    /**
     * 根据照片id获取标注字符串长度
     * @param imageID
     * @return
     */
    public int getDescriptionLength(String imageID) throws IOException;

}
