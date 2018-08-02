package day08Conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class MyCondition2 implements Condition{

	/**
	 * 根据上下文决定是否装配bean
	 */
	@Override
	public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
		String value = context.getEnvironment().getProperty("os.name");
		if("Linix".equals(value)) {
			return true;
		}else {
			return false;
		}
	}
}
