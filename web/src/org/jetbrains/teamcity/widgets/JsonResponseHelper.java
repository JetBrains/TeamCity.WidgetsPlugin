

package org.jetbrains.teamcity.widgets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.*;
import java.io.IOException;


public class JsonResponseHelper implements Servlet {
  public void init(ServletConfig servletConfig) throws ServletException {
  }

  public ServletConfig getServletConfig() {
    return null;
  }

  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    DefaultHttpClient client = new DefaultHttpClient();
    String url = servletRequest.getParameter("url");
    //HttpGet httpget = new HttpGet("http://buildserver/guestAuth/app/rest/investigations?locator=state:TAKEN");
    HttpGet httpget = new HttpGet("http://buildserver/" + url);
    httpget.setHeader("Accept", "application/json");

    HttpResponse response = client.execute(httpget);
    HttpEntity entity = response.getEntity();
    servletResponse.getWriter().write(EntityUtils.toString(entity));

  }


  public String getServletInfo() {
    return null;
  }


  public void destroy() {
  }
}