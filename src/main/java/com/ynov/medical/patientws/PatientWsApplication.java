package com.ynov.medical.patientws;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
// import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
// import static org.springframework.web.reactive.function.server.RouterFunctions.route;
// import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
// import org.springframework.web.reactive.function.server.RouterFunction;
// import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class PatientWsApplication {

	// @Bean
	// @ConditionalOnProperty(
	// 	value = "spring.cloud.gcp.firestore.emulator.enabled",
	// 	havingValue = "true")
	// public CredentialsProvider googleCredentials() {
	//   return NoCredentialsProvider.create();
	// }
	
	public static void main(String[] args) {
		SpringApplication.run(PatientWsApplication.class, args);
	}

// 	@Bean
//   public RouterFunction<ServerResponse> indexRouter(
//       @Value("classpath:/static/index.html") final Resource indexHtml) {

//     // Serve static index.html at root, for convenient message publishing.
//     return route(GET("/"), request -> ok().contentType(MediaType.TEXT_HTML).bodyValue(indexHtml));
//   }

}
