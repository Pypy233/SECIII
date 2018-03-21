package com.utag.phase1.controller;

import com.utag.phase1.domain.TagPart;
import com.utag.phase1.service.Impl.TagPartServiceImpl;
import com.utag.phase1.service.TagPartService;
import com.utag.phase1.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController("/workplace/part")
public class TagPartController {
    TagPartService tagPartService = new TagPartServiceImpl();

    @RequestMapping("/save")
    @ResponseBody
    public Response<Boolean> saveTagPart(int imageID, double x1, double x2,
                                         double y1, double y2, String description) throws IOException{


        return tagPartService.saveTagPart(imageID, x1, x2, y1, y2, description);

    }

    @RequestMapping("/show")
    @ResponseBody
    public Response<List<TagPart>> showTagPart(int imageID) throws IOException{
        return tagPartService.showTagPart(imageID);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Response<Boolean> deleteTagPart(int imageID) throws IOException{
        /**
         * 更新使用先删除后读取本地数据，保存后读取
         */
        return tagPartService.deleteTagPart(imageID);

    }


}
