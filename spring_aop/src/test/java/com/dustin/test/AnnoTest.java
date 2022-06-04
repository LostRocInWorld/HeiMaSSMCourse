package com.dustin.test;

import com.dustin.anno.config.SpringConfig;
import com.dustin.anno.target.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Classname Apptest
 * @Descrption TODO
 * @Date 2021/8/1上午 02:58
 * @Created By Dustin_Peng
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.dustin.anno.config.SpringConfig.class})
public class AnnoTest {
    @Autowired
    @Qualifier("target")
    private TargetInterface target;

    @Test
    public void targetTest(){
        target.save();
    }
}
