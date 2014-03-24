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

angular.module('investigationsApp.controllers', ['investigationsApp.services'])
    .controller('LoaderCtrl', ['$scope', '$log', '$http', '$timeout', '$localStorage', 'Loader', 'config',
        function ($scope, $log, $http, $timeout, $localStorage, Loader, config) {
            var schedule = function () {
                $timeout(function () {
                    loadInvestigations();
                }, config.reload);
                $log.debug("Next update was scheduled");
            };
            var loadInvestigations = function () {
                $log.debug('controller.loadInvestigations starts...');
                var promise = Loader.externalLoad();
                promise.then(
                    function (data) {
                        clearCache();
                        $localStorage.investigations = data;
                        $log.debug("--Saved to local storage -" + $localStorage.investigations);
                        $scope.data = data;
                    },
                    function (reason) {
                        $log.error('Failed: ' + reason);
                    }
                );
                schedule();
            };

            var clearCache = function () {
                $log.debug("--Clean local storage -");
                delete $localStorage.investigations;
            };

            var storedData = $localStorage.investigations;
            $log.debug("--Restored from local storage -" + storedData);
            if (storedData === undefined) {
                loadInvestigations($http, $timeout);
            } else {
                $scope.data = storedData;
                schedule();
            }
        }])
;


