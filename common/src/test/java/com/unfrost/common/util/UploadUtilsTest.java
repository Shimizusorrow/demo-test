package com.unfrost.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UploadUtilsTest {
    @Test
    void testStrings(){
        String a="132.png";
        System.out.println(a.substring(a.lastIndexOf(".")+1));
    }
}