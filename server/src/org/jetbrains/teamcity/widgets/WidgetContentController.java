

package org.jetbrains.teamcity.widgets;


import jetbrains.buildServer.controllers.AuthorizationInterceptor;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.WebControllerManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WidgetContentController extends BasePageContentController {


  @NotNull
  private final PluginDescriptor pluginDescriptor;

  /**
   * @param auth                - from standard TeamCity context
   * @param web                 - from standard TeamCity context
   * @param pagesContentUrlBase - URL part that will be used to create controller mapping
   */
  public WidgetContentController(@NotNull AuthorizationInterceptor auth,
                                 @NotNull WebControllerManager web,
                                 @NotNull PluginDescriptor pluginDescriptor,
                                 @NotNull String pagesContentUrlBase) {
    super(auth, web, pagesContentUrlBase);
    this.pluginDescriptor = pluginDescriptor;
  }


  @Override
  protected void writeResourceContent(@NotNull HttpServletRequest request,
                                      @NotNull HttpServletResponse response,
                                      @NotNull File file) throws IOException {
    InputStream stream = request.getServletContext().getResourceAsStream(file.getAbsolutePath());
    if (stream == null) {
      throw new IllegalArgumentException(String.format("Requested resource %s doesn't exist.", file.getAbsolutePath()));
    }
    FileCopyUtils.copy(new InputStreamReader(stream), response.getWriter());
  }

  @Override
  protected String getResourceBaseFolder() {
    return pluginDescriptor.getPluginResourcesPath();
  }

  @Override
  protected File getRequestedFile(@NotNull String requestedResource, @NotNull String requestedResourceBasePath) {
    return new File(pluginDescriptor.getPluginResourcesPath(requestedResource));
  }

  @Override
  protected boolean isLegalPath(@NotNull File maybeChild, @NotNull File possibleParent) throws IOException {
    final File parent = possibleParent.getCanonicalFile();
    File child = maybeChild.getCanonicalFile();
    while (child != null) {
      if (child.equals(parent)) {
        return true;
      }
      child = child.getParentFile();
    }
    return false;
  }


}