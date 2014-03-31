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

'use strict';

angular.module('changesApp.config', [])
        .constant('httpConfig', {
          headers: {
            'Accept': 'application/json'
          }
        })
        //.constant('config', {url: '/guestAuth/app/rest/changes', reload: 1000 * 5 * 60});
        /*.constant('config',{baseUrl: '/teamcity?url=',
                            pageUrl:'/guestAuth/app/rest/changes?locator=count:12,start:0',
                            sinceUrl:'/guestAuth/app/rest/changes?sinceChange=id:',
                            changeUrl:'/guestAuth/app/rest/changes/id:',
                            reload: 1000 * 1 * 60, maxCount: 10}); */
         .constant('config',{ baseUrl: '',
                              pageUrl:'/guestAuth/app/rest/changes?locator=count:12,start:0',
                              sinceUrl:'/guestAuth/app/rest/changes?sinceChange=id:',
                              changeUrl:'/guestAuth/app/rest/changes/id:',
                              funPatternsUrl:'patterns.json',
                              reload: 1000 * 1 * 60, maxCount: 10, funPatternsReload: 1000*30});
        //.constant('config',{url:'/changes.json', reload: 1000 * 1 * 30});
      

