package com.abel.spzxmodel.vo.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void testBuildWithResultCodeEnum() {
        
    }

    @Test
    void testFail() {
        Result<String> result = Result.fail("fail");
        Assertions.assertEquals(50000, result.getCode());
        Assertions.assertEquals("fail", result.getMessage());
        Assertions.assertNull(result.getData());
    }

    @Test
    void testFail2() {
        Result<String> result = Result.fail(50001, "fail");
        Assertions.assertEquals(50001, result.getCode());
        Assertions.assertEquals("fail", result.getMessage());
        Assertions.assertNull(result.getData());
    }

    @Test
    void testFail3() {
        Result<String> result = Result.fail(50000, "fail", "data");
        Assertions.assertEquals(50000, result.getCode());
        Assertions.assertEquals("fail", result.getMessage());
        Assertions.assertEquals("data", result.getData());
    }

    @Test
    void testSuccess() {
        Result<String> result = Result.success("success");
        Assertions.assertEquals(20000, result.getCode());
        Assertions.assertEquals("success", result.getMessage());
        Assertions.assertNull(result.getData());
    }

    @Test
    void testSuccess2() {
        Result<String> result = Result.success(new String("data"), 20000, "success");
        Assertions.assertEquals(20000, result.getCode());
        Assertions.assertEquals("success", result.getMessage());
        Assertions.assertEquals("data", result.getData());
    }

    @Test
    void testSuccess3() {
        Result<String> result = Result.success(null, 20000, "success");
        Assertions.assertEquals(20000, result.getCode());
        Assertions.assertEquals("success", result.getMessage());
        Assertions.assertNull(result.getData());
    }

}
