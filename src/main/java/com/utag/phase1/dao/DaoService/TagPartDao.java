package com.utag.phase1.dao.DaoService;

import com.utag.phase1.domain.TagPart;
import java.io.IOException;
import java.util.List;

/**
 * 部分标注的数据层
 */
public interface TagPartDao {
    /**
     *增加部分标注
     * @param imageID
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param description
     * @return
     */
    public boolean saveTagPart(String imageID, double x1, double x2, double y1, double y2,
                               String description) throws IOException;


    /**
     *展示部分标注
     * @param imageID
     * @return
     */
    public List<TagPart> showTagPart(String imageID) throws IOException;

    /**
     * 删除部分标注
     * @param imageID
     * @return
     */
    public boolean deleteTagPart(String imageID) throws IOException;


    /**
     * 更新部分标注
     * @param imageID
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param description
     * @return
     */
    public boolean updateTagPart(String imageID, double x1, double x2, double y1,
                                 double y2, String description) throws IOException;

    /**
     * 根据id和区域坐标得到描述部分长度
     * @param imageID
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     */
    public int getDescriptionLength(String imageID, double x1, double x2, double y1, double y2) throws IOException;

}
