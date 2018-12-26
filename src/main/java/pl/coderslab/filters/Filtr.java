package pl.coderslab.filters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.coderslab.repository.UserRepository;


import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.web.servlet.config.TilesConfigurerBeanDefinitionParser.BEAN_NAME;


@WebFilter(urlPatterns = "/jhkh")
public class Filtr extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        if (isAllowedOnlyForLoggedIn(httpServletRequest.getRequestURI().toString(), httpServletRequest.getContextPath())
                && httpServletRequest.getSession().getAttribute("email") == null) { // test if user not logged in


            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
            return;
        }
        // handle being loggedin
        System.out.println("allow");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private boolean isAllowedOnlyForLoggedIn(String url, String contextPath) {
        Set<String> allowedWithoutBeingLoggedIn = new HashSet<>(Arrays.asList(
                contextPath + "/", contextPath + "/user/register"));

        return !allowedWithoutBeingLoggedIn.contains(url);
    }





}