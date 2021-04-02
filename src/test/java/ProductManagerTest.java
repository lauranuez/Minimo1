import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductManagerTest {

    private int i = -1;

    @Before
    public void init(){
        this.i = 0;
    }

    @After
    public void reset(){
        this.i = -1;
    }

    @Test
    public void test1(){
        Assert.assertEquals(0,i);
        i = 100;
        Assert.assertEquals(100,i);
    }

    @Test
    public void test2(){
        Assert.assertEquals(0,i);
        i = 200;
        Assert.assertEquals(200,i);
    }
}
