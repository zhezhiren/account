package com.plj.common.tools.mybatis.autoBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class AutoBean
{
	public static void main(String[] args)
	{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("src/com/plj/common/tools/mybatis/autoBean/sys.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try
		{
			config = cp.parseConfiguration(configFile);
		    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		    MyBatisGenerator myBatisGenerator;
		    try
		    {
		    	myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		    	myBatisGenerator.generate(null);
		    } catch (Exception e)
		    {
		    	e.printStackTrace();
		    }
	    } catch (IOException e)
	    {
	    	e.printStackTrace();
	    } catch (XMLParserException e)
	    {
	    	e.printStackTrace();
	    }
	}
}
