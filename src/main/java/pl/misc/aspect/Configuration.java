package pl.misc.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.misc.aspect.model.Circle;
import pl.misc.aspect.model.Triangle;

@org.springframework.context.annotation.Configuration
@ComponentScan("pl.misc.aspect")
@EnableAspectJAutoProxy
public class Configuration {

    @Bean
    public Triangle createTriangle() {
        Triangle triangle = new Triangle();
        triangle.setName("Triangle Name");
        return triangle;
    }

    @Bean
    public Circle createCircle() {
        Circle circle = new Circle();
        circle.setName("Circle Name");
        return circle;
    }
}
