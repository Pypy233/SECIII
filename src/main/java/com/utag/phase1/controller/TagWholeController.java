package com.utag.phase1.controller;

import com.utag.phase1.service.Impl.TagWholeServiceImpl;
import com.utag.phase1.service.TagWholeService;
import com.utag.phase1.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/workplace/whole/")
public class TagWholeController {
    TagWholeService tagWholeService = new TagWholeServiceImpl();

    @RequestMapping("/save")
    @ResponseBody
    public Response <Boolean> saveTagWhole(int imageID, String description) throws IOException{
        return tagWholeService.saveTagWhole(imageID, description);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Response<Boolean> deleteTagWhole(int imageID) throws IOException{
        return tagWholeService.deleteTagWhole(imageID);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Response<Boolean> updateTagWhole(int imageID, String description) throws IOException{
        return tagWholeService.updateTagWhole(imageID, description);
    }
}
