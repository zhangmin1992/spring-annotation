package day11ForJidong;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class MyConditional implements Condition{

	@Override
	public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("profile.properties");
		Properties  prop = new Properties();
        try {
			prop.load(is);
			String masterName = prop.getProperty("redis");
			if(("1").equals(masterName)) {
				return true;
			}
		} catch (IOException e) {
		}
        return false;
	}

}
