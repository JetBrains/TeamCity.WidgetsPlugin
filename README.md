TeamCity.WidgetsPlugin 
=============================

[Build status: ](https://teamcity.jetbrains.com/viewType.html?buildTypeId=TeamCityPluginsByJetBrains_Widgets_TeamCityWidgetsPlugin)![](http://teamcity.jetbrains.com/app/rest/builds/buildType:TeamCityPluginsByJetBrains_Widgets_TeamCityWidgetsPlugin/statusIcon)

The project is a basic TeamCity plugin wrapper that allows installing [TeamCity widgets](https://github.com/JetBrains/TeamCity.Widgets) to the server.

To install the plugin, upload the
[widgets.zip](https://teamcity.jetbrains.com/viewLog.html?buildId=415322&buildTypeId=TeamCityPluginsByJetBrains_Widgets_TeamCityWidgetsPlugin&tab=artifacts)
at 'Administration > Plugins List' or put it into &lt;TeamCity data
dir>/plugins dir and restart the TeamCity server.

The currently available widgets are:

* Top TeamCity investigations  
  Shows 'TAKEN' TeamCity investigations grouped by assignee and ages  
  ``<TeamCity context path>/app/widgets/lastChanges/last_fullScreen.htm``

* Latest Changes   
  Shows the latest VCS commits  
  ``<TeamCity context path>/app/widgets/lastChanges/last_fullScreen.html``  
