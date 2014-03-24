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

import org.glassfish.jersey.internal.util.Base64;

import javax.servlet.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;



public class JsonResponseWrapper implements Servlet {
  public void init(ServletConfig servletConfig) throws ServletException {
  }

  public ServletConfig getServletConfig() {
    return null;
  }

  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    Client client = ClientBuilder.newBuilder().build();
    Response response = client.target("http://buildserver/app/rest/")
            .path("investigations")
            .queryParam("locator", "state:TAKEN")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header("Authorization", "Basic " + new String(Base64.encode("<user name>:<password>".getBytes())))
            .get();

    servletResponse.getWriter().write(response.readEntity(String.class));
  }


  public String getServletInfo() {
    return null;
  }


  public void destroy() {
  }
}
