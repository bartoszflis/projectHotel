package pl.coderslab.filters;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@WebFilter(urlPatterns = "/*")
public class Filtr extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (isAllowedOnlyForLoggedIn(httpServletRequest.getRequestURI(), httpServletRequest.getContextPath())
                && httpServletRequest.getSession().getAttribute("userSession") == null) { // test if user not logged in



            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
            return;
        }
        // handle being loggedin
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private boolean isAllowedOnlyForLoggedIn(String url, String contextPath) {
        boolean contains = url.matches("^" + contextPath + "\\/user\\/registerFirst.*$");
        boolean contains2 = url.matches("^" + contextPath + "\\/(;jsessionid=.+)?$");

        return !(contains || contains2);
    }





}