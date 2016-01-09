package test.mongo;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloSparkFreeMarker {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");
		StringWriter sw = new StringWriter();
		
		
		Spark.get("/", new Route(){

			@Override
			public Object handle(Request req, Response resp) throws Exception {
				Map<String, String> data = new HashMap<>();
				data.put("name", "Freemarker");
				final Template helloTpl = cfg.getTemplate("hello.ftl");
				helloTpl.process(data, sw);
				
				return sw;
			}
			
		});
	}
}
