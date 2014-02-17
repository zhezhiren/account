package com.test.action.test7;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.test.common.JUnitActionBase;

public class Test7ActionTest extends JUnitActionBase{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void testBefore()
	{
		MockHttpServletRequest request = new MockHttpServletRequest();  
        MockHttpServletResponse response = new MockHttpServletResponse();  
        request.setRequestURI("/test7/testBefore.json");  
        request.addParameter("id", "1002");
        request.addParameter("date", "2010-12-30");
        request.setMethod("POST");
		
        try 
        {
			final ModelAndView mav = excuteAction(request, response);
			System.out.println(response.getContentAsString());
			assertEquals("{\"name\":\"name\",\"value\":\"value\"}", response.getContentAsString());
			
			System.out.println(response.getContentType());
			assertEquals("application/json;charset=UTF-8", response.getContentType());
			
		} catch (IOException e) 
		{
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore("还没实现")
	public void testAround()
	{
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore("还没实现")
	public void testAfter()
	{
		fail("Not yet implemented");
	}

}
