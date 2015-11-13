package me.fengdu;

import RuleImpl.FengDuArticleParseRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Administrator on 2015/11/2.
 */
public class ParserArticleTest {
    @Before
    public void setUp() throws Exception {
        ParserArticle(new FengDuArticleParseRule(),"http://www.fengdu100.com/paoniu/yuehui/33611.html");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParserTitle() throws Exception {

    }

    @Test
    public void testParserContext() throws Exception {

    }

    @Test
    public void testHasNextpage() throws Exception {

    }
}