package com.utag.phase1.dao;

import com.utag.phase1.dao.DaoService.TagWholeDao;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TagWholeDaoImplTest {
    TagWholeDao tagWholeDao = new TagWholeDaoImpl();

    @Test
    public void saveTagWhole() throws IOException{
        assertEquals(true, tagWholeDao.saveTagWhole("0", "test0"));
        assertEquals(true, tagWholeDao.saveTagWhole("1", "test1"));
        assertEquals(true, tagWholeDao.saveTagWhole("2","test2"));
    }

    @Test
    public void deleteTagWhole() throws IOException{
        assertEquals(true, tagWholeDao.deleteTagWhole("0"));
        assertEquals(true, tagWholeDao.deleteTagWhole("1"));
        assertEquals(true, tagWholeDao.deleteTagWhole("2"));
    }

    @Test
    public void updateTagWhole() throws IOException{
        assertEquals(true, tagWholeDao.updateTagWhole("0", "update"));
        assertEquals(true, tagWholeDao.updateTagWhole("1", "update"));
        assertEquals(true, tagWholeDao.updateTagWhole("2", "update"));
    }

    @Test
    public void getDescriptionLength() throws IOException{
        assertEquals(5, tagWholeDao.getDescriptionLength("0"));
        assertEquals(5, tagWholeDao.getDescriptionLength("1"));
        assertEquals(5, tagWholeDao.getDescriptionLength("2"));
        assertEquals(0, tagWholeDao.getDescriptionLength("xxxx"));
    }
}