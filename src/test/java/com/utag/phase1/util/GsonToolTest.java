package com.utag.phase1.util;

import com.utag.phase1.domain.User;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.List;

import static org.junit.Assert.*;

public class GsonToolTest {

    @Test
    public  void testBean(){
        String jsonStr1 = "{'username': 'admin', 'password': 'admin'}";
        User bean1 = GsonTool.getBean(jsonStr1, User.class);
        assertEquals("admin", bean1.getUsername());
        assertEquals("admin", bean1.getPassword());


        String jsonStr2 = "{'username': 'py', 'password': 'py'}";
        User bean2 = GsonTool.getBean(jsonStr2, User.class);
        assertEquals("py", bean2.getUsername());
        assertEquals("py", bean2.getPassword());

        String jsonStr3 = "{'username': 'py', 'password': 'admin'}";
        User bean3 = GsonTool.getBean(jsonStr3, User.class);
        assertEquals("py", bean3.getUsername());
        assertEquals("admin", bean3.getPassword());

    }


    @Test
    public void testList(){
        String jsonStr1 = "[{'username': 'admin', 'password': 'admin'}, {'username': 'py', 'password': 'py'}, " +
                " {'username': 'py', 'password': 'admin'}]";

    }

}