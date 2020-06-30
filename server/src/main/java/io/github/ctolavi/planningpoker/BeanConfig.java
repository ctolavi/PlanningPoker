package io.github.ctolavi.planningpoker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

//    @Bean
//    public RouterFunction<ServerResponse> route() {
//        UserHandler userHandler = new UserHandler(userRepository);
//        return RouterFunctions
//                .route(POST("/users").and(contentType(APPLICATION_JSON)), userHandler::createUser)
//                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), userHandler::listUser)
//                .andRoute(GET("/users/{userId}").and(accept(APPLICATION_JSON)), userHandler::getUserById)
//                .andRoute(PUT("/users").and(accept(APPLICATION_JSON)), userHandler :: createUser)
//                .andRoute(DELETE("/users/userId").and(accept(APPLICATION_JSON)), userHandler :: deleteUser)
//                .andRoute(GET("/users/events/stream").and(accept(APPLICATION_JSON)), userHandler :: streamEvents);
//    }

}
