TeamCity Widgets Plugin
=============================
TeamCity html widgets framework.

Widgets
=======
1. TeamCity investigations - shows 'TAKEN' TeamCity investigations grouped by assignee and ages.
Widget is available under <TeamCity context path>/app/widgets/investigation/tv.html

Implementation details:
- current implementation is based on angular js and d3js
- config.js contains widget config including URL to retrieve the investigation details from server

Lifecycle:
On page load local storage will be checked and cached data will be displayed (if found). It helps to avoid delays during loading data via REST request.
New data will be retrieved every 5 minutes (you can change the value in widget config) and view will be updated.


New widget development
======================
To create new widget add a folder under resources directory. Please there all files you want to be accessible as static resources under
<TeamCity context path>/app/widgets/<new widget>/ path.
To handle easily data update during development you don't need to add compiled plugin to your TeamCity data directory. You can use 'web' module and provided 'web' run configuration to make your widget available on your local server.
Check JsonResponseWrapper class and configure access to the TeamCity you want grab data from. You can use the data comes from real TeamCity under /teamcity path directly on your local server. It helps to avoid all cross-path related issue during development stage.
When you widget is ready - package the plugin (use 'Build artifact - plugin.zip' option) and add to your real TeamCity installation.


License:
========
Apache 2.0
