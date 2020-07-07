package dyliang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition1 implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        return true;
    }
}
