package de.aittr.team24_FP_backend.security.sec_config;

import de.aittr.team24_FP_backend.security.sec_filter.TokenFilter;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private TokenFilter filter;

    public SecurityConfig(TokenFilter filter) {
        this.filter = filter;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(x -> x
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers( "/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/user_login/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/example_parsing").permitAll()

                        .requestMatchers(HttpMethod.GET, "/{city}/restaurants_info").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/shops_info").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/children_info").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/doctors_info").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/hair_beauty_info").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/legal_services_info").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/pharmacies_info").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/translators_info").permitAll()

                        .requestMatchers(HttpMethod.GET, "/{city}/restaurants_info/find_by_title/{title}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/shops_info/find_by_title/{title}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/children_info/find_by_title/{title}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/doctors_info/find_by_title/{title}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/hair_beauty_info/find_by_title/{title}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/legal_services_info/find_by_title/{title}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/pharmacies_info/find_by_title/{title}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/{city}/translators_info/find_by_title/{title}").permitAll()

                        .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/refresh").permitAll()
                        .anyRequest().authenticated())
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }


}