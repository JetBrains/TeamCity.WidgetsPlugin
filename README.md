TeamCity.WidgetsPlugin
=============================

The project is a basic TeamCity plugin wrapper that allows installing [TeamCity widgets](https://github.com/JetBrains/TeamCity.Widgets) to the server.

[Download](https://teamcity.jetbrains.com/app/rest/builds/buildType:(id:TeamCityPluginsByJetBrains_Widgets_TeamCityWidgetsPlugin),pinned:true/artifacts/content/widgets.zip) **widgets.zip** package from latest pinned build.

Install the plugin as described [in the TeamCity documentation](https://confluence.jetbrains.com/display/TCDL/Installing+Additional+Plugins)

Restart your server in order to see the plugin in action.

The currently available widgets are:

* Top TeamCity investigations  
  Shows 'TAKEN' TeamCity investigations grouped by assignee and ages  
  ``<TeamCity context path>/app/widgets/investigations/top_fullScreen.html``

* Latest Changes   
  Shows the latest VCS commits  
  ``<TeamCity context path>/app/widgets/lastChanges/last_fullScreen.html``  
