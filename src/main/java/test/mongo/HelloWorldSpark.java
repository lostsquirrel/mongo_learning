package test.mongo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.utils.StringUtils;

public class HelloWorldSpark {

	private Configuration cfg; 
	public HelloWorldSpark() {
		cfg = new Configuration();
		cfg.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");
		
	}
	
	public static void main(String[] args) {
		HelloWorldSpark hs = new HelloWorldSpark();
		Spark.get("/", new Route(){

			@Override
			public Object handle(Request req, Response resp) throws Exception {
				return "hello World from Spark!";
			}
			
		});
		
		Spark.get("/test", (req, resp)-> "This is a test page!"); 
		
		Spark.get("/echo/:thing", (req, resp)-> req.params(":thing"));
		
		
		Spark.get("/form", (req, resp)-> hs.getForm());
		
		Spark.post("/form", (req, resp)-> {
			String fruit = req.queryParams("fruit");
			if (StringUtils.isNotEmpty(fruit)) {
				return "Your favorite fruit is " + fruit;
			} else {
				return "Your did not pick any fruit";
			}
			
		});
		
	}
	
	public Object getForm() {
		StringWriter sw = new StringWriter();
		Map<String, String[]> data = new HashMap<>();
		data.put("fruits", new String[]{"apple", "banana", "orange", "peach"});
		Template helloTpl;
		try {
			helloTpl = cfg.getTemplate("form.ftl");
			helloTpl.process(data, sw);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return sw;
	}
}
