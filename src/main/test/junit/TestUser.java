package junit;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.hanains.mysite.service.UserService;
import com.hanains.mysite.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:webapp/WEB-INF/applicationContext.xml"})
//@ContextConfiguration({ "classpath*:applicationContext.xml" })
public class TestUser {

	private UserVo user;
	private UserVo user1;
	private UserVo user2;
	
	@Autowired
	private UserService userService;
	
	//execute only once, in the starting 
	@BeforeClass 
	public static void beforeClass() { 
		System.out.println("in before class"); 
	}

	//execute only once, in the end 
	@AfterClass 
	public static void afterClass() { 
		System.out.println("in after class"); 
	}
	
	//execute for each test, before executing test
	@Before
	public void setUp(){
		System.out.println("in before");
		this.user = new UserVo();
		user.setName("kim");
		user.setEmail("123@na.om");
		user.setPassword("1234");
		user.setGender("d");
		
		this.user1 = new UserVo();
		user1.setName("min");
		user1.setEmail("456@na.om");
		user1.setPassword("5678");
		user1.setGender("dd");
		
		this.user2 = new UserVo();
		user2.setName("min");
		user2.setEmail("456@na.om");
		user2.setPassword("5678");
		user2.setGender("dd");
	}
	
	//execute for each test, after executing test 
	@After 
	public void after() { 
		System.out.println("in after"); 
		
		user.setPassword("1234");
		user1.setPassword("5678");
		user2.setPassword("5678");
		
		userService.deleteMember(user);
		userService.deleteMember(user1);
		userService.deleteMember(user2);
	}
	
	@Test(timeout=800)
	public void testadd1() {
		userService.join(user);
	}
	
	@Test
	public void testadd2() {
		userService.join(user1);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testadd3() {
		userService.join(user2);
	}
	
	
	@Test 
	public void testCase1() { 
		System.out.println(user);
		System.out.println(user1);
	}

}