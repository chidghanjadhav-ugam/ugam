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
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        int value1 = Integer.parseInt(first);
        int value2 = Integer.parseInt(second);
        int answer = value1+value2;
        response.getWriter().println(answer);
    }
}
