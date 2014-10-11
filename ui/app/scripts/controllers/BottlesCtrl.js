'use strict';

angular.module('vin.io')
    .controller('BottlesCtrl', function ($scope, Bottle) {

        $scope.bottles = Bottle.query();

        $scope.colors = ['RED', 'WHITE', 'ROSE'];

        $scope.openDetail = function (bottle) {
            $scope.selection = bottle;
        };

        $scope.edit = function (bottle) {
            Bottle.save(bottle).$promise
                .then(function () {
                    alert("Bottle updated");
                })
                .catch(function () {
                    alert("Error");
                });
        };
    });