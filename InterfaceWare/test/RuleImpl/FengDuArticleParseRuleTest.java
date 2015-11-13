package RuleImpl;

import junit.framework.TestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2015/10/31.
 */
public class FengDuArticleParseRuleTest extends TestCase {
    private String testurl="http://www.fengdu100.com/paoniu/yuehui/33849.html";
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetQueryTitleExpression() throws Exception {
        String titleExpression =new FengDuArticleParseRule().getQueryTitleExpression();
        String expecturl="http://www.fengdu100.com/paoniu/yuehui/33849_2.html";
        Document doc = Jsoup.connect(expecturl).timeout(5000).get();
        String title = doc.select(titleExpression).first().text();

        assertTrue(title.contains("宅男约会"));
        assertEquals(title,"宅男约会变魅力提升法则 做个有魅力的男人(2)");
    }

    @Test
    public void testGetQueryContentExpression() throws Exception {

    }

    @Test
    public void testGetPageurl() throws Exception {
        String getPageurl=new FengDuArticleParseRule().getPageurl(testurl,2);
        String expecturl="http://www.fengdu100.com/paoniu/yuehui/33849_2.html";
        assertEquals(expecturl,getPageurl);
    }

    @Test
    public void testHasNextPageExpression() throws Exception {

    }
}