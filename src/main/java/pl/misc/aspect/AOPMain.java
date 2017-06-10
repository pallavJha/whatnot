package pl.misc.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.misc.aspect.service.ShapeService;

/**
 * @author pallav
 * @version 1.0
 * @since 10/6/17
 */
public class AOPMain {

    private AOPMain() {

    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        ShapeService shapeService = context.getBean(ShapeService.class);

        //System.out.println(shapeService.getCircle().getName());
        shapeService.getCircle().rollCircleRoll();

    }
}
