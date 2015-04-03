package xiaoyun.javase.proxy;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class DPTest extends TestCase {

    @Test
    public void testExecuteQuery() throws Exception {
        assertNotNull(DP.ExecuteQuery("tmp/testDP"));
    }
}