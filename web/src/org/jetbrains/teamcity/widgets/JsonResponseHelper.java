/*
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    HttpGet httpget = new HttpGet("http://buildserver/app/rest/investigations");
    httpget.setHeader("Authorization", "Basic <encoded credentials>");
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
