TeamCity.WidgetsPlugin
=============================

The project is a basic TeamCity plugin wrapper that allows to install [TeamCity widgets](https://github.com/JetBrains/TeamCity.Widgets) to the server.

Read to install **widgets.zip** can be downloaded here: https://teamcity.jetbrains.com/viewLog.html?buildId=415322&buildTypeId=TeamCityPluginsByJetBrains_Widgets_TeamCityWidgetsPlugin&tab=artifacts

How to install plugin to TeamCity you can read here:

Please be aware that you need to restart your server in order to see the plugin in action.

Currently available widgets are:

* Top TeamCity investigations  
  Shows 'TAKEN' TeamCity investigations grouped by assignee and ages  
  ``<TeamCity context path>/app/widgets/lastChanges/last_fullScreen.htm``

* Latest Changes   
  Shows latest VCS commits  
  ``<TeamCity context path>/app/widgets/lastChanges/last_fullScreen.html``  