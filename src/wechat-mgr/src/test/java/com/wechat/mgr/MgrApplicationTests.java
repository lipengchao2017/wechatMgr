package com.wechat.mgr;

import com.wechat.mgr.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MgrApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testPassPWD(){
		String md5 = MD5Util.getMD5("pwd000000");
		System.out.println(md5);
	}

}
