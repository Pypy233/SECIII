package com.utag.phase1.controller;

import com.utag.phase1.domain.TagPart;
import com.utag.phase1.service.Impl.TagPartServiceImpl;
import com.utag.phase1.service.TagPartService;
import com.utag.phase1.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/workplace/part/")
public class TagPartController {
    TagPartService tagPartService = new TagPartServiceImpl();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> saveTagPart(String imageID, double x1,
                                         double x2, double y1, double y2, String description) throws IOException{
        return tagPartService.saveTagPart(imageID, x1, x2, y1, y2, description);

    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<TagPart>> showTagPart(String imageID) throws IOException{
        return tagPartService.showTagPart(imageID);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Response<Boolean> deleteTagPart(String imageID) throws IOException{
        return tagPartService.deleteTagPart(imageID);

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Response<Boolean> updateTagPart(String imageID, double x1, double x2,
                                           double y1, double y2, String description) throws IOException{

       return tagPartService.updateTagPart(imageID, x1, x2, y1, y2, description);
    }

    @RequestMapping(value = "/length", method = RequestMethod.GET)
    @ResponseBody
    public Response<Integer> getDescriptionLength(String imageID, double x1,
                                                  double x2, double y1, double y2) throws IOException{

        return tagPartService.getDescriptionLength(imageID, x1, x2, y1, y2);
    }

}
