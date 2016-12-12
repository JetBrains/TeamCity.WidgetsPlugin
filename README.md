TeamCity.WidgetsPlugin
=============================

The project is a basic TeamCity plugin wrapper that allows installing [TeamCity widgets](https://github.com/JetBrains/TeamCity.Widgets) to the server.

Download ready to install **widgets.zip** [here](https://teamcity.jetbrains.com/viewLog.html?buildId=415322&buildTypeId=TeamCityPluginsByJetBrains_Widgets_TeamCityWidgetsPlugin&tab=artifacts).

Install the plugin as described [in the TeamCity documentation](https://confluence.jetbrains.com/display/TCDL/Installing+Additional+Plugins)

Restart your server in order to see the plugin in action.

The currently available widgets are:

* Top TeamCity investigations  
  Shows 'TAKEN' TeamCity investigations grouped by assignee and ages  
  ``<TeamCity context path>/app/widgets/lastChanges/last_fullScreen.htm``

* Latest Changes   
  Shows the latest VCS commits  
  ``<TeamCity context path>/app/widgets/lastChanges/last_fullScreen.html``  
