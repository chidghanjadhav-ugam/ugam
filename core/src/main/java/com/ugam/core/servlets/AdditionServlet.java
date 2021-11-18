package com.ugam.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = ("/bin/additionServlet")
)
public class AdditionServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws IOException{
        int first = Integer.parseInt(request.getParameter("first"));
        int second = Integer.parseInt(request.getParameter("second"));
        int answer = first+second;
        response.getWriter().println(answer);
    }
}
