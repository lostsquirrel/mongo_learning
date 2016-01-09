package test.mongo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreeMarker {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");
		Template helloTpl;
		StringWriter sw = new StringWriter();
		Map<String, String> data = new HashMap<>();
		data.put("name", "Freemarker");
		try {
			helloTpl = cfg.getTemplate("hello.ftl");
			helloTpl.process(data, sw);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		System.out.println(sw);
	}
}
