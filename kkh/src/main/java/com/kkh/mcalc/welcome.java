package com.kkh.mcalc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class welcome
{
	@RequestMapping("/welcome")
	public @ResponseBody String greeting()
	{
		return  "Hello AngularSpringboot";
	}

}
